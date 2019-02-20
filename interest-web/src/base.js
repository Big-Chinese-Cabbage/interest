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

    Vue.prototype.latestTimeFormat = function(time) {
          if (!time) {
              return '';
          }
          var differ = new Date(new Date() - Number(time));


          var result = differ.getFullYear() - 1970;
          if (result) {
              return result + "年前";
          }

          result = differ.getMonth();

          if (result) {
              return result + "月前";
          }

          result = differ.getDate() - 1;
          if (result) {
              return result + "天前";
          }

          result = differ.getHours() - 8;
          if (result) {
              return result + "小时前";
          }

          result = differ.getMinutes();
          if (result) {
              return result + "分钟前";
          }

          result = differ.getSeconds();
          if (result) {
              return result + "秒前";
          }
      };
  }
};
