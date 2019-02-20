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

    .comment-section {
        flex-direction: column;
        margin-top: 30px;
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

                .user {
                    flex: 0 0 26px;
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

            .title-info {
                font-size: 12px;

                .user-name {
                    margin: 0 4px;
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
                    <div class="ql-container">
                        <div class="ql-editor">
                            <div class="title line-height-40 font-size-22">{{article.title}}</div>
                            <dl class="list-user-other">
                                <dt>
                                    <a :href="article.githuburl" target="_blank">
                                        <img :src="article.userHeadImg"
                                             style="width: 25px;height: 25px;border-radius: 100%;">
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

                <div class="comment-append-section">
                    <Input v-model="commentAppend" v-show="!appendActive" @on-focus="toggleInput"
                            prefix="ios-create" placeholder="添加评论" />

                    <Input v-show="appendActive" v-model="commentAppend"
                           @on-blur="toggleInput" ref="commentInputDom"
                           type="textarea" :autosize="{minRows: 3,maxRows: 10}" placeholder="添加评论" />

                    <Button v-show="appendActive" style="margin-top: 10px" type="primary">发表评论</Button>
                </div>

                <div class="comment-section">
                    <div class="reply-count">
                        {{total}}条回复
                    </div>

                    <ul class="reply-list">
                        <li v-for="(comment, index) in comments" class="reply-item" :key="comment.id">
                            <div class="user">
                                <img class="avatar" :src="comment.userHeadImg" :title="comment.replierName" />
                            </div>

                            <div class="reply-info">
                                <div class="title-info">
                                    <span class="user-name">{{comment.replierName}}</span>
                                    <span># {{index + 1}} 楼 • {{comment.creatTimeBy}}</span>
                                    <!--<div v-if="reply.ups && reply.ups.length" class="up-info">
                                        <image src="../../static/up.svg" mode=""></image>
                                        <span class="up-count">{{reply.ups.length}}</span>
                                    </div>-->

                                </div>
                                <div class="reply-content">
                                    {{comment.comment}}
                                </div>
                            </div>
                        </li>
                    </ul>

                    <Page v-if="total > 0" class="pagin" :total="total"
                          size="small" show-elevator  />
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
                appendActive: false
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
                        }
                        this.comments = data.data;
                        this.total = data.totalCount;
                    }.bind(this)
                ).catch(function (error) {

                    }.bind(this)
                );
            },

            toggleInput(event) {
                console.log(event.target);
                this.appendActive = !this.appendActive;
                /*if (event.type === 'focus') {
                    this.$refs.commentInputDom.$refs.textarea.focus();
                }*/
            },

            publishComment() {
                this.axios({
                    method: 'post',
                    url: '/user/12345',
                    data: {
                        firstName: 'Fred',
                        lastName: 'Flintstone'
                    }
                }).then(function (response) {
                    this.$Message.error('评论失败，请稍后重试！');
                }).catch(function () {
                    this.$Message.error('评论失败，请稍后重试！');
                });
            }
        }
    };
</script>
