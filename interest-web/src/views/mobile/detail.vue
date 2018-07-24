<style type="text/css">
    .clearfix:after {
        visibility: hidden;
        display: block;
        font-size: 0;
        content: ".";
        clear: both;
        height: 0;
    }
    .clearfix {
        zoom:1;
    }
    .layout-left{
        float: left;
    }
</style>
<template>
    <div id="mywork">
	    <div class="page-header-main">
	      <div class="box-flex width-80 margin-auto margin-top-2 flex-direction-column flex-justify-center flex-items-center" >
	        <div class="line-height-50 font-size-22">{{insterest.title}}</div>
	        <div class="text-align-center margin-top-2">
	        </div>
            <div class="detailContent ql-editor" v-html="insterest.content" style="width: 100%;margin-top: 20px"></div>

            <div style="width: 100%;margin: 10% 0 20px 0">
                <div class="ivu-card-head" style="background: #eceef2">
                    <p>看帖</p>
                </div>
                <Card v-for="(item,index) in postcardList" :key="index">
                    <div class="clearfix">
                    	<div class="layout-left" style="margin-top: 2px;">
                    		<a :href="item.githuburl" target="_blank">
	                            <!-- <Icon type="ios-person"></Icon> -->
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
                    			{{item.replytime}}
                    		</p>
                    	</div>
                    </div>
                    <div>
                        <p>
	                        <router-link :to="('/mobile/card/'+item.id)">
	                            <span class="tirtleFont lineThrou">{{item.title}}</span>
	                        </router-link>
	                    </p>
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
                    <span><Icon type="edit"></Icon>发帖</span>
                  </div>
                  <div class="box-flex flex-6 width-100 padding-all-5x">
                    <Input v-model="title" placeholder="标题"></Input>
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
                postcardList:[],
                interestid:null,
                insterest:{
                    id:'',
                    title:'',
                    info:'',
                    content:'',
                    image:''
                },
                total:0,
                pageInfo:{
                    page:0,
                    pageSize:20
                },
                textarea:'',
                title:''
            }
        },
        mounted(){
            this.interestid = this.$route.params.id;
            this.getArticle(this.$route.params.id);
            this.getPostCard({
                "pageInfo":this.pageInfo,
                "interestid":this.interestid
            });
        },
        methods: {
            getArticle(e){
                this.axios({
                    method: 'get',
                    url: '/public/interests/interest',
                    params:{
                        "id": e
                    }
                }).then(function (response) {
                    this.insterestSet(response.data);
                }.bind(this)).catch(function (error) {
                    alter(error);
                }.bind(this));
            },
            dateGet(e){
                var time = new Date(parseInt(e));
                return time.getFullYear()+"-"+(time.getMonth()+1)+"-"+time.getDate()+" "+time.getHours()+":"+time.getMinutes(); 
            },
            listDateSet(e){
                for (var i = e.length - 1; i >= 0; i--) {
                    e[i].replytime = this.dateGet(e[i].replytime);
                }
            },
            getPostCard(e){
                this.axios({
                  method: 'get',
                  url: '/public/postcards',
                  params: {
                    'page':e.pageInfo.page,
                    'pageSize':e.pageInfo.pageSize,
                    'interestid':e.interestid
                  }
                }).then(function (response) {
                    this.postcardList=response.data.data;
                    this.listDateSet(this.postcardList);
                    this.total=response.data.totalCount;
                }.bind(this)).catch(function (error) {
                  alert(error);
                });
            },
            pageSearch(e){
                this.pageInfo.page = e-1;
                this.getPostCard({  
                    "pageInfo":this.pageInfo,
                    "interestid":this.interestid
                });
            },
            insterestSet(e){
                this.insterest.id = e.id;
                this.insterest.title = e.title;
                this.insterest.info = e.info;
                this.insterest.content = e.content;
                this.insterest.image = e.image;
            },
            sendCard(){
                if(this.title != null && this.textarea != null && this.title != '' && this.textarea != ''){
                    if(this.axios.defaults.headers.common['Authorization'] != null && this.axios.defaults.headers.common['Authorization'] != ''){
                        this.axios({
                            method: 'post',
                            url: '/postcards/postcard',
                            data:{
                                "interestid": this.interestid,
                                "title": this.title,
                                "content":this.textarea
                            }
                        }).then(function (response) {
                            this.$Message.info('发帖成功');
                            this.title = '';
                            this.textarea = '';
                            this.pageInfo.page = 0;
                            this.getPostCard({
                                "pageInfo":this.pageInfo,
                                "interestid":this.interestid
                            });
                        }.bind(this)).catch(function (error) {
                            alter(error);
                        }.bind(this));
                    }else{
                        this.$Message.error('登录后，才能发帖！');
                    }
                }else{
                    this.$Message.error('请填写标题和内容');
                }
                
            }
        }
    };
</script>