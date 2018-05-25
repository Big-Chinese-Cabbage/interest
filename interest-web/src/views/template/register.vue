<style scoped>
    .register-index {
    	width: 100%;
    	height: 100%;
        position: absolute;
        background-image: url(../../images/背景图片.jpg);
    }
</style>
<template>
	<div class="register-index">
		<Form ref="user" :model="user" :rules="ruleValidate" :label-width="80" style="height: auto;width: 50%;margin: 0 auto;padding: 2% 1% 1% 0;background:#fff">
			<div style="text-align: center;padding-bottom: 2%;">
				<span style="font-size: 15px">校园兴趣交流网站用户注册</span>
			</div>
			<FormItem label="登录名" prop="loginName">
	            <Input v-model="user.loginName" placeholder="请输入登录名，必须为12位数字"></Input>
	        </FormItem>
	        <FormItem label="密码" prop="password">
	            <Input v-model="user.password" type="password" placeholder="请输入密码"></Input>
	        </FormItem>
	        <FormItem label="确认密码" prop="passwordAgain">
	            <Input v-model="user.passwordAgain" type="password" placeholder="请输入密码"></Input>
	        </FormItem>
	        <FormItem label="姓名" prop="name">
	            <Input v-model="user.name" placeholder="请输入姓名"></Input>
	        </FormItem>
	        <FormItem label="性别" prop="sex">
	            <RadioGroup v-model="user.sex">
	                <Radio label="man">男</Radio>
	                <Radio label="woman">女</Radio>
	            </RadioGroup>
	        </FormItem>
	        <FormItem label="年龄" prop="age">
	            <Input v-model="user.age" placeholder="请输入年龄"></Input>
	        </FormItem>
	        <FormItem label="学院" prop="college">
	            <Input v-model="user.college" placeholder="请输入学院"></Input>
	        </FormItem>
	        <FormItem label="个人简介" prop="info">
	            <Input v-model="user.info" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="Enter something..."></Input>
	        </FormItem>
	        <FormItem>
	            <Button type="primary" @click="handleSubmit('user')">注册</Button>
	            <Button type="ghost" @click="handleReset('user')" style="margin-left: 8px">重置</Button>
	        </FormItem>
	    </Form>
	</div>
</template>
<script>
    export default {
        data () {
            return {
                user: {
                	loginName: '',
                	password: '',
                	passwordAgain: '',
                    name: '',
                    sex: '',
                    age: '',
                    college: '',
                    info: ''
                },
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
                }
            }
        },
        methods: {
            handleSubmit (user) {
                this.$refs[user].validate((valid) => {
                    if (valid) {
                    	if(this.user.password == this.user.passwordAgain){
                    		this.axios.defaults.headers.common['Authorization'] = '';
                    		localStorage.clear();
                    		this.axios({
                                method: 'post',
                                url: '/register',
                                data: this.user
                            }).then(function (response) {
                    			this.$Message.success('注册成功,请登录');
                    			this.$router.push({path:'/'});
                            }.bind(this)).catch(function (error) {
                                this.$Message.error('登录名已存在');
                            }.bind(this));
                    	}else{
                    		this.$Message.error('两次输入的密码不相同!');
                    	}
                        
                    } else {
                        this.$Message.error('Fail!');
                    }
                })
            },
            handleReset (user) {
                this.$refs[user].resetFields();
            }
        }
    }
</script>
