<style type="text/css">
.content-background {
  background: #fff;
}
.form {
  padding: 20px;
}
.editor {
  width: 100%;
}
.editor .ql-container {
  height: 30rem;
}
</style>
<template>
	<div class="content-background">
      <Form class="form" ref="entity" :model="entity" :rules="ruleNew" :label-width="80" >
          <Form-item label="标题：" prop="title">
              <Input v-model="entity.title" />
          </Form-item>
          <Form-item label="详情：" prop="content">
              <interest-quill-editor class="editor" v-bind:interestContent="interestContent" @editor-change="e=>{contentGet(e)}"></interest-quill-editor>
          </Form-item>
          <FormItem>
              <Button type="primary" @click="submit('entity')">发布</Button>
              <Button @click="reset()" style="margin-left: 8px">重置</Button>
          </FormItem>
      </Form>
      <Modal v-model="modal" width="360">
        <p slot="header" style="color:#f60;text-align:center">
            <Icon type="ios-information-circle"></Icon>
            <span>温馨提示</span>
        </p>
        <div style="text-align:center">
            <p>为保证服务正常运行，每个用户每日只能发布一篇文章，是否确认发布？</p>
        </div>
        <div slot="footer">
            <Button type="error" size="large" long :loading="modal_loading" @click="publish()">确认</Button>
        </div>
      </Modal>
  </div>
</template>
<script>
import InterestQuillEditor from "../../sys/interest/interest-quill-editor";
export default {
  components: {
    "interest-quill-editor": InterestQuillEditor
  },
  data() {
    return {
      modal:false,
      modal_loading: false,
      interestContent: "",
      content: null,
      /*entity实体*/
      entity: {
        title: null,
        content: null
      },
      /*新建验证*/
      ruleNew: {
        title: [
          {
            type: "string",
            required: true,
            message: "填写标题",
            trigger: "blur"
          }
        ],
        content: [
          {
            type: "string",
            required: true,
            message: "填写内容",
            trigger: "blur"
          }
        ]
      }
    };
  },
  mounted() {
    /*页面初始化调用方法*/
    //this.getTable();
  },
  methods: {
    /*entity实体初始化*/
    initEntity() {
      this.entity.title = null;
      this.entity.content = null;
    },
    /*entityNew设置*/
    entitySet(e) {
      this.entity.title = e.title;
      this.entity.content = e.content;
    },
    contentGet(e) {
      this.entity.content = e;
    },
    submit(entity) {
      this.$refs[entity].validate(valid => {
        if (valid) {
          this.modal = true;
        }
      });
    },
    publish(){
      this.modal_loading =  true;
      this.axios({
        method: "post",
        url: "/article",
        data: this.entity
      }).then(
          function(response) {
            if(response.data.status == "2000"){
              this.interestContent = this.interestContent + ".";
              this.initEntity();
              setTimeout(() => {
                  this.modal_loading = false;
                  this.modal = false;
                  this.$router.push("/article/create/success");
              }, 2000);
            }else if(response.data.status == "6001"){
              this.modal_loading = false;
              this.$Message.error(response.data.message);
            }
            
          }.bind(this)
        ).catch(
          function(error) {
            this.$Message.error("新建失败");
          }.bind(this)
        );
    },
    reset() {
      this.interestContent = this.interestContent + ".";
      this.initEntity();
    }
  }
};
</script>
