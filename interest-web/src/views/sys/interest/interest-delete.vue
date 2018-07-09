<template>
	<div style="margin: 40px;">
        <div>
            <ul>
            	<li>
                    <Button type="error" icon="trash-a" @click="del()">删除</Button>
                </li>
                <li>
                    <div style="padding: 10px 0;">
                    	<Table border :columns="columns1" :data="data1" :height="400" @on-selection-change="s=>{change(s)}"></Table>
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
	        		<strong>{{postcard.username}}</strong>
                    <!-- <Input v-model="email.username" style="width: 204px" disabled="disabled" /> -->
                </Form-item>
                <Form-item label="内容:">
                	<span>{{postcard.content}}</span>
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
            	groupId:[],
                modal:false,
            	/*分页total属性绑定值*/
                total:0,
                /*pageInfo实体*/
                pageInfo:{
                	page:0,
                	pageSize:10
                },
                /*user实体*/
                postcard:{
                    id:null,
                    username:null,
                    title:null,
                    interestid:null,
                    content:null,
                    createtime:null,
                    replytime:null
                },
            	/*表显示字段*/
            	columns1: [
            		{
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                        title: 'ID',
                        key: 'id',
                        width: 100
                    },
                    {
                        title: '标题',
                        key: 'title',
                        width: 150
                    },
                    {
                        title: '简介',
                        key: 'info'
                    },
                    {
                        title: '排序',
                        key: 'sort',
                        width: 100
                    },
                    {
                        title: '操作',
                        align: 'center',
                        key: 'action',
                        width: 100,
                        render: (h, params) => {
                            return h('a',
                                {
                                    attrs:{
                                        href:this.$store.state.domainName+'/page/detail/'+params.row.id,
                                        target:'_blank'
                                    }
                                }
                                , [
                                    h('Button', {
                                        props: {
                                            type: 'info',
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
            this.axios({
                method: 'get',
                url: '/public/interests'
            }).then(function (response) {
                this.interestList = response.data;
            }.bind(this)).catch(function (error) {
                alter(error);
            }.bind(this));
        },
        methods:{
        	/*pageInfo实体初始化*/
        	initPageInfo(){
        		this.pageInfo.page = 0;
        		this.pageInfo.pageSize = 10;
        	},
            postcardSet(e){
                this.postcard.id = e.id;
                this.postcard.username = e.username;
                this.postcard.title = e.title;
                this.postcard.interestid = e.interestid;
                this.postcard.content = e.content;
                this.postcard.createtime = e.createtime;
                this.postcard.replytime = e.replytime;
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
                  url: '/admin/interests',
                  params: {
                    'page':e.pageInfo.page,
                    'pageSize':e.pageInfo.pageSize
                  }
                }).then(function (response) {
                    this.data1=response.data.data;
                    // this.listDateSet(this.data1);
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
                this.postcardSet(e);
            	this.modal = true;
            },
            del(){
                if(this.groupId!=null && this.groupId!=""){
                    this.axios({
                      method: 'delete',
                      url: '/admin/interests',
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