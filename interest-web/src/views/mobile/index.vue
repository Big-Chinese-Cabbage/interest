<style scoped>
    .mobild-layout{
        border: 1px solid #d7dde4;
        background: #f5f7f9;
        position: relative;
        border-radius: 4px;
        overflow: hidden;
    }
    .mobild-layout .layout-logo{
        /*width: 100px;*/
        /*height: 30px;*/
        /*background: #5b6270;*/
        /*border-radius: 3px;*/
        float: left;
        /*position: relative;*/
        /*top: 15px;
        left: 20px;*/
        margin-top: 7px;
    }
    .mobild-layout .layout-search{
        height: 30px;
        border-radius: 3px;
        float: left;
        position: relative;
        left: 80px;
        
    }
    .mobild-layout .layout-nav{
        /*width: 315px;
        margin: 0 auto;
        margin-right: 20px;*/
        height: inherit;
        float: right;
        font-size: 15px;
	    margin-right: 5%;
	    
    }
    .dropdown-menu{
    	text-align: center;
    }
    .mobild-layout .layout-nav span{
    	font-size: 15px;
    	color: #C92027;
    }
    .mobild-layout .layout-footer-center{
        text-align: center;
    }
    .mobild-layout .demo-spin-icon-load{
        animation: ani-demo-spin 1s linear infinite;
    }
    @keyframes ani-demo-spin {
        from { transform: rotate(0deg);}
        50%  { transform: rotate(180deg);}
        to   { transform: rotate(360deg);}
    }
    .layout-title{
        font-size: 20px;
        font-weight: 400;
        position: relative;
        top: 50%;
        transform: translateY(-50%);
        color: rebeccapurple;
        left: 41%;
    }
</style>
<template>
    <div class="mobild-layout">
    	<Layout>
            <Header style="position: fixed;width: 100%;background:#fff;padding:0 0;z-index: 1000; line-height:0;">
            	<div style="width: 95%;margin: 0 auto">
                    <div class="layout-logo">
                        <a @click="backHome()">
                            <img src="../../images/logo.jpg" style="width: 50px;height: 50px;" align="absmiddle">
                            </img>
                        </a>
                    </div>
                    <!-- <div style="height: 64px;float: left;">
                        <span class="layout-title">interest</span>
                    </div> -->
                    <Dropdown v-if="loginFlag" trigger="click" class="layout-nav" @on-click="m=>{dropdownClick(m)}">
                        <img style="width: 40px;height: 40px; margin-top: 12px;border-radius: 100%;" :src="user.headimg"></img>
                        <DropdownMenu class="dropdown-menu" slot="list">
                        	<DropdownItem name="name">
                            	<Icon type="person"></Icon>
                               	{{user.loginName}}
                            </DropdownItem>
                            <DropdownItem name="email" divided>
                            	<Icon type="ios-email"></Icon>
                                邮件
                            </DropdownItem>
                            <DropdownItem name="loginOut" divided>
                            	<Icon type="log-out"></Icon>
                            	退出
                            </DropdownItem>
                        </DropdownMenu>
                    </Dropdown>
                    <div v-if="!loginFlag" class="layout-nav" style="margin-top: 14px;">
                        <!-- <Icon type="log-in"></Icon> -->
                        <Button type="ghost" shape="circle" @click="toLogin()">
                        	<span>登录</span>
                        </Button>
                    </div>
                </div>
            </Header>
            <Content :style="{margin: '80px 0 0 0', background: '#fff'}">
                <router-view></router-view>
            </Content>
            <Footer class="layout-footer-center">
                <div>
                    <a href="https://github.com/smallsnail-wh" target="_blank">
                        <Icon  style="color: rebeccapurple;" size="40" type="social-github"></Icon>
                    </a>
                </div>
                <p>2018-2020 &copy; smallsail-wh</p>
            </Footer>
        </Layout>

        <Modal :mask-closable="false" :visible.sync="emailModal" :loading = "loading" v-model="emailModal" title="联系管理员" @on-ok="emailOk('email')" @on-cancel="cancel()">
             <Form ref="email" :rules="emailRule" :model="email"  :label-width="80" >
                <FormItem label="标题" prop="title">
                    <Input v-model="email.title" placeholder="请输入标题"></Input>
                </FormItem>
                <FormItem label="email" prop="email">
                    <Input v-model="email.email" placeholder="请输入email"></Input>
                </FormItem>
                <FormItem label="姓名" prop="name">
                    <Input v-model="email.name" placeholder="请输入姓名"></Input>
                </FormItem>
                <FormItem label="内容" prop="content">
                    <Input v-model="email.content" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="Enter something..."></Input>
                </FormItem>
            </Form>
        </Modal>
    </div>
