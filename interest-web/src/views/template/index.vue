<style scoped>
.layout {
  border: 1px solid #d7dde4;
  background: #f5f7f9;
  position: relative;
  border-radius: 4px;
  overflow: hidden;
}

.layout-logo {
  /*width: 100px;*/
  /*height: 30px;*/
  /*background: #5b6270;*/
  /*border-radius: 3px;*/
  float: left;
  /*position: relative;*/
  /*top: 15px;
        left: 20px;*/
}

.layout-search {
  height: 30px;
  border-radius: 3px;
  float: left;
  position: relative;
  left: 80px;
}

.layout-nav {
  /*width: 315px;
        margin: 0 auto;
        margin-right: 20px;*/
  height: inherit;
  float: right;
}

.layout-footer-center {
  text-align: center;
}

.demo-spin-icon-load {
  animation: ani-demo-spin 1s linear infinite;
}

.avatar-badge-wrapper {
  position: relative;
  float: right;
  cursor: pointer;
}

.avatar-badge-wrapper .msg-num {
  position: absolute;
  top: 9px;
  right: -12px;
  color: #fff;
  background-color: #2db7f5;
  border-radius: 50%;
  padding: 2px 5px;
  line-height: 1;
}

@keyframes ani-demo-spin {
  from {
    transform: rotate(0deg);
  }
  50% {
    transform: rotate(180deg);
  }
  to {
    transform: rotate(360deg);
  }
}
</style>
<template>
    <div class="layout">
        <Layout>
            <Header style="position: fixed;width: 100%;background:#fff;padding:0 0;z-index: 1000; ">
                <Menu mode="horizontal" theme="light" :style="{height:'65px',width:'100%'}"
                      @on-select="m=>{menuSelect(m)}">
                    <div style="width: 95%;margin: 0 auto">
                        <div class="layout-logo">
                            <a @click="backHome()">
                                <img src="../../images/logo.jpg" style="width: 50px;height: 50px;" align="absmiddle" />
                            </a>
                        </div>
                        <div class="layout-search">
                            <Input v-model="searchValue" icon="android-search" placeholder="Enter something..."
                                   @on-enter="search()" />
                        </div>
                        <div v-if="loginFlag" class="layout-nav">
                            <MenuItem name="1">
                                {{user.name}}
                            </MenuItem>
                            <MenuItem name="2">
                                <Icon type="ios-mail"></Icon>
                                邮件
                            </MenuItem>
                            <MenuItem name="3">
                                <Icon type="md-log-out"></Icon>
                                退出
                            </MenuItem>
                            <MenuItem name="4" v-if="consoleFlag">
                                <Icon type="md-settings"></Icon>
                                控制台
                            </MenuItem>
                        </div>
                        <div  type="success" class="avatar-badge-wrapper" @click="toMessages">

                            <img v-if="loginFlag"
                                 style="width: 30px;height: 30px; margin-top: 16px;border-radius: 100%;"
                                 :src="user.headimg" />

                            <span v-if="unreadMsgCount > 0"  class="msg-num">{{unreadMsgCount}}</span>

                        </div>

                        <div v-if="!loginFlag" class="layout-nav">
                            <MenuItem name="5">
                                <Icon type="md-log-in"></Icon>
                                登录
                            </MenuItem>
                        </div>
                    </div>
                </Menu>
            </Header>
            <Content :style="{margin: '80px 0 0 0', background: '#fff'}">
                <router-view></router-view>
            </Content>
            <Footer class="layout-footer-center">
                <div>
                    <a href="https://github.com/smallsnail-wh" target="_blank">
                        <Icon style="color: rebeccapurple;" size="40" type="logo-github"></Icon>
                    </a>
                </div>
                <p>2018-2020 &copy; smallsail-wh</p>
            </Footer>
        </Layout>

        <Modal :mask-closable="false" :visible.sync="emailModal" :loading="loading" v-model="emailModal" width="600"
               title="联系管理员" @on-ok="emailOk('email')" @on-cancel="cancel()">
            <Form ref="email" :rules="emailRule" :model="email" :label-width="80">
                <FormItem label="标题" prop="title">
                    <Input v-model="email.title" placeholder="请输入标题" />
                </FormItem>
                <FormItem label="email" prop="email">
                    <Input v-model="email.email" placeholder="请输入email" />
                </FormItem>
                <FormItem label="姓名" prop="name">
                    <Input v-model="email.name" placeholder="请输入姓名" />
                </FormItem>
                <FormItem label="内容" prop="content">
                    <Input v-model="email.content" type="textarea" :autosize="{minRows: 2,maxRows: 5}"placeholder="Enter something..." />
                </FormItem>
            </Form>
        </Modal>
    </div>
