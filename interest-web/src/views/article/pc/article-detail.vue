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

    .list-user-other dt {
        float: left;
        margin: 0 6px 0 0;
    }

    .list-user-other dd {
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
    .content img{
        max-width: 100%;
    }

    .comment-section {
        flex-direction: column;
        margin-top: 5px;
        background-color: #fff;
        overflow: hidden;

        ul {
            list-style: none;
        }

        image {
            margin-right: 10px;
            border-radius: 6px;

        }

        .avatar {
            margin-right: 6px;
            border-radius: 20px;
            width: 26px;
            height: 26px;
        }

        .reply-count {
            padding: 12px 15px;
            background-color: #eee;
        }

        .reply-list {
            display: flex;
            flex-direction: column;

            .reply-item {
                display: flex;
                padding: 12px 15px;
                border-bottom: 1px solid #f0f0f0;
                flex-direction: column;

                .user {
                    flex: 0 0 26px;

                    .avatar {
                        margin-right: 6px;
                        border-radius: 20px;
                        width: 26px;
                        height: 26px;
                        float: left;
                    }
                    .title-info {
                        font-size: 12px;
                        float:left;
                        margin-top: 4px;

                        .user-name {
                            margin: 0 4px;
                            color: #666;

                            &:hover {
                                color: #385f8a;
                            }
                        }
                    }
                    .title-info-other {
                        font-size: 12px;
                        float:left;
                        margin: 4px 0 0 20px;

                        a {
                            margin: 0 5px;
                        }
                    }
                }
                .reply-child-list {
                    margin-left: 32px;
                    border-left: 4px solid #c5c5c5;

                    .title-info {
                        font-size: 12px;
                        float:left;
                        margin-top: 4px;

                        .user-name {
                            margin: 0 4px;
                            color: #666;

                            &:hover {
                                color: #385f8a;
                            }
                        }
                        .avatar {
                            margin-right: 6px;
                            border-radius: 20px;
                            width: 26px;
                            height: 26px;
                            float: left;
                        }
                        .title-info-right {
                            float: left;
                            margin-top: 4px;

                            .reply-time {
                                padding: 0 20px;
                            }
                        }
                    }
                }
            }

            .reply-hightlight {
                background-color: #f4fcf0;
            }

            .reply-info {
                display: flex;
                flex-direction: column;

                text {
                    margin-left: 20px;
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
            padding: 10px 20px 0 0;
            font-size: 14px;
        }

        .pagin {
            margin: 10px 15px;
        }
    }

</style>
<template>
    <div id="mywork">
        <div class="page-header-main">
            <div class="width-80 margin-auto margin-top-2 flex-direction-column flex-justify-center flex-items-center">
                <div class="article">
                    <div class="ql-container ql-snow">
                        <div class="ql-editor">
                            <div class="title line-height-40 font-size-22">{{article.title}}</div>
                            <dl class="list-user-other">
                                <dt>
                                    <a :href="$store.state.userUrlPre+article.userid" target="_blank">
                                        <img :src="article.userHeadImg"
                                             style="width: 25px;height: 25px;border-radius: 100%;">
                                    </a>
                                </dt>
                                <dd>
                                    <a :href="$store.state.userUrlPre+article.userid" target="_blank">{{article.userName}}</a>
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

                <div class="comment-append-section" id="commentAppendArea">
                    <!-- <Input v-model="commentAppend" v-show="!appendActive" @on-focus="toggleInput"
                            prefix="ios-create" placeholder="添加评论" />

                    <Input v-show="appendActive" v-model="commentAppend"
                           @on-blur="toggleInput" ref="commentInputDom"
                           type="textarea" :autosize="{minRows: 3,maxRows: 10}" placeholder="添加评论" /> -->
                    <Input v-model="commentAppend" @on-blur="toggleInput" @on-focus="focusInput" ref="commentInputDom" type="textarea" :rows="commentAppendInput" placeholder="添加评论" />

                    <Button style="margin-top: 10px" type="primary" @click="publishComment()">发表评论</Button>
                </div>

                <div class="comment-section">
                    <!-- <div class="reply-count">
                        {{total}}条回复
                    </div> -->

                    <ul class="reply-list">
                        <li v-for="(comment, index) in comments" class="reply-item" :key="comment.id">
                                <div class="user">
                                    <a :href="$store.state.userUrlPre+comment.userid" target="_blank">
                                        <img class="avatar" :src="comment.userHeadImg" :title="comment.userName" />
                                    </a>
                                    <div class="title-info">
                                        <a :href="$store.state.userUrlPre+comment.userid" target="_blank">
                                            <span class="user-name">{{comment.userName}}</span>
                                        </a>
                                        <span># {{index + 1}} 楼 • {{comment.creatTimeBy}}</span>
                                    </div>
                                    <div class="title-info-other">
                                        <span>
                                            <a v-show="!comment.showContent" @click="changeContent(index)">查看回复({{comment.childCommentsCount}})</a>
                                            <a v-show="comment.showContent" @click="changeContent(index)">收起回复</a>
                                            <a @click="writeComment(comment,1)">回复</a>
                                        </span>
                                    </div>
                                </div>
                                <div class="reply-info">
                                    <div class="reply-content">
                                        {{comment.comment}}
                                    </div>
                                </div>
                            <ul v-show="comment.showContent" class="reply-child-list">
                                <li v-for="(replyComment,replyIndex) in comment.childComments" class="reply-item" :key="replyComment.id">
                                    <div class="reply-info">
                                        <div class="title-info">
                                            <a :href="$store.state.userUrlPre+replyComment.userid" target="_blank">
                                                <img class="avatar" :src="replyComment.userHeadImg" :title="replyComment.userName" />
                                            </a>
                                            <div class="title-info-right">
                                                <a :href="$store.state.userUrlPre+replyComment.userid" target="_blank">
                                                    <span class="user-name">{{replyComment.userName}}</span>
                                                </a>
                                                <span>回复</span>
                                                <span class="user-name">{{replyComment.replierName}}:</span>
                                                <span>{{replyComment.comment}}</span>
                                                <span class="reply-time">({{replyComment.creatTimeBy}})</span>
                                                <a @click="writeComment(replyComment,2)">回复</a>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>

                    <Page v-if="total > 10" class="pagin" :total="total" size="small" show-elevator @on-change="e=>{pageSearch(e)}" />
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
                },
                comments: [],
                page: 0,
                pageSize: 10,
                total: 0,
                commentAppend: '',
                commentAppendInput:1,
                appendActive: false,
                articleComment: {
                    articleid: null,
                    articleOwnerId:null,
                    parentid: null,
                    comment: null,
                    replierId: null,
                    replierName: null
                }
            };
        },
        mounted() {
            this.articleId = this.$route.params.id;
            this.getArticle(this.$route.params.id);
            this.getComments();
        },
        methods: {
            getArticle(e) {
                this.axios({
                    method: "get",
                    url: "/public/articles/article/" + e
                }).then(
                    function (response) {
                        this.articleSet(response.data.data);
                    }.bind(this)
                ).catch(
                    function (error) {

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
            },
            articleCommentSet(e) {
                this.articleComment.articleid = e.articleid;
                this.articleComment.parentid = e.parentid;
                this.articleComment.comment = e.comment;
                this.articleComment.replierId = e.replierId;
                this.articleComment.replierName = e.replierName;
                this.articleComment.articleOwnerId = this.article.userid;
            },
            articleCommentInit() {
                this.articleComment.articleid = null;
                this.articleComment.parentid = null;
                this.articleComment.comment = null;
                this.articleComment.replierId = null;
                this.articleComment.replierName = null;
                this.articleComment.articleOwnerId = null;
            },
            getComments() {
                this.axios({
                    method: 'get',
                    url: '/public/article/comment',
                    params: {
                        articleId: this.articleId,
                        page: this.page,
                        pageSize: this.pageSize
                    },
                }).then(
                    function (response) {
                        let data = response.data.data;
                        for (let comment of data.data) {
                            comment.creatTimeBy = this.latestTimeFormat(comment.createTime)
                            comment.showContent = false;
                            for (let replyComment of comment.childComments) {
                                replyComment.creatTimeBy = this.latestTimeFormat(replyComment.createTime);
                            }
                        }
                        this.comments = data.data;
                        this.total = data.totalCount;
                    }.bind(this)
                ).catch(function (error) {

                    }.bind(this)
                );
            },
            focusInput(event){
                this.commentAppendInput = 3;
            },
            writeComment(e,sign){
                this.commentAppendInput = 3;

                var anchor = this.$el.querySelector("#commentAppendArea")
                document.body.scrollTop = anchor.offsetTop; // chrome
                this.appendActive = true;
                //document.documentElement.scrollTop = anchor.offsetTop; // firefox

                if(sign == 1){
                    this.articleComment.articleid = this.articleId;
                    this.articleComment.parentid = e.id;
                    this.articleComment.comment = null;
                    this.articleComment.replierId = e.userid;
                    this.articleComment.replierName = e.userName;
                }else if(sign == 2){
                    this.articleComment.articleid = this.articleId;
                    this.articleComment.parentid = e.parentid;
                    this.articleComment.comment = null;
                    this.articleComment.replierId = e.userid;
                    this.articleComment.replierName = e.userName;
                }
                this.commentAppend = "[reply]"+e.userName+"[/reply]\n";
            },
            publishComment() {
                if (this.axios.defaults.headers.common["Authorization"] == null ||this.axios.defaults.headers.common["Authorization"] == ""){
                    this.$Message.error('请登录');
                    return;
                }
                if(this.commentAppend == null || this.commentAppend == ''){
                    this.$Message.error('请输入评论');
                    return;
                }

                if(this.articleComment.replierName != null){
                    var str = this.commentAppend.substring(0,15+this.articleComment.replierName.length);
                    var validate = "[reply]"+this.articleComment.replierName+"[/reply]";
                    if(str == validate){
                        this.articleComment.comment = this.commentAppend.substring(str.length);
                        this.articleComment.articleOwnerId = this.article.userid;
                        this.postComment(this.articleComment);
                    }else {
                        this.postComment({
                        articleid:this.articleId,
                        comment:this.commentAppend,
                        articleOwnerId:this.article.userid});
                    }
                }else {
                    this.postComment({
                        articleid:this.articleId,
                        comment:this.commentAppend,
                        articleOwnerId:this.article.userid});
                }
            },
            postComment(e){
                this.axios({
                    method: 'post',
                    url: '/article/comment',
                    data: e
                }).then(function (response) {
                    this.$Message.success('评论成功');
                    this.getComments();
                    this.articleCommentInit();
                    this.commentAppend = null;
                }.bind(this)).catch(function () {
                    this.$Message.error('评论失败，请稍后重试！');
                }.bind(this));
            },
            changeContent(index){
                var temp = this.comments[index];
                temp.showContent = ! temp.showContent;
                this.comments.splice(index,1,temp);
            },
            pageSearch(e) {
              this.page = e - 1;
              this.getComments();
            }
        }
    };
</script>
