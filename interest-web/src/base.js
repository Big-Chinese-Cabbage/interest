export default {
  install: function(Vue) {
    Vue.prototype.dateGet = function(e) {
      var time = new Date(Number(e));
      var mounth = time.getMonth() + 1;
      var minute = time.getMinutes();
      if (mounth < 10) {
        mounth = "0" + mounth;
      }
      if (minute < 10) {
        minute = "0" + minute;
      }
      return time.getFullYear() + "-" + mounth + "-" + time.getDate() + " " + time.getHours() + ":" + minute;
    };
  }
};
