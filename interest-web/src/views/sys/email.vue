<template>
	<div style="margin: 20px;">
        <div>
            <ul>
                <li>
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
        <Modal :mask-closable="false" :visible.sync="modal" v-model="modal" width="600" title="查看">
	        <Form :label-width="80" >
	        	<Form-item label="登录名:">
	        		<strong>{{email.username}}</strong>
                    <!-- <Input v-model="email.username" style="width: 204px" disabled="disabled" /> -->
                </Form-item>
                <Form-item label="内容:">
                	<span>{{email.content}}</span>
                    <!-- <Input v-model="email.username" style="width: 204px" disabled="disabled" /> -->
                </Form-item>
            </Form>
	        <div slot="footer">
	            <Button type="error" size="large"  @click="cancel">关闭</Button>
	        </div>
	    </Modal>	
    </div>
</template>
<script>
	export default {
        data () {
            return {
                /*修改modal的显示参数*/
                modal:false,
            	/*分页total属性绑定值*/
                total:0,
                /*pageInfo实体*/
                pageInfo:{
                	page:0,
                	pageSize:10
                },
                /*user实体*/
                email:{
                    id:null,
                    username:null,
                    title:null,
                    email:null,
                    name:null,
                    content:null,
                    createtime:null
                },
            	/*表显示字段*/
            	columns1: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                        title: '姓名',
                        key: 'name'
                    },
                    {
                        title: '标题',
                        width: 500,
                        key: 'title'
                    },
                    {
                        title: 'email',
                        key: 'email'
                    },
                    {
                        title: '时间',
                        key: 'createtime'
                    },
                    {
                        title: '操作',
                        align: 'center',
                        key: 'action',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'info',
                                    },
                                    on: {
                                        click: () => {
                                            this.emailInfo(params.row);
                                        }
                                    }
                                },'查看')
                            ]);
                        }
                    }
                ],
                /*表数据*/
                data1: []
            }
        },
        mounted(){
        	/*页面初始化调用方法*/
            this.getTable({
                "pageInfo":this.pageInfo
            });
        },
        methods:{
        	/*pageInfo实体初始化*/
        	initPageInfo(){
        		this.pageInfo.page = 0;
        		this.pageInfo.pageSize = 10;
        	},
            emailSet(e){
                this.email.id = e.id;
                this.email.username = e.username;
                this.email.title = e.title;
                this.email.email = e.email;
                this.email.name = e.name;
                this.email.content = e.content;
                this.email.createtime = e.createtime;
            },
            dateGet(e){
                var time = new Date(parseInt(e));
                return time.getFullYear()+"-"+(time.getMonth()+1)+"-"+time.getDate()+" "+time.getHours()+":"+time.getMinutes(); 
            },
            listDateSet(e){
                for (var i = e.length - 1; i >= 0; i--) {
                    e[i].createtime = this.dateGet(e[i].createtime);
                }
            },
            /*得到表数据*/
            getTable(e) {
                this.axios({
                  method: 'get',
                  url: '/emails',
                  params: {
                    'page':e.pageInfo.page,
                    'pageSize':e.pageInfo.pageSize
                  }
                }).then(function (response) {
                    this.data1=response.data.data;
                    this.listDateSet(this.data1);
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
            /*modal的cancel点击事件*/
            cancel () {
				this.modal = false;                
            },
            /*表格中双击事件*/
            dblclick(e){
                this.emailSet(e);
            	this.modal = true;
            },
            emailInfo(e){
            	this.emailSet(e);
            	this.modal = true;
            },
            del(){
                if(this.groupId!=null && this.groupId!=""){
                    this.axios({
                      method: 'delete',
                      url: '/admin/emails',
                      data: this.groupId
                    }).then(function (response) {
                        this.getTable({
                            "pageInfo":this.pageInfo
                        });
                        this.groupId=[];
                        this.$Message.info('删除成功');
                    }.bind(this)).catch(function (error) {
                        alert(error);
                    });
                }
            },
            change(e){
                this.setGroupId(e);              
            },
            setGroupId(e){
                this.groupId=[];
                for (var i = 0; i <= e.length - 1; i++) {
                    this.groupId.push(e[i].id);
                }
            },
        }
    }
</script>