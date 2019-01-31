var webpack = require('webpack');

module.exports = {
  // 基本路径
  publicPath: "/",
  // 当运行 vue-cli-service build 时生成的生产环境构建文件的目录。
  outputDir: "dist",
  // eslint-loader 是否在保存的时候检查
  lintOnSave: false,
  // webpack配置
  // see https://github.com/vuejs/vue-cli/blob/dev/docs/webpack.md
  configureWebpack: {
    externals: {
        'vue': 'Vue',
        'iview':'iview',
        'quill':'Quill',
        'vue-router': 'VueRouter',
        'vuex':'Vuex',
        'axios': 'axios'
    },
    plugins: [
      new webpack.ProvidePlugin({
        'window.Quill': 'quill/dist/quill.js',
        'Quill': 'quill/dist/quill.js'
      }),
    ]
  },
  chainWebpack: () => {},
  // 生产环境是否生成 sourceMap 文件
  productionSourceMap: true,
  // css相关配置
  css: {
    // 是否使用css分离插件 ExtractTextPlugin
    extract: true,
    // 开启 CSS source maps?
    sourceMap: false,
    // css预设器配置项
    loaderOptions: {},
    // 启用 CSS modules for all css / pre-processor files.
    modules: false
  },
  // use thread-loader for babel & TS in production build
  // enabled by default if the machine has more than 1 cores
  parallel: require("os").cpus().length > 1,
  // PWA 插件相关配置
  // see https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-pwa
  pwa: {},
  // webpack-dev-server 相关配置
  devServer: {
    compress: true,
    host: "0.0.0.0",
    port: 8088,
    hotOnly: false,
    proxy: {
      "/interest": {
        target: "http://localhost:8080",
        secure: false
      }
    } // 设置代理
    // before: app => {}
  },
  // 第三方插件配置
  pluginOptions: {
    // ...
  }
};
