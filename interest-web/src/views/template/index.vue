<style scoped>
    .layout{
        border: 1px solid #d7dde4;
        background: #f5f7f9;
        position: relative;
        border-radius: 4px;
        overflow: hidden;
    }
    .layout-logo{
        /*width: 100px;*/
        /*height: 30px;*/
        /*background: #5b6270;*/
        /*border-radius: 3px;*/
        float: left;
        /*position: relative;*/
        /*top: 15px;
        left: 20px;*/
    }
    .layout-search{
        height: 30px;
        border-radius: 3px;
        float: left;
        position: relative;
        left: 80px;
        
    }
    .layout-nav{
        /*width: 315px;
        margin: 0 auto;
        margin-right: 20px;*/
        height: inherit;
        float: right;
    }
    .layout-footer-center{
        text-align: center;
    }
</style>
<template>
    <div class="layout">
    	<Layout>
            <Header style="position: fixed;width: 100%;background:#fff;padding:0 0;z-index: 1000; ">
                <Menu mode="horizontal" theme="light"  :style="{height:'65px',width:'100%'}" @on-select="m=>{menuSelect(m)}">
                    <div style="width: 95%;margin: 0 auto">
                        <div class="layout-logo">
                            <a @click="backHome()">
                                <img src="../../images/图标.jpg" style="width: 50px;height: 50px;" align="absmiddle">
                                </img>
                            </a>
                        </div>
                        <div class="layout-search">
                            <Input v-model="searchValue" icon="android-search" placeholder="Enter something..." @on-enter="search()"></Input>
                        </div>
                        <div class="layout-nav">
                            <MenuItem name="1">
                                <Icon type="ios-person"></Icon>
                                {{user.name}}
                            </MenuItem>
                            <MenuItem name="2">
                                <Icon type="ios-email"></Icon>
                                邮件
                            </MenuItem>
                            <MenuItem name="3">
                                <Icon type="log-out"></Icon>
                                退出
                            </MenuItem>
                            <MenuItem name="4" v-if="consoleFlag">
                                <Icon type="gear-b"></Icon>
                                控制台
                            </MenuItem>
                        </div>
                    </div>
                </Menu>
            </Header>
            <Content :style="{margin: '80px 0 0 0', background: '#fff'}">
                <router-view></router-view>
            </Content>
            <Footer class="layout-footer-center">2018-2020 &copy; hello</Footer>
        </Layout>

        <Modal :mask-closable="false" :visible.sync="modifyModal" :loading = "loading" v-model="modifyModal" width="600" title="修改" @on-ok="modifyOk('userModify')" @on-cancel="cancel()">
             <Form ref="userModify" :rules="ruleValidate" :model="userModify"  :label-width="80" >
                <FormItem label="登录名" prop="loginName">
                    <Input v-model="userModify.loginName" disabled="disabled"  placeholder="请输入登录名，必须为12位数字"></Input>
                </FormItem>
                <FormItem label="密码" prop="password">
                    <Input v-model="userModify.password" type="password" placeholder="请输入密码"></Input>
                </FormItem>
                <FormItem label="确认密码" prop="passwordAgain">
                    <Input v-model="userModify.passwordAgain" type="password" placeholder="请输入密码"></Input>
                </FormItem>
                <FormItem label="姓名" prop="name">
                    <Input v-model="userModify.name" placeholder="请输入姓名"></Input>
                </FormItem>
                <FormItem label="性别" prop="sex">
                    <RadioGroup v-model="userModify.sex">
                        <Radio label="man">男</Radio>
                        <Radio label="woman">女</Radio>
                    </RadioGroup>
                </FormItem>
                <FormItem label="年龄" prop="age">
                    <Input v-model="userModify.age" placeholder="请输入年龄"></Input>
                </FormItem>
                <FormItem label="学院" prop="college">
                    <Input v-model="userModify.college" placeholder="请输入学院"></Input>
                </FormItem>
                <FormItem label="个人简介" prop="info">
                    <Input v-model="userModify.info" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="Enter something..."></Input>
                </FormItem>
            </Form>
        </Modal>

        <Modal :mask-closable="false" :visible.sync="modifyModal" :loading = "loading" v-model="modifyModal" width="600" title="修改" @on-ok="modifyOk('userModify')" @on-cancel="cancel()">
             <Form ref="userModify" :rules="ruleValidate" :model="userModify"  :label-width="80" >
                <FormItem label="登录名" prop="loginName">
                    <Input v-model="userModify.loginName" disabled="disabled"  placeholder="请输入登录名，必须为12位数字"></Input>
                </FormItem>
                <FormItem label="密码" prop="password">
                    <Input v-model="userModify.password" type="password" placeholder="请输入密码"></Input>
                </FormItem>
                <FormItem label="确认密码" prop="passwordAgain">
                    <Input v-model="userModify.passwordAgain" type="password" placeholder="请输入密码"></Input>
                </FormItem>
                <FormItem label="姓名" prop="name">
                    <Input v-model="userModify.name" placeholder="请输入姓名"></Input>
                </FormItem>
                <FormItem label="性别" prop="sex">
                    <RadioGroup v-model="userModify.sex">
                        <Radio label="man">男</Radio>
                        <Radio label="woman">女</Radio>
                    </RadioGroup>
                </FormItem>
                <FormItem label="年龄" prop="age">
                    <Input v-model="userModify.age" placeholder="请输入年龄"></Input>
                </FormItem>
                <FormItem label="学院" prop="college">
                    <Input v-model="userModify.college" placeholder="请输入学院"></Input>
                </FormItem>
                <FormItem label="个人简介" prop="info">
                    <Input v-model="userModify.info" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="Enter something..."></Input>
                </FormItem>
            </Form>
        </Modal>

        <Modal :mask-closable="false" :visible.sync="emailModal" :loading = "loading" v-model="emailModal" width="600" title="联系管理员" @on-ok="emailOk('email')" @on-cancel="cancel()">
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
                    password: '',
                    name: '',
                    sex: '',
                    age: '',
                    college: '',
                    info: ''
                },
                userModify: {
                    id:'',
                    loginName: '',
                    password: '',
                    passwordAgain:'',
                    name: '',
                    sex: '',
                    age: '',
                    college: '',
                    info: ''
                },
                modifyModal: false,
                ruleValidate: {
                    loginName: [
                        { type:'string', required: true, message: '请输入登录名，必须为12位数字', trigger: 'blur' },
                        {validator(rule, value, callback) {
                            if (!Number.isInteger(+value) || value.length!=12) {
                                callback(new Error('必须为12位数字'));
                            } else {
                                callback();
                            }
                          
                        }, trigger: 'blur'}
                    ],
                    password: [
                        { type:'string', required: true, message: '请输入密码', trigger: 'blur' }
                    ],
                    passwordAgain: [
                        { type:'string', required: true, message: '请输入再次输入密码', trigger: 'blur' }
                    ],
                    name: [
                        { type:'string', required: true, message: '请输入姓名', trigger: 'blur' }
                    ],
                    sex: [
                        { required: true, message: '请选择性别', trigger: 'change' }
                    ],
                    age: [
                        { type:'string', required: true, message: '请输入年龄', trigger: 'blur' }
                    ],
                    college: [
                        { type:'string', required: true, message: '请输入学院', trigger: 'blur' }
                    ],
                    info: [
                        { type:'string', required: true, message: '请输入个人简介', trigger: 'blur' }
                    ]
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
            // this.$router.push("/page/home");
            this.axios({
                method: 'get',
                url: '/user'
            }).then(function (response) {
                this.userSet(response.data);
                if(response.data.usertype == 1){
                    this.consoleFlag = true;
                }
            }.bind(this)).catch(function (error) {
                this.$Message.error('无权限');
            }.bind(this));
        },
        methods:{
            userSet(e){
                this.user.loginName = e.loginName;
                this.user.password = e.password;
                this.user.name = e.name;
                this.user.sex = e.sex;
                this.user.age = e.age;
                this.user.college = e.college;
                this.user.info = e.info;
            },
            userModifySet(e){
                this.userModify.loginName = e.loginName;
                this.userModify.password = e.password;
                this.userModify.passwordAgain = e.password;
                this.userModify.name = e.name;
                this.userModify.sex = e.sex;
                this.userModify.age = e.age;
                this.userModify.college = e.college;
                this.userModify.info = e.info;
            },
            search(){
                if(this.searchValue != null && this.searchValue != ''){
                    this.$router.push("/page/home/"+this.searchValue);
                }
            },
            menuSelect(e){
                if(e==1){
                    this.modifyModal = true;
                    this.userModifySet(this.user);
                }else if (e==2) {
                    this.emailModal = true;
                }else if (e==3) {
                    this.$store.dispatch('users/loginOUt',{"router":this.$router});
                }else if(e == 4){
                    this.$router.push("/base");
                }
            },
            backHome(){
                this.$router.push("/page/home");
            },
            cancel () {
                this.$Message.info('点击了取消');
            },
            modifyOk(userModify){
                this.$refs[userModify].validate((valid) => {
                    if (valid) {
                        if(this.userModify.password == this.userModify.passwordAgain){
                            if(this.userModify.password == this.user.password){
                                this.userModify.id = 8888;
                            }
                            this.axios({
                              method: 'put',
                              url: '/user',
                              data: this.userModify
                            }).then(function (response) {
                                this.userSet(response.data)
                                this.$Message.info('修改成功');
                            }.bind(this)).catch(function (error) {
                              alert(error);
                            });  
                            this.modifyModal = false;
                        }else{
                            this.$Message.error('两次输入的密码不相同!');
                        }
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
            emailOk(email){
                this.$refs[email].validate((valid) => {
                    if (valid) {
                        this.axios({
                          method: 'post',
                          url: '/email',
                          data: this.email
                        }).then(function (response) {
                            this.userSet(response.data)
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