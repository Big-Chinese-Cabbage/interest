<template>
    <div id="mywork">
	    <div class="page-header-main">
	      <div class="box-flex width-80 margin-auto margin-top-2 flex-direction-column flex-justify-center flex-items-center" >
            <div style="width: 100%;margin: 20px 0 20px 0">
                <div class="ivu-card-head" style="background: #eceef2">
                    <p>{{postcard.title}}</p>
                </div>
                <Card>
                    <div class="clearfix">
                        <div class="layout-left" style="margin-top: 2px;">
                            <a :href="postcard.githuburl" target="_blank">
                                <img :src="postcard.headimg" style="width: 30px;height: 30px;border-radius: 100%;margin-top: 6px;">
                            </a>
                        </div>
                        <div class="layout-left" style="margin-left: 7px">
                            <p style="font-size: 17px;">
                                <a :href="postcard.githuburl" target="_blank">
                                    {{postcard.username}}
                                </a>
                            </p>
                            <p style="font-size: 1px;">
                                {{postcard.createtime}}
                            </p>
                        </div>
                    </div>
                    <div style="margin-top: 10px;">
                        <p>{{postcard.content}}</p>
                    </div>
                </Card>

                <Card v-for="(item,index) in replyCardList" :key="index">
                    <div class="clearfix">
                        <div class="layout-left" style="margin-top: 2px;">
                            <a :href="item.githuburl" target="_blank">
                                <img :src="item.headimg" style="width: 30px;height: 30px;border-radius: 100%;margin-top: 6px;">
                            </a>
                        </div>
                        <div class="layout-left" style="margin-left: 7px">
                            <p style="font-size: 17px;">
                                <a :href="item.githuburl" target="_blank">
                                    {{item.username}}
                                </a>
                            </p>
                            <p style="font-size: 1px;">
                                {{item.createtime}}
                            </p>
                        </div>
                    </div>
                    <div style="margin-top: 10px;">
                        <p>{{item.content}}</p>
                    </div>
                </Card>
                <div style="margin-top: 20px">
                    <Page :total="total" :page-size="pageInfo.pageSize" show-total @on-change="e=>{pageSearch(e)}"></Page>
                </div>
            </div>

            <div class="box-flex width-100 margin-auto margin-top-2 border-top border-color-bfbfbf"></div>

            <div class="box-flex margin-auto margin-top-2 flex-direction-column flex-justify-center flex-items-center" style="width: 100%;margin-bottom: 30px;">
                <div class=" width-100 flex-direction-row">
                  <div class="box-flex flex-1 padding-all-5x">
                    <span><Icon type="edit"></Icon>发表回复</span>
                  </div>
                  <div class="box-flex flex-6 width-100 padding-all-5x">
                    <Input v-model="textarea" type="textarea" :rows="6" placeholder="内容"></Input>
                  </div>
                </div>
                <div class="box-flex width-100 margin-top-2 flex-items-flex-end flex-justify-flex-end margin-bottom-3">
                  <Button type="primary" @click="sendCard()">发表</Button>
                </div>
              </div>
	      </div>
	    </div>
  </div>
</template>
<script>
    export default {
        data(){
            return {
                total:0,
                pageInfo:{
                    page:0,
                    pageSize:20
                },
                textarea:'',
                postcardid: null,
                postcard:{
                    id:'',
                    username:'',
                    title:'',
                    content:'',
                    interestid:'',
                    createtime:'',
                    headimg:'',
                    githuburl:''
                },
                replyCardList:[]
            }
        },
        mounted(){
            this.postcardid = this.$route.params.id;
            this.axios({
                method: 'get',
                url: '/public/postcards/postcard',
                params:{
                    "id": this.postcardid
                }
            }).then(function (response) {
                this.postcardSet(response.data);
            }.bind(this)).catch(function (error) {
                alter(error);
            }.bind(this));
            this.replyCardListGet({
                "pageInfo":this.pageInfo,
                "postcardid":this.postcardid
            });
        },
        methods: {
            replyCardListGet(e){
                this.axios({
                  method: 'get',
                  url: '/public/replycards',
                  params: {
                    'page':e.pageInfo.page,
                    'pageSize':e.pageInfo.pageSize,
                    'postcardid':e.postcardid
                  }
                }).then(function (response) {
                    this.replyCardList=response.data.data;
                    this.listDateSet(this.replyCardList);
                    this.total=response.data.totalCount;
                }.bind(this)).catch(function (error) {
                  alert(error);
                });
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
            postcardSet(e){
                this.postcard.id = e.id;
                this.postcard.username = e.username;
                this.postcard.title = e.title;
                this.postcard.content = e.content;
                this.postcard.interestid = e.interestid;
                // this.postcard.createtime = e.createtime;
                this.postcard.createtime = this.dateGet(e.createtime);
                this.postcard.headimg = e.headimg;
                this.postcard.githuburl = e.githuburl;
            },
            pageSearch(e){
                this.pageInfo.page = e-1;
                this.replyCardListGet({  
                    "pageInfo":this.pageInfo,
                    "postcardid":this.postcardid
                });
            },
            sendCard(){
                if(this.textarea != null && this.textarea != ''){
                    if(this.axios.defaults.headers.common['Authorization'] != null && this.axios.defaults.headers.common['Authorization'] != ''){
                        this.axios({
                            method: 'post',
                            url: '/replycards/replycard',
                            data:{
                                "postcardid": this.postcardid,
                                "content":this.textarea
                            }
                        }).then(function (response) {
                            this.$Message.info('回复成功');
                            this.textarea = '';
                            // this.pageInfo.page = 0;
                            this.replyCardListGet({
                                "pageInfo":this.pageInfo,
                                "postcardid":this.postcardid
                            });
                        }.bind(this)).catch(function (error) {
                            this.$Message.error('请重新登录');
                        }.bind(this));
                    }else{
                        this.$Message.error('登录后，才能回复！');
                    }
                    
                }else{
                    this.$Message.error('请填写回复内容');
                }
                
            }
        }
    };
</script>