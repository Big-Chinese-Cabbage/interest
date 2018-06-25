<style type="text/css">
    .test{
        margin: 20px 20px 20px 20px;     
    }
    .test Button{
        margin-bottom: 10px;
    }
</style>
<template>
    <div class="test">
        <a href="https://github.com/login/oauth/authorize?client_id=bbb5cc2034eb62484c1c">
            <Button type="warning">login</Button>
        </a>
    </div>
</template>
<script>
    export default {
        data(){
            return {
                code: null
            }
        },
        mounted(){
            this.code = this.$route.query.code;
            console.log(this.$route.query);
            if(this.code !=null && this.code != ''){
                this.axios({
                    method: 'post',
                    url: '/authentication/github',
                    params:{
                        "code": this.code
                    },
                    auth: {
                        username: 'client',
                        password: 'secret'
                    }
                }).then(function (response) {
                    console.log(response.data);
                    localStorage.setItem("currentUser_token",response.data.access_token);
                    localStorage.setItem("currentUser_refresh_token",response.data.refresh_token);
                    this.axios.defaults.headers.common['Authorization'] = 'bearer '+ localStorage.getItem("currentUser_token");
                    this.$router.push({ path: '/page/home' }) ;
                }.bind(this)).catch(function (error) {
                    alter(error);
                }.bind(this));
            }
        },
        methods: {
            
        }   
    };
</script>