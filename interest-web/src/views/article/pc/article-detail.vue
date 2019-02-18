<style scoped lang="scss">
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

  .comment-section {
	  flex-direction: column;
	  margin-top: 30px;
	  background-color: #fff;

	  ul {
		  list-style: none;
	  }

	  image {
		  margin-right: 10px;
		  border-radius: 6px;

	  }

	  .avatar {
		  width: 60px;
		  height: 60px;
	  }

	  .reply-count {
		  padding: 12px 15px;
		  background-color: #eee;
	  }

	  .reply-list {
		  flex-direction: column;

		  .reply-item {
			  padding: 12px 15px;
			  border-bottom: 1px solid #f0f0f0;
		  }

		  .reply-hightlight {
			  background-color: #f4fcf0;
		  }

		  .reply-info {
			  flex-direction: column;

			  text {
				  margin-left: 20px;
			  }
		  }

		  .title-info {
			  font-size: 14px;

			  .user-name {
				  color: #666;

				  &:hover {
					  color: #385f8a;
				  }
			  }
		  }


		  .up-info {
			  flex-grow: 1;
			  justify-content: flex-end;
			  color: #808080;

			  image {
				  width: 50px;
				  height: 50px;
			  }

			  .up-count {
				  margin-left: 0;
			  }

		  }
	  }

	  .reply-content {
		  padding: 10px 20px;
		  font-size: 16px;
	  }
  }

</style>
<template>
    <div id="mywork">
	    <div class="page-header-main">
	      	<div class="width-80 margin-auto margin-top-2 flex-direction-column flex-justify-center flex-items-center" >
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

				<div class="comment-section">
					<div class="reply-count">
						12回复
					</div>

					<ul class="reply-list">
						<li class="reply-item">
							<div class="user">
								<image class="avatar" src=""  title="" ></image>
							</div>

							<div class="reply-info">
								<div class="title-info">
									<span class="user-name">author.loginname</span>
									<span>1楼•eply.create_time</span>
									<!--<div v-if="reply.ups && reply.ups.length" class="up-info">
										<image src="../../static/up.svg" mode=""></image>
										<span class="up-count">{{reply.ups.length}}</span>
									</div>-->

								</div>
								<div class="reply-content">
									reply.content
								</div>
							</div>
						</li>
					</ul>
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