</template>
<script>
    export default {
        data(){
            return {
                loginFlag: false,
                consoleFlag: false,
                loading: true,
                searchValue:'',
                emailModal:false,
                email: {
                    title:'',
                    email:'',
                    name:'',
                    content:''
                },
                user: {
                    loginName: '',
                    email: '',
                    headimg: ''
                },
                emailRule: {
                    title: [
                        { type:'string', required: true, message: '请输入密码', trigger: 'blur' }
                    ],
                    email: [
                        { required: true, message: '输入邮箱', trigger: 'blur' },
                        { type:'email', message: '输入正确的邮箱格式', trigger: 'blur' }
                    ],
                    passwordAgain: [
                        { type:'string', required: true, message: '请输入再次输入密码', trigger: 'blur' }
                    ],
                    name: [
                        { type:'string', required: true, message: '请输入姓名', trigger: 'blur' }
                    ],
                    content: [
                        { required: true, message: '请输入内容', trigger: 'blur' }
                    ]
                    
                }
            }
        },
        mounted(){
            if (!this.$store.getters._isMobile) {
                this.$router.replace('/');
            }
            this.code = this.$route.query.code;
            if(this.code !=null && this.code != ''){

                // this.$Spin.show();
                this.$Spin.show({
                    render: (h) => {
                        return h('div', [
                            h('Icon', {
                                // 'class': 'demo-spin-icon-load',
                                style:{
                                    animation: 'ani-demo-spin 1s linear infinite'
                                },
                                props: {
                                    type: 'load-c',
                                    size: 18
                                }
                            }),
                            h('div', '正在登录，请等待...')
                        ])
                    }
                });
                setTimeout(() => {
                    this.$Spin.hide();
                }, 10000);
                this.axios({
                    method: 'post',
                    url: '/authentication/github',
                    params:{
                        "code": this.code
                    },
                    auth: {
                        username: 'client',
                        password: 'secret'
                    }
                }).then(function (response) {
                    localStorage.setItem("currentUser_token",response.data.access_token);
                    localStorage.setItem("currentUser_refresh_token",response.data.refresh_token);
                    this.axios.defaults.headers.common['Authorization'] = 'bearer '+ localStorage.getItem("currentUser_token");
                    this.$router.push({ path: '/' }) ;
                    location.reload();
                }.bind(this)).catch(function (error) {
                    this.$Message.error('登陆失败');
                }.bind(this));
            }else{
                this.userGet();
            }
            // this.$router.push("/page/home");
            
        },
        methods:{
            dropdownClick(m){
                if(m == "email"){
                    this.emailModal = true;
                }else if(m == "loginOut"){
                    this.$store.dispatch('users/loginOUt',{"router":this.$router});
                }
            },
        	toLogin(){
        		this.$router.push("/mlogin");
        	},
            userGet(){
                this.axios({
                    method: 'get',
                    url: '/public/user'
                }).then(function (response) {
                    if(response.data != null && response.data != ''){
                        this.loginFlag = true;
                        this.userSet(response.data);
                        if(response.data.usertype == 1){
                            this.consoleFlag = true;
                        }
                    }
                }.bind(this)).catch(function (error) {
                    this.$Message.error('无权限');
                }.bind(this));
            },
            userSet(e){
                this.user.loginName = e.loginName;
                this.user.email = e.email;
                this.user.headimg = e.headimg;
            },
            // userModifySet(e){
            //     this.userModify.loginName = e.loginName;
            //     this.userModify.password = e.password;
            //     this.userModify.passwordAgain = e.password;
            //     this.userModify.name = e.name;
            //     this.userModify.sex = e.sex;
            //     this.userModify.age = e.age;
            //     this.userModify.college = e.college;
            //     this.userModify.info = e.info;
            // },
            search(){
                if(this.searchValue != null && this.searchValue != ''){
                    this.$router.push("/page/home/"+this.searchValue);
                }
            },
            menuSelect(e){
                if(e==1){
                }else if (e==2) {
                    this.emailModal = true;
                }else if (e==3) {
                    this.$store.dispatch('users/loginOUt',{"router":this.$router});
                }else if(e == 4){
                    this.$router.push("/base");
                }else if(e == 5){
                    this.$router.push("/login");
                }
            },
            backHome(){
                this.$router.push("/page/home");
            },
            cancel () {
                this.$Message.info('点击了取消');
            },
            emailOk(email){
                this.$refs[email].validate((valid) => {
                    if (valid) {
                        this.axios({
                          method: 'post',
                          url: '/email',
                          data: this.email
                        }).then(function (response) {
                            this.$Message.info('发送成功');
                        }.bind(this)).catch(function (error) {
                          alert(error);
                        });  
                        this.emailModal = false;
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
            }
        }
    }
</script>