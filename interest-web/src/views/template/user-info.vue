<template>
    <div class="home content-background">
    	<div class="user-content">
    		<div class="subhead">
    			<h1 class="title-text">个人信息</h1>
    		</div>
    		<div class="headimg" @click="toggleShow()">
    			<img :src="headImg">
          <p class="head-btn">修改头像</p>
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
      <my-upload 
        ref="upload"
        field="picture"
        v-model="show"
        :width="200"
        :height="200"
        url="/interest/general/users/user/head-img/upload"
        :headers="headers"
        img-format="png"
        @crop-upload-success="cropUploadSuccess"
        @crop-upload-fail="cropUploadFail">
      </my-upload>
    </div>
</template>
<script>
import myUpload from 'vue-image-crop-upload';
export default {
  components: {
    'my-upload': myUpload
  },
  data() {
    return {
      headImg:'',
      show: false,
      headers: {
        Authorization:'bearer '+ localStorage.getItem("currentUser_token")
      },
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
    toggleShow() {
      this.show = !this.show;
    },
    cropUploadSuccess(jsonData, field){
      this.axios({
        method: "patch",
        url: "/general/users/user/headImg",
        params: {
          headImg: jsonData.data
        }
      })
      .then(function(response) {
        this.headImg = jsonData.data;
        this.show = false;
        this.$Notice.success({title: '头像修改成功'});
        this.$refs.upload.off();
      }.bind(this))
      .catch(function(error) {
        alter(error);
      }.bind(this));
    },
    cropUploadFail(status, field){
      this.$Notice.error({title: '头像修改失败'});
      this.$refs.upload.off();
    },
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
            this.headImg = response.data.data.headimg;
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
            this.$Notice.success({title: '修改成功'});
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
  cursor: pointer;
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
.head-btn {
  padding: 5px 15px 6px;
  font-size: 12px;
  border-radius: 4px;
  color: #47cb89;
  text-align: center;
  border: 1px solid #47cb89;
}
.head-btn:hover{
  background: rgba(244,252,248,.5);
}
</style>
