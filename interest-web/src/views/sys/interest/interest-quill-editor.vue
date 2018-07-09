<style type="text/css">
</style>
<template>
	<div>
		<Upload 
			v-show="false"
            id="interest-editor"
            ref="upload"
            :headers="headers"
            action="/interest/admin/interest/upload/picture"
            name="picture"
            :show-upload-list="false"
            :before-upload="handleBeforeUpload"
            :on-success="handleSuccess"
            :on-format-error="handleFormatError"
            :format="['jpg','jpeg','png']">
            <Button type="ghost" icon="ios-cloud-upload-outline">上传图片</Button>
        </Upload>
        <quill-editor
          v-model="content" 
          ref="myQuillEditor" 
          :options="editorOption" 
          @blur="onEditorBlur($event)" 
          @focus="onEditorFocus($event)"
          @change="onEditorChange($event)">
        </quill-editor>
    </div>
</template>
<script>
    import VueQuillEditor, { Quill } from 'vue-quill-editor';
    import  ImageResize  from 'quill-image-resize-module';
    // import { ImageDrop } from 'quill-image-drop-module';
    //import Quill from 'quill';
    // Quill.register('modules/imageDrop', ImageDrop);
    Quill.register('modules/imageResize', ImageResize);
    // 工具栏配置
    const toolbarOptions = [
      ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
      ['blockquote', 'code-block'],

      [{'header': 1}, {'header': 2}],               // custom button values
      [{'list': 'ordered'}, {'list': 'bullet'}],
      [{'script': 'sub'}, {'script': 'super'}],      // superscript/subscript
      [{'indent': '-1'}, {'indent': '+1'}],          // outdent/indent
      [{'direction': 'rtl'}],                         // text direction

      [{'size': ['small', false, 'large', 'huge']}],  // custom dropdown
      [{'header': [1, 2, 3, 4, 5, 6, false]}],

      [{'color': []}, {'background': []}],          // dropdown with defaults from theme
      [{'font': []}],
      [{'align': []}],
      ['link', 'image', 'video'],
      ['clean']                                         // remove formatting button
    ]
	export default {
        props: ['interestContent'],
        watch: {
            interestContent: function(newQuestion, oldQuestion) {
                this.content = newQuestion+'';
            }
        },
        data () {
            return {
                content:"",
                editorOption:{},
                headers:{
                    Authorization:'bearer '+ localStorage.getItem("currentUser_token")
                },
                editorOption: {
                    placeholder: '',
                    theme: 'snow',  // or 'bubble'
                    modules: {
                        toolbar: {
                            container: toolbarOptions,  // 工具栏
                            handlers: {
                                'image': function (value) {
                                    if (value) {
                                        document.querySelector('#interest-editor Button').click()
                                    } else {
                                        this.quill.format('image', false);
                                    }
                                }.bind(this)
                            }
                        },
                        // imageDrop: true,
                        imageResize: {
                            displayStyles: {
                                backgroundColor: 'black',
                                border: 'none',
                                color: 'white'
                            },
                            displaySize: true
                        }
                    }
                }
            }
        },
        mounted(){
        },
        methods:{
            handleSuccess (res, file) {
                // 获取富文本组件实例
                let quill = this.$refs.myQuillEditor.quill;
                // 获取光标所在位置
                let length = quill.getSelection().index;
                // 插入图片  res.info为服务器返回的图片地址
                quill.insertEmbed(length, 'image', res.url);
                // 调整光标到最后
                //quill.setSelection(length + 1)
            },
            handleBeforeUpload () {
                this.$refs.upload.fileList.splice(0, this.$refs.upload.fileList.length);
                return true;
            },
            handleFormatError (file) {
                this.$Notice.warning({
                    title: '图片格式不对',
                    desc: '图片格式只能为jpg,jpeg,png'
                });
            },
            onEditorBlur(){//失去焦点事件
            },
            onEditorFocus(){//获得焦点事件
            },
            onEditorChange(){//内容改变事件
            	this.$emit('editor-change',this.content);
            },
            
        }
    }
</script>