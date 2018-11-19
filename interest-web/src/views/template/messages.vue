<template>
    <div class="unread-msg-wrapper">
        <Card v-for="(item, index) in messages" :key="index">
            回复的消息。。。{{index}}
        </Card>
    </div>
    
</template>

<script>
    export default {
        name: 'messages',

        data () {
            return {
                messages: []
            };
        },

        mounted() {
            let _this = this;
            this.axios.get('/msgrecords/user')
                .then(function (response) {
                    _this.messages = response.data;
                    console.log(response);
                }).catch(function (error) {
                    _this.$Message.error('查询失败，请稍后重试');
                });
        }
    };
</script>

<style scoped lang="scss">

</style>