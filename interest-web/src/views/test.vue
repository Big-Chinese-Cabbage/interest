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
            <a>{{test()}}</a>
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
            
        },
        methods: {
            test() {
                return "qwe1";
            }
        }   
    };
</script>