<template>
    <div class="unread-msg-wrapper">
        <Card v-for="(item, index) in messages" :key="item.id" class="msg-card-item">
            <div @click="read(item.id,item.isread)">
                <div class="synopsis">
                    <Avatar shape="square" icon="person" :src="item.replyUserHeadimg" :title="item.replyUsername" />

                    <span class="user-name">{{item.replyUsername}}</span>
                    <span class="time">{{dateGet(item.replytime)}}</span>
                    <span>回复：</span>

                    <router-link :to="{ path: 'card/' + item.cardid }"><span class="post-title">{{item.postCardTitle}}</span></router-link>
                </div>
                <Divider /> 
                <div class="reply-content">
                    <p>{{item.replyContent}}</p>
                </div>

                <Icon v-if="item.isread == 0" class="unread-symbol" type="chatbox-working" color="red" size="20"></Icon>
            </div>
        
        </Card>

        <Page :total="totalCount" class="pagin" show-total
            @on-change=""></Page>
    </div>
    
</template>

<script>
export default {
  name: "messages",

  data() {
    return {
      messages: [],
      pageSize: 10,
      page: 0,
      totalCount: 0
    };
  },

  mounted() {
    let _this = this;
    this.axios
      .get(
        "/msgrecords/user?pageSize= " + _this.pageSize + "&page=" + _this.page
      )
      .then(function(response) {
        let data = response.data.data;
        _this.messages = data.data;
        _this.totalCount = data.totalCount;
        console.log(response);
      })
      .catch(function(error) {
        _this.$Message.error("查询失败，请稍后重试");
      });
  },

  methods: {
    read(id, isread) {
      if (isread == 1) {
        return;
      }
      let _this = this;
      this.axios({
        method: "put",
        url: "/msgrecords/read/",
        params: {
          msgRecordId: id
        }
      })
        .then(
          function(response) {
            let index = _this.messages.findIndex(function(item) {
              return item.id == id;
            });

            let item = _this.messages[index];
            item.isread = 1;

            _this.messages.splice(index, 1, item);
          }.bind(this)
        )
        .catch(function(error) {
          _this.$Message.error("已读失败，请稍后重试");
        });
      // this.axios.put('/msgrecords/read/',{
      //     msgRecordId: id
      // }).then(function() {
      //     let index = _this.messages.findIndex(function(item) {
      //         return item.id == id;
      //     });

      //     let item = _this.messages[index];
      //     item.isread = 1;

      //     _this.messages.splice(index, 1, item);
      // }).catch(function (error) {
      //     _this.$Message.error('已读失败，请稍后重试');
      // });
    }
  }
};
</script>

<style scoped lang="scss">
.unread-msg-wrapper {
  position: relative;
  margin: auto;
  padding: 20px 0;

  .msg-card-item {
    cursor: pointer;
  }

  .unread-symbol {
    position: absolute;
    top: 2em;
    right: 0.5em;
  }

  .synopsis {
    padding-right: 10px;
    span {
      line-height: 30px;
      margin-right: 10px;
    }
    .post-title{
      margin-top: 10px;
      word-wrap: break-word;
      word-break: break-all;
      overflow: hidden;
      color: #2d64b3;
    }
  }

  .reply-content {
    padding: 6px 30px;

    p {
      word-wrap: break-word;
      word-break: break-all;
      overflow: hidden;
    }
  }

  .pagin {
    margin: 10px 20px;
  }
}
</style>
