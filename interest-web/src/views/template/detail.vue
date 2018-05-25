<template>
    <div id="mywork">
	    <div class="page-header-main">
	      <div class="box-flex width-80 margin-auto margin-top-2 flex-direction-column flex-justify-center flex-items-center" >
	        <div class="line-height-50 font-size-22">{{insterest.title}}</div>
	        <!-- <div class="line-height-30 font-size-12">wqewq</div> -->
	        <div class="text-align-center margin-top-2">
	          <!-- <img class="images-con border-radius-9" v-bind:src="(config.api+article.img_group[0].photopath)"> -->
	          <img class="images-con border-radius-9" v-bind:src="insterest.image">
	        </div>
            <div class="detailContent" v-html="insterest.content" style="width: 80%;margin-top: 20px"></div>
	        <!-- <div class="detailContent"><p>
                <span style="font-family: &quot;PingFang SC&quot;; text-indent: 28px; white-space: normal; font-size: 28px; font-weight: bold; color: rgb(102, 102, 102);">UMeditor</span><span style="font-family: &quot;PingFang SC&quot;; font-size: 14px; text-indent: 28px; white-space: normal;">,简称UM,是为满足广大门户网站对于简单发帖框，或者回复框需求所定制的在线富文本编辑器。 UM的主要特点就是容量和加载速度上的改变，主文件的代码量为139k，而且放弃了使用传统的iframe模式，采用了div的加载方式， 以达到更快的加载速度和零加载失败率。现在UM的第一个使用者是百度贴吧，贴吧每天几亿的pv是对UM各种指标的最好测试平台。 当然随着代码的减少，UM的功能对于UE来说还是有所减少，但我们经过调研和大家对于UM提出的各种意见，提供了现在UM的功能版本， 虽然有删减，但也有增加，比如拖拽图片上传，chrome的图片拖动改变大小等。让UM能在功能和体积上达到一个平衡。UM还会提供 CDN方式，减少大家部署的成本。我们的目标不仅是要提高在线编辑的编辑体验，也希望能改变前端技术中关于富文本技术的门槛，让大家不再觉得这块是个大坑。</span>
            </p>
            </div> -->

            <div style="width: 100%;margin: 10% 0 20px 0">
                <div class="ivu-card-head" style="background: #eceef2">
                    <p>看帖</p>
                </div>
                <Card v-for="(item,index) in postcardList" :key="index">
                    <p slot="title">
                        <router-link :to="('/page/card/'+item.id)">
                            <span class="tirtleFont lineThrou">{{item.title}}</span>
                        </router-link>
                    </p>
                    <div slot="extra">
                        <Icon type="ios-person"></Icon>
                        {{item.username}}
                    </div>
                    <div>
                        <p>{{item.content}}</p>
                        <span>
                            <Icon type="ios-time"></Icon>
                            {{item.replytime}}
                        </span>
                    </div>
                </Card>
                <div style="margin-top: 20px">
                    <Page :total="total" :page-size="pageInfo.pageSize" show-elevator show-total @on-change="e=>{pageSearch(e)}"></Page>
                </div>
            </div>

            <div class="box-flex width-100 margin-auto margin-top-2 border-top border-color-bfbfbf"></div>

            <div class="box-flex margin-auto margin-top-2 flex-direction-column flex-justify-center flex-items-center" style="width: 100%">
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
                    url: '/insterests/insterest',
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
                  url: '/postcards',
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
                    this.$Message.error('请填写标题和内容');
                }
                
            }
        }
    };
</script>