<template>
    <Card class="card">
        <div class="cotent">
            <Icon type="md-checkmark-circle" size="40" color="#19be6b"/>
            <h3>文章发布成功</h3>
            <router-link :to="('/article/user')">
              <h4 class="link-text">返回我的文章</h4>
            </router-link>
        </div>
    </Card>
</template>
<script>
export default {
  data() {
    return {
      
    };
  },
  mounted() {
    
  },
  methods: {
    
  }
};
</script>
<style>
.card {
	height: 400px;
}
.cotent{
	text-align:center;
	margin-top: 150px;
}
.cotent .link-text {
  color: rebeccapurple;
  margin-top: 20px;
}
</style>
