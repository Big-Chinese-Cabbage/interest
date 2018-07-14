<template>
    <div class="home">
        <div >
            <Carousel autoplay v-model="value2" loop >
                <CarouselItem v-for="(item,index) in bannerList" :key="index">
                    <router-link :to="('/mobile/detail/'+item.id)">
                        <img :style="{height:'200px'}" class="images-con" v-bind:src="(item.image)">
                    </router-link>
                </CarouselItem>
            </Carousel>
        </div>
        <div v-if="flage" style="background: #f5f7f9;padding: 24px 50px;color: #495060;font-size: 14px;text-align: center;">
            <span>未找到符合条件的结果</span>
        </div>
        <div class="box-flex flex-direction-column margin-top-2">
            <div class="mobile-box-margin box-flex width-80 margin-auto" v-for="(A,index) in homeArticle">
               <div class="box-flex width-100" v-if="index%2==0" style="margin-bottom: 30px;"> 
                <div class="flex-1">
                    <router-link :to="('/mobile/detail/'+A.id)">
                        <img class="mobile-images images-con imgpic" v-bind:src="(A.image)" style="height: 100%;" >
                    </router-link>
                </div>
                <div class="box-flex flex-1 padding-all flex-direction-column">
                    <router-link :to="('/mobile/detail/'+A.id)">
                        <span class="tirtleFont lineThrou">{{A.title}}</span>
                    </router-link>
                    <span class="contentFont">{{A.info}}</span>
                </div>
               </div>
               <div class="box-flex width-100" v-else style="margin-bottom: 30px;"> 
                <div class="box-flex flex-1 padding-all flex-direction-column">
                    <router-link :to="('/mobile/detail/'+A.id)">
                      <span class="tirtleFont lineThrou">{{A.title}}</span>
                    </router-link>
                    <span class="contentFont">{{A.info}}</span>
                </div>
                <div class="flex-1">
                    <router-link :to="('/mobile/detail/'+A.id)">
                        <img class="images-con imgpic" v-bind:src="(A.image)" style="height: 100%;" >
                    </router-link>
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
                flage: false,
                value2: 0,
                homeArticle: [],
                bannerList:[]
            }
        },
        mounted(){
            this.getHomeArticle();
            this.getBanner();
        },
        watch: {
            '$route' : ['getHomeArticle']
        },
        methods: {
            getBanner(){
                this.axios({
                    method: 'get',
                    url: '/public/banners'
                }).then(function (response) {
                    this.bannerList = response.data;
                }.bind(this)).catch(function (error) {
                    this.$Message.error('无权限');
                }.bind(this));
            },
            getHomeArticle(){
                if(this.$route.params.title == null){
                    this.axios({
                        method: 'get',
                        url: '/public/interests'
                    }).then(function (response) {
                        this.homeArticle = response.data;
                    }.bind(this)).catch(function (error) {
                        this.$Message.error('无权限');
                    }.bind(this));
                }else{
                    this.axios({
                        method: 'get',
                        url: '/public/interests',
                        params:{
                            "title":this.$route.params.title
                        }
                    }).then(function (response) {
                        this.homeArticle = response.data;
                        if(this.homeArticle.length == 0){
                            this.flage = true;
                        }else{
                            this.flage = false;
                        }
                        // if (this.homeArticle.length() {
                        //     this.flage = true;
                        // }
                    }.bind(this)).catch(function (error) {
                        this.$Message.error('无权限');
                    }.bind(this));
                }
                
            },
            // login(formLogin){
            //     this.$refs[formLogin].validate((valid) => {
            //         if(valid){
            //             this.$store.dispatch('users/userLogin',{"user_name":this.formLogin.userName,"user_password":this.formLogin.password,"router":this.$router});
            //         }
            //     })
            // }
        }
    };
</script>
<style >
.box-flex .imgpic {
    transition: .7s all;
    opacity: 0.8;
}
.box-flex .imgpic:hover { opacity: 1; box-shadow: 1px 1px 20px #333;
transform:scale(1.1,1.1);cursor: pointer; }
.lineThrou{transition: .8s all;}
.lineThrou:hover{text-decoration:line-through;cursor: pointer}
</style>