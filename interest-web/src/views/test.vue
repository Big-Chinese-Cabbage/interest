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
        <Button type="warning" @click="click()">test</Button>
        <Button type="warning" @click="click2()">测试</Button>
        <Input v-model="value" type="textarea" :rows="4" placeholder="Enter something..."></Input>
    </div>
</template>
<script>
    export default {
        data(){
            return {
                value: null
            }
        },
        methods: {
            click(){
                this.$store.dispatch('userLogin',{"user_name":"test1","user_password":"123","router":this.$router});
                this.$router.push({ path: 'base' }) 
               
            },
            click2(){
                this.axios({
                    /*headers: {'Authorization': 'bearer '+this.$store.state.users.currentUser.UserToken},*/
                    method: 'post',
                    url: '/test',
                    data: {
                        "test": "123456"
                    }
                }).then(function(response){
                    /*console.log(response);*/
                    this.value = response.data;
                }.bind(this)).catch(function(error){
                    console.log(error);
                });
            }
        }   
    };
</script>