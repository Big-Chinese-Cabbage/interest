<template>
    <div style="margin: 20px;">
        <div>
            <ul>
                <li>
                    <Button type="primary" icon="plus-round" @click="openNewModal()">新建</Button>
                    <Button type="success" icon="wrench" @click="openModifyModal()">修改</Button>
                    <Button type="error" icon="trash-a" @click="del()">删除</Button>
                </li>
                <li>
                    <div style="padding: 10px 0;">
                        <Table border :columns="columns1" :data="data1" :height="400" @on-selection-change="s=>{change(s)}" @on-row-dblclick="s=>{dblclick(s)}"></Table>
                    </div> 
                </li>
                <li>
                    <div style="text-align: right;">
                        <Page :total="total" :page-size="pageInfo.pageSize" show-elevator show-total @on-change="e=>{pageSearch(e)}"></Page>
                    </div>  
                </li>
            </ul>
        </div>
        <!--添加modal-->  
        <Modal :mask-closable="false" :visible.sync="newModal" :loading = "loading" v-model="newModal" width="600" title="新建" @on-ok="newOk('roleNew')" @on-cancel="cancel()">
            <Form ref="roleNew" :model="roleNew" :rules="ruleNew" :label-width="80" >
                <Row>
                    <Col span="12">
                        <Form-item label="角色:" prop="role">
                            <Input v-model="roleNew.role" style="width: 204px"/>
                        </Form-item>
                    </Col>
                    <Col span="12">
                         <Form-item label="角色名:" prop="name">
                            <Input v-model="roleNew.name" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
               
                <Form-item label="描述:" prop="describe">
                     <Input v-model="roleNew.describe" type="textarea" :autosize="{minRows: 2,maxRows: 5}"></Input>
                </Form-item>
            </Form>
        </Modal>
        <!--修改modal-->  
        <Modal :mask-closable="false" :visible.sync="modifyModal" :loading = "loading" v-model="modifyModal" width="600" title="修改" @on-ok="modifyOk('roleModify')" @on-cancel="cancel()">
            <Form ref="roleModify" :model="roleModify" :rules="ruleModify" :label-width="80" >
                <Row>
                    <Col span="12">
                        <Form-item label="角色:" prop="role">
                            <Input v-model="roleModify.role" style="width: 204px"/>
                        </Form-item>
                    </Col>
                    <Col span="12">
                         <Form-item label="角色名:" prop="name">
                            <Input v-model="roleModify.name" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <!-- <Form-item label="角色名:" prop="name">
                            <Input v-model="roleModify.name" style="width: 204px"/>
                        </Form-item> -->
                <Form-item label="描述:" prop="describe">
                     <Input v-model="roleModify.describe" type="textarea" :autosize="{minRows: 2,maxRows: 5}"></Input>
                </Form-item>
            </Form>
        </Modal>
        <!-- 配置权限 -->
        <Modal v-model="settingModal"  width="400" title="配置权限" @on-ok="settingOk()" @on-cancel="cancel()" :mask-closable="false">
            <Row>
                <Col span="24"><Table border :columns="columns2" :data="data2"></Table></Col>
            </Row>
        </Modal>
    </div>