</template>
<script>
export default {
  data() {
    return {
      loginFlag: false,
      consoleFlag: false,
      loading: true,
      searchValue: "",
      emailModal: false,
      //用户未读消息个数
      unreadMsgCount: 0,
      email: {
        title: "",
        email: "",
        name: "",
        content: ""
      },
      user: {
        loginName: "",
        email: "",
        headimg: "",
        name: ""
      },
      emailRule: {
        title: [
          {
            type: "string",
            required: true,
            message: "请输入密码",
            trigger: "blur"
          }
        ],
        email: [
          { required: true, message: "输入邮箱", trigger: "blur" },
          { type: "email", message: "输入正确的邮箱格式", trigger: "blur" }
        ],
        passwordAgain: [
          {
            type: "string",
            required: true,
            message: "请输入再次输入密码",
            trigger: "blur"
          }
        ],
        name: [
          {
            type: "string",
            required: true,
            message: "请输入姓名",
            trigger: "blur"
          }
        ],
        content: [{ required: true, message: "请输入内容", trigger: "blur" }]
      }
    };
  },
  mounted() {
    var code = this.$route.query.code;
    var state = this.$route.query.state;
    if (this.$store.getters._isMobile) {
      if (code != null && code != "" && state != null && state != "") {
        this.$router.replace("/mobile" + "?code=" + code + "&state=" + state);
        return;
      } else {
        this.$router.replace("/mobile");
        return;
      }
    }
    this.login(code, state);
  },
  methods: {
    userGet() {
      let _this = this;
      this.axios({
        method: "get",
        url: "/public/user"
      })
        .then(
          function(response) {
            if (response.data.data != null && response.data.data != "") {
              this.loginFlag = true;
              this.userSet(response.data.data);
              if (response.data.data.usertype == 1) {
                this.consoleFlag = true;
              }

              return this.axios({
                method: "get",
                url: "/msgrecords/unreadnum"
              });
            } else {
              return Promise.resolve(0);
            }
          }.bind(this)
        )
        .then(function(response) {
          if (response === 0) {
            _this.unreadMsgCount = response;
          } else {
            _this.unreadMsgCount = response.data.data;
          }
        })
        .catch(
          function(error) {
            this.$Message.error("无权限");
          }.bind(this)
        );
    },
    userSet(e) {
      this.user.loginName = e.loginName;
      this.user.email = e.email;
      this.user.headimg = e.headimg;
      this.user.name = e.name;
    },
    search() {
      if (this.searchValue != null && this.searchValue != "") {
        this.$router.push("/page/home/" + this.searchValue);
      }
    },
    menuSelect(e) {
      if (e == 1) {
      } else if (e == 2) {
        this.emailModal = true;
      } else if (e == 3) {
        this.$store.dispatch("users/loginOUt", { router: this.$router });
      } else if (e == 4) {
        this.$router.push("/base");
      } else if (e == 5) {
        this.$router.push("/login");
      }
    },
    backHome() {
      this.$router.push("/page/home");
    },
    cancel() {
      this.$Message.info("点击了取消");
    },
    emailOk(email) {
      this.$refs[email].validate(valid => {
        if (valid) {
          this.axios({
            method: "post",
            url: "/email",
            data: this.email
          })
            .then(
              function(response) {
                this.$Message.info("发送成功");
              }.bind(this)
            )
            .catch(function(error) {
              alert(error);
            });
          this.emailModal = false;
        } else {
          this.$Message.error("表单验证失败!");
          setTimeout(() => {
            this.loading = false;
            this.$nextTick(() => {
              this.loading = true;
            });
          }, 1000);
        }
      });
    },
    /*登录*/
    login(code, state) {
      if (code != null && code != "" && state != null && state != "") {
        this.$Spin.show({
          render: h => {
            return h("div", [
              h("Icon", {
                style: {
                  animation: "ani-demo-spin 1s linear infinite"
                },
                props: {
                  type: "load-c",
                  size: 18
                }
              }),
              h("div", "正在登录，请等待...")
            ]);
          }
        });
        setTimeout(() => {
          this.$Spin.hide();
        }, 10000);
        if (state == "github") {
          this.githubLogin(code);
        } else if (state == "qq") {
          this.qqLogin(code);
        } else {
          this.$router.push({ path: "/" });
          location.reload();
        }
      } else {
        this.userGet();
      }
    },
    /*github登录*/
    githubLogin(code) {
      this.axios({
        method: "post",
        url: "/authentication/github",
        params: {
          code: code
        },
        auth: {
          username: "client",
          password: "secret"
        }
      })
        .then(
          function(response) {
            localStorage.setItem(
              "currentUser_token",
              response.data.access_token
            );
            localStorage.setItem(
              "currentUser_refresh_token",
              response.data.refresh_token
            );
            this.axios.defaults.headers.common["Authorization"] =
              "bearer " + localStorage.getItem("currentUser_token");
            this.$router.push({ path: "/" });
            location.reload();
          }.bind(this)
        )
        .catch(
          function(error) {
            this.$Message.error("登陆失败");
          }.bind(this)
        );
    },
    /*qq登录*/
    qqLogin(code) {
      this.axios({
        method: "post",
        url: "/authentication/qq",
        params: {
          code: code
        },
        auth: {
          username: "client",
          password: "secret"
        }
      })
        .then(
          function(response) {
            localStorage.setItem(
              "currentUser_token",
              response.data.access_token
            );
            localStorage.setItem(
              "currentUser_refresh_token",
              response.data.refresh_token
            );
            this.axios.defaults.headers.common["Authorization"] =
              "bearer " + localStorage.getItem("currentUser_token");
            this.$router.push({ path: "/" });
            location.reload();
          }.bind(this)
        )
        .catch(
          function(error) {
            this.$Message.error("登陆失败");
          }.bind(this)
        );
    },

    toMessages() {
      console.log("to messages page");
      this.$router.push({ path: "/page/messages" });
    }
  }
};
</script>
