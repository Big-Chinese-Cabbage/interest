<style scoped>
  .article {
  	width: 100%;
	background: #fff;
	margin-bottom: 20px;
  }
  .title {
  	color: black;
  }
  .list-user-other {
    margin: 10px 0px;
    height: 24px;
    line-height: 24px;
  }
  .list-user-other dt{
    float: left;
    margin: 0 6px 0 0;
  }
  .list-user-other dd{
    float: left;
    font-size: 14px;
    color: #8a8a8a;
    line-height: 24px;
    margin-right: 10px;
  }
  .list-user-other .text {
    margin-right: 4px;
    color: #8a8a8a;
  }
  .list-user-other .num {
    color: #3399ea;
  }
  .content {
  	overflow: hidden;
  }
</style>
<template>
    <div id="mywork">
	    <div class="page-header-main">
	      	<div class="box-flex width-80 margin-auto margin-top-2 flex-direction-column flex-justify-center flex-items-center" >
	            <div class="article">
	              <div class="ql-container">
	                  <div class="ql-editor">
	                  	<div class="title line-height-40 font-size-22">{{article.title}}</div>
	                  	<dl class="list-user-other">
	                  		<dt>
		                      <a :href="article.githuburl" target="_blank">
		                          <img :src="article.userHeadImg" style="width: 25px;height: 25px;border-radius: 100%;">
		                      </a>
		                    </dt>
		                    <dd>
		                      <a :href="article.githuburl" target="_blank">{{article.userName}}</a>
		                    </dd>
		                    <dd>
		                        <span class="text">阅读数:</span>
	                            <span class="num">{{article.clickRate}}</span>
	                        </dd>
		                    <dd>{{article.createTime}}</dd>
		                  </dl>
	            		<div class="box-flex width-100 margin-auto margin-top-1 margin-bottom-1 border-top border-color-bfbfbf"></div>
                     	<div class="content" v-html="article.content"></div>
	                  </div>
	              </div>
	            </div>
	      	</div>
  		</div>
  	</div>
</template>
<script>
export default {
  data() {
    return {
      articleId: null,
      article: {
        id: "",
        title: "",
        content: "",
        clickRate: "",
        commentCount: "",
        createTime: "",
        userid: "",
        userName: "",
        userHeadImg: "",
        githuburl: ""
      }
    };
  },
  mounted() {
    this.articleId = this.$route.params.id;
    this.getArticle(this.$route.params.id);
  },
  methods: {
    getArticle(e) {
      this.axios({
        method: "get",
        url: "/public/articles/article/"+e
      }).then(
          function(response) {
            this.articleSet(response.data.data);
          }.bind(this)
        ).catch(
          function(error) {
            
          }.bind(this)
        );
    },
    articleSet(e) {
      this.article.id = e.id;
      this.article.title = e.title;
      this.article.content = e.content;
      this.article.clickRate = e.clickRate;
      this.article.commentCount = e.commentCount;
      this.article.createTime = this.dateGet(e.createTime);
      this.article.userid = e.userid;
      this.article.userName = e.userName;
      this.article.userHeadImg = e.userHeadImg;
      this.article.githuburl = e.githuburl;
    }
  }
};
</script>