</template>
<script>
    export default {
        data () {
            return {
                /*选择的数量*/
                count:null,
                /*选中的组数据*/
                groupId:null,
                /*新建modal的显示参数*/
                newModal:false,
                /*修改modal的显示参数*/
                modifyModal:false,
                /*权限modal的显示参数*/
                settingModal:false,
                /*分页total属性绑定值*/
                total:0,
                /*loading*/
                loading: true,
                /*pageInfo实体*/
                pageInfo:{
                    page:0,
                    pageSize:10
                },
                /*role实体*/
                role:{                             
                    id:null,
                    role:null,
                    name:null,
                    modules:null,
                    describe:null
                },
                /*用于添加的role实体*/
                roleNew:{
                    id:null,
                    role:null,
                    name:null,
                    modules:null,
                    describe:null
                },
                /*用于修改的role实体*/
                roleModify:{
                    id:null,
                    role:null,  
                    name:null,
                    modules:null,
                    describe:null
                },
                /*新建验证*/
                ruleNew:{
                    role: [
                        { type:'string',required: true, message: '输入角色', trigger: 'blur' }
                    ],
                    name: [
                        { type:'string',required: true, message: '输入角色名', trigger: 'blur' }
                    ]
                },
                /*修改验证*/
                ruleModify:{
                    role: [
                        { type:'string',required: true, message: '输入角色', trigger: 'blur' }
                    ],
                    name: [
                        { type:'string',required: true, message: '输入角色名', trigger: 'blur' }
                    ]
                },
                /*表显示字段*/
                columns1: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                        title: '角色',
                        key: 'role'
                    },
                    {
                        title: '角色名',
                        key: 'name'
                    },
                    {
                        title: '描述',
                        key: 'describe'
                    },
                    {   title: '操作', 
                        key: 'action', 
                        width: 180, 
                        align: 'center', 
                        render: (h, params) => { 
                            return h('div', [ h('Button', 
                                { 
                                    props: { icon:'gear-b' },
                                    style: {border:'none',background:'none' }, 
                                    on: { 
                                        click: () => { 
                                            this.setting(params.row);
                                        } 
                                    } 
                                }, ) 
                            ]); 
                        } 
                    }
                ],
                /*表数据*/
                data1: [],
                /*表显示字段*/
                columns2: [
                    {
                        title: '权限',
                        key: 'name'
                    },
                    {
                        title: '操作',
                        align: 'center',
                        render: (h, params) => {
                            return h('div',[
                                h('i-switch',{
                                    attrs:{
                                        'value' : params.row.value 
                                    },
                                    on:{
                                        'on-change':(val)=>{
                                            var i = this.moduleArr.indexOf(params.row.id+'');
                                            if(val){
                                                if(i == -1){
                                                    this.moduleArr.push(params.row.id+'');
                                                }
                                            }else{
                                                if(i != -1){
                                                    this.moduleArr.splice(i,1);
                                                }
                                            }
                                        }
                                    }
                                })
                            ]);
                        }
                    }
                ],
                /*表数据*/
                data2: [],
                /*临时存储权限的数组*/
                moduleArr:[],
                /*二级菜单列表*/
                submenusList:[]
            }
        },
        mounted(){
            /*页面初始化调用方法*/
            this.getTable({
                "pageInfo":this.pageInfo
            });
            this.axios({
              method: 'get',
              url: '/menus/submenus'
            }).then(function (response) {
                this.submenusList = response.data;
            }.bind(this)).catch(function (error) {
              alert(error);
            });
        },
        methods:{
            /*pageInfo实体初始化*/
            initPageInfo(){
                this.pageInfo.page = 0;
                this.pageInfo.pageSize = 10;
            },
            /*role实体初始化*/
            initRole(){
                this.role.id = null;
                this.role.role = null;
                this.role.name = null;
                this.role.modules = null;
                this.role.describe = null;
            },
            /*roleNew实体初始化*/
            initRoleNew(){
                this.roleNew.id = null;
                this.roleNew.role = null;
                this.roleNew.name = null;
                this.roleNew.modules = null;
                this.roleNew.describe = null;
            },
            /*roleModify实体初始化*/
            initRoleModify(){
                this.roleModify.id = null;
                this.roleModify.role = null;
                this.roleModify.name = null;
                this.roleModify.modules = null;
                this.roleModify.describe = null;
            },
            /*roleNew设置*/
            roleSet(e){
                this.role.id = e.id;
                this.role.role = e.role;
                this.role.name = e.name;
                this.role.modules = e.modules;
                this.role.describe = e.describe;
            },
            /*roleNew设置*/
            roleNewSet(e){
                this.roleNew.id = e.id;
                this.roleNew.role = e.role;
                this.roleNew.name = e.name;
                this.roleNew.modules = e.modules;
                this.roleNew.describe = e.describe;
            },
            /*roleModify设置*/
            roleModifySet(e){
                this.roleModify.id = e.id;
                this.roleModify.role = e.role;
                this.roleModify.name = e.name;
                this.roleModify.modules = e.modules;
                this.roleModify.describe = e.describe;
            },
            /*得到表数据*/
            getTable(e) {
                this.axios({
                  method: 'get',
                  url: '/roles',
                  params: {
                    'page':e.pageInfo.page,
                    'pageSize':e.pageInfo.pageSize
                  }
                }).then(function (response) {
                    this.data1=response.data.data;
                    this.total=response.data.totalCount;
                }.bind(this)).catch(function (error) {
                  alert(error);
                });
            },
            /*分页点击事件*/
            pageSearch(e){
                this.pageInfo.page = e-1;
                this.getTable({  
                    "pageInfo":this.pageInfo
                });
            },
            /*新建点击触发事件*/
            openNewModal(){
                this.newModal = true;
                this.initRoleNew();
                this.data1.sort();
                this.count = 0;
                this.groupId = null;
            },
            /*新建modal的newOk点击事件*/
            newOk (roleNew) { 
                this.$refs[roleNew].validate((valid) => {
                    if (valid) {
                        this.initRole();
                        this.roleSet(this.roleNew);
                        this.axios({
                            method: 'post',
                            url: '/roles/role',
                            data: this.role
                        }).then(function (response) {
                            this.initRoleNew();
                            this.getTable({
                                "pageInfo":this.pageInfo
                            });
                            this.$Message.info('新建成功');
                        }.bind(this)).catch(function (error) {
                            alert(error);
                        });  
                        this.newModal = false;
                    }else {
                        setTimeout(() => {
                            this.loading = false;
                            this.$nextTick(() => {
                                this.loading = true;
                            });
                        }, 1000);
                    }
                })
            },
            /*点击修改时判断是否只选择一个*/
            openModifyModal(){
                if(this.count > 1 || this.count < 1){
                    this.modifyModal= false; 
                    this.$Message.warning('请至少选择一项(且只能选择一项)');  
                }else{
                    this.modifyModal = true;
                }
            },
            /*修改modal的modifyOk点击事件*/
             modifyOk (roleModify) { 
                this.$refs[roleModify].validate((valid) => {
                    if (valid) {
                        this.initRole();
                        this.roleSet(this.roleModify);
                        this.axios({
                          method: 'put',
                          url: '/roles/'+this.role.id,
                          data: this.role
                        }).then(function (response) {
                            this.initRoleModify();
                            this.getTable({
                                "pageInfo":this.pageInfo
                            });
                            this.$Message.info('修改成功');
                        }.bind(this)).catch(function (error) {
                          alert(error);
                        });  
                        this.modifyModal = false;
                    }else {
                        this.$Message.error('表单验证失败!');
                        setTimeout(() => {
                            this.loading = false;
                            this.$nextTick(() => {
                                this.loading = true;
                            });
                        }, 1000);
                    }
                })
            },
            /*表格中按钮点击事件*/
            setting(e){
                this.data1.sort();
                this.settingModal = true;
                this.roleModifySet(e);
                if(e.modules == null || e.modules == ''){
                    this.moduleArr = [];
                }else{
                    this.moduleArr = e.modules.split(";");
                }
                var data2Temp = [];
                for (var i = 0; i < this.submenusList.length; i++) {
                    if(this.moduleArr.indexOf(this.submenusList[i].id+'') == -1){
                        data2Temp.push({
                            'id': this.submenusList[i].id,
                            'name': this.submenusList[i].name,
                            'value': false
                        });
                    }else{
                        data2Temp.push({
                            'id': this.submenusList[i].id,
                            'name': this.submenusList[i].name,
                            'value': true
                        });
                    }
                }
                this.data2 = data2Temp;
            },
            /*配置权限的settingOk点击事件*/
            settingOk(){
                var temp = "";
                for(var i in this.moduleArr){
                    if(this.moduleArr[i] != '' && this.moduleArr != null){
                        temp = temp + this.moduleArr[i]+";";
                    }
                }
                this.roleModify.modules = temp;
                this.initRole();
                this.roleSet(this.roleModify);
                this.axios({
                  method: 'put',
                  url: '/roles/'+this.role.id,
                  data: this.role
                }).then(function (response) {
                    this.initRoleModify();
                    this.getTable({
                        "pageInfo":this.pageInfo
                    });
                    this.$Message.info('配置成功');
                }.bind(this)).catch(function (error) {
                  alert(error);
                });
            },
            /*modal的cancel点击事件*/
            cancel () {
                this.$Message.info('点击了取消');
            },
            /*table选择后触发事件*/
            change(e){
                if(e.length==1){
                    this.roleModifySet(e['0']);
                }
                this.setGroupId(e);              
            },
            /*通过选中的行设置groupId的值*/
            setGroupId(e){
                this.groupId=[];
                this.count=e.length;
                for (var i = 0; i <= e.length - 1; i++) {
                    this.groupId.push(e[i].id);
                }
            },
            /*删除table中选中的数据*/
            del(){
                if(this.groupId!=null && this.groupId!=""){
                    this.axios({
                      method: 'delete',
                      url: '/roles',
                      data: this.groupId
                    }).then(function (response) {
                        this.getTable({
                            "pageInfo":this.pageInfo
                        });
                        this.groupId=null;
                        this.count=0;
                        this.$Message.info('删除成功');
                    }.bind(this)).catch(function (error) {
                        alert(error);
                    });
                }
            },
            /*表格中双击事件*/
            dblclick(e){
                this.roleModifySet(e);
                this.modifyModal = true;
                this.data1.sort();
            }
        }
    }
</script>