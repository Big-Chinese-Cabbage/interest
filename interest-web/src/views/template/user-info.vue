<template>
    <div class="home content-background">
    	<div class="user-content">
    		<div class="subhead">
    			<h1 class="title-text">个人信息</h1>
    		</div>
    		<div class="headimg">
    			<img :src="userInfo.headimg">
    		</div>
    		<div class="info">
    			<Form :model="userInfo" label-position="top">
			        <FormItem label="用户名">
			            <Input v-model="userInfo.name"></Input>
			        </FormItem>
			        <FormItem label="用户主页">
			            <Input v-model="userInfo.url"></Input>
			        </FormItem>
			        <FormItem label="邮箱地址">
			            <Input v-model="userInfo.email"></Input>
			        </FormItem>
			        <FormItem label="个人简介">
			            <Input v-model="userInfo.info" type="textarea" :rows="3"></Input>
			        </FormItem>
			        <FormItem label="所在位置">
			            <Input v-model="userInfo.location"></Input>
			        </FormItem>
			        <FormItem label="擅长技能">
			            <Input v-model="userInfo.skill"></Input>
			        </FormItem>
			        <Button type="primary" class="update-button" @click="updateInfo">更新</Button>
			    </Form>
    		</div>
    	</div>
    </div>
</template>
<script>
export default {
  data() {
    return {
    	userInfo: {
    		headimg:null,
    		name:null,
    		url:null,
    		email:null,
    		info:null,
    		location:null,
    		skill:null
    	}
    };
  },
  mounted() {
  	this.getUserInfo();
  },
  methods: {
  	userInfoSet(e){
  		this.userInfo.headimg = e.headimg;
  		this.userInfo.name = e.name;
  		this.userInfo.url = e.url;
  		this.userInfo.email = e.email;
  		this.userInfo.info = e.info;
  		this.userInfo.location = e.location;
  		this.userInfo.skill = e.skill;
  	},
  	getUserInfo(){
  		this.axios({
	        method: "get",
	        url: "/general/users/user/info"
	    })
	    .then(
          function(response) {
            this.userInfoSet(response.data.data);
          }.bind(this)
        )
        .catch(
          function(error) {
            alter(error);
          }.bind(this)
        );
  	},
  	updateInfo(){
  		this.axios({
  			method: "put",
  			url: "/general/users/user/info",
  			data: this.userInfo
  		})
  		.then(
          function(response) {
            this.$Notice.success({
                    title: '修改成功'
                });
          }.bind(this)
        )
        .catch(
          function(error) {
            alter(error);
          }.bind(this)
        );
  	}
  }
};
</script>
<style>
.ivu-form .ivu-form-item-label {
	color: #24292e;
}
.content-background {
  background: #fff;
}
.user-content {
	width: 550px;
	margin:0 auto;
	height: 625px;
}
.user-content .subhead {
    border-bottom: 1px solid #e1e4e8;
    padding-bottom: 8px;
    text-align: center;
}
.user-content .title-text {
	color: #24292e;
}
.user-content .info {
	padding:16px 16px;
	float: left;
    width: 400px;
    color: #24292e;
}
.user-content .info label {
	color: #24292e;
}
.user-content .headimg {
	float: left;
	margin-top: 16px;
    padding: 0 16px;
}
.user-content .headimg img {
	width: 100px;
    height: 100px;
    border-radius: 50%;
    margin: 0 auto;
}
.user-content .update-button {
	width: 100%;
}
</style>
