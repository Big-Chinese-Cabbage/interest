<style scoped>
    .layout{
        border: 1px solid #d7dde4;
        background: #e9eaec;
        /*position: relative;*/
        position:absolute;
        left:0;
        top:0;
        width:100%;
        height:100%;
        overflow:auto;
    }
    .layout-breadcrumb{
        padding: 10px 15px 0;
    }
    .layout-content{
        /*height: 80%;*/
        /*min-height: 100%;*/
        min-height: 200px;
        margin: 15px;
        overflow: hidden;
        background: #f8f8f9;
        border-radius: 4px;
        box-shadow: 1px 1px 1px 1px  rgba(0,0,0,.1);
    }
    .layout-content-main{
        padding: 10px;
    }
    .layout-copy{
        height: 4%;
        text-align: center;
        padding: 10px 0 20px;
        color: #009688;
    }
    .layout-menu-left{
        background: #464c5b;
    }
    .layout-header{
        height: 60px;
        background: #f8f8f9;
        box-shadow: 0 1px 1px rgba(0,0,0,.1);
        text-align: right;
    }
    .layout-header img{
        width: 40px;
        height: 40px;
        line-height: 40px; 
        border-radius: 20px;
        margin-top: 10px;
        /*margin-right: 50px;*/
    }
    .layout-header strong{
        color: #ff5722;
        font-size:10px;
    }
    .layout-logo-left{
        width: 50%;
        height: 30px;
        /*background: #5b6270;*/
        border-radius: 3px;
        margin: 15px auto 40px auto;
    }
    .layout-logo-left img{
        width: 20%;
        height: 100%;
    }
    .layout-logo-left strong{
        color: #00bcd4;
        font-size:10px;
    }
    .dropdown-menu{
        text-align: center;
        /*box-shadow: 0 1px 6px #00BCD4;*/
    }
    .layout-nav{
        /*width: 315px;
        margin: 0 auto;
        margin-right: 20px;*/
        height: inherit;
        float: right;
    }
</style>
<template>
    <div class="layout">
        <Row type="flex" style="position:absolute;left:0;top:0;width:100%;">
            <Col span="4" class="layout-menu-left">
                <div class="layout-logo-left">
                        <!-- <img src="../../images/logo.jpg"></img> -->
                        <a @click="backHome()">
                            <img src="../../images/logo.jpg" style="width: 50px;height: 50px;" align="absmiddle">
                            </img>
                        </a>
                        <!-- <img src="../../images/圆图标.png" style="width: 50px;height: 50px;" align="absmiddle"> -->
                        <strong>控制台</strong>
                    </div>
                <Menu active-name="1-2" theme="dark" width="auto" :open-names="['1']" @on-select="m=>{select(m)}">
                    <Submenu v-for="pmenu in menuList" :name="pmenu.id" :key="pmenu.id">
                        <template slot="title">
                            <Icon :type="pmenu.icon"></Icon>
                            {{pmenu.name}}
                        </template>
                        <MenuItem v-for="cmenu in pmenu.children" :name="cmenu.id" :key="cmenu.id">
                            <Icon :type="cmenu.icon"></Icon>
                            {{cmenu.name}}
                        </MenuItem>
                    </Submenu>
                </Menu>
            </Col>
            <Col span="20">
                <div class="layout-header">
                    
                    <Menu mode="horizontal" theme="light"  :style="{height:'65px',width:'100%'}"  @on-select="m=>{menuSelect(m)}" >
                        <div style="width: 95%;margin: 0 auto">
                            <div class="layout-nav">
                               <!--  <MenuItem name="1">
                                    <Icon type="ios-person"></Icon>
                                    {{user.name}}
                                </MenuItem> -->
                                <MenuItem name="2">
                                    <Icon type="ios-person"></Icon>
                                    {{userName}}
                                </MenuItem>
                                <MenuItem name="1">
                                    <Icon type="log-out"></Icon>
                                    退出
                                </MenuItem>
                            </div>
                        </div>
                    </Menu>
                    <!-- <strong>{{userName}}</strong>
                    <Dropdown trigger="click" style="margin-right: 50px" @on-click="m=>{dropdownSelect(m)}">
                        <img src="../../images/user.jpg"></img>
                        <DropdownMenu class="dropdown-menu" slot="list">
                            <DropdownItem>退出</DropdownItem>
                        </DropdownMenu>
                    </Dropdown> -->
                </div>
                <div class="layout-breadcrumb">
                    <Breadcrumb>
                        <BreadcrumbItem to="/base/welcome">Home</BreadcrumbItem>
                        <BreadcrumbItem v-for="item in breadcrumbData" :to="item.url" :key="item.id">{{item.name}}</BreadcrumbItem>
                    </Breadcrumb>
                </div>
                <div class="layout-content">
                    <router-view></router-view>
                </div>
                <div class="layout-copy">
                    2018-2020 &copy; smallsail-wh
                </div>
            </Col>
        </Row>
    </div>
</template>
<script>
    export default {
        data(){
            return {
                /*用户名*/
                userName: null,
                /*一级菜单*/
                menuList: [],
                /*二级菜单*/
                menuSub: [],
                /*面包屑data*/
                breadcrumbData: []
            }
        },
        mounted(){
            /*this.$router.push();*/
            /*this.userName = window.localStorage.getItem("currentUser_name");*/
            this.axios({
                method: 'get',
                url: '/public/user'
            }).then(function(response){
                this.userName = response.data.name;
            }.bind(this)).catch(function(error){
                alert(error);
            });
            this.axios({
                method: 'get',
                url: '/manage/menu',
            }).then(function(response){
                this.menuList = response.data;
                for(var i in this.menuList){
                    for(var j in this.menuList[i].children){
                        this.menuSub.push(this.menuList[i].children[j]);
                    }
                }
            }.bind(this)).catch(function(error){
                alert(error);
            });
        },
        methods:{
            menuSelect(e){
                if(e==1){
                    this.$store.dispatch('users/loginOUt',{"router":this.$router});
                }  
            },
            /*菜单选择事件*/
            select(e){
                var filterMenus = this.menuSub.filter(function(menu){return (menu.url!=null && menu.url!='' && menu.id==e)});
                this.$router.push(filterMenus[0].url);
                this.breadcrumbData.splice(0,1,filterMenus[0]);
            },
            /*下拉菜单选择事件*/
            dropdownSelect(e){
                this.$store.dispatch('users/loginOUt',{"router":this.$router});
            },
            backHome(){
                this.$router.push("/page/home");
            }
        }
    }
</script>
