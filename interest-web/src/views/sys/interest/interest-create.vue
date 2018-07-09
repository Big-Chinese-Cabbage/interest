<style type="text/css">
    .editor{
        width: 90%;
    }
    .editor .ql-container{
        height: 30rem; 
    }
</style>
<template>
	<div style="margin: 20px;">
        <Form ref="entity" :model="entity" :rules="ruleNew" :label-width="80" >
            <Form-item label="标题：" prop="title">
                <Input v-model="entity.title" style="width: 204px"/>
            </Form-item>
            <Form-item label="简介：" prop="info">
                <Input v-model="entity.info" type="textarea" :autosize="{minRows: 4,maxRows: 5}"style="width: 50%"></Input>
            </Form-item>
            <Form-item label="图片：" prop="image">
                <Upload 
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
            </Form-item>
            <Form-item>
                <img v-if="entity.image != null" :src="entity.image" style="width: 300px;height: 200px">
            </Form-item>
            <Form-item label="详情：" prop="content">
                <!-- <quill-editor class="editor"
                  v-model="content" 
                  ref="myQuillEditor" 
                  :options="editorOption" 
                  @blur="onEditorBlur($event)" @focus="onEditorFocus($event)"
                  @change="onEditorChange($event)">
                </quill-editor> -->
                <interest-quill-editor class="editor" v-bind:interestContent="interestContent" @editor-change="e=>{contentGet(e)}"></interest-quill-editor>
            </Form-item>
            <FormItem>
                <Button type="primary" @click="submit('entity')">提交</Button>
                <Button type="ghost" @click="reset()" style="margin-left: 8px">重置</Button>
            </FormItem>
        </Form>
    </div>
</template>
<script>
    import InterestQuillEditor from './interest-quill-editor'
	export default {
        components: {
            'interest-quill-editor': InterestQuillEditor
        },
        data () {
            return {
                interestContent:'',
                content:null,
                headers:{
                    Authorization:'bearer '+ localStorage.getItem("currentUser_token")
                },
                /*entity实体*/
                entity:{                             
                    title:null,
                    info:null,
                    image:null,
                    content:null
                },
                /*新建验证*/
                ruleNew:{
                    title: [
                        { type:'string',required: true, message: '填写标题', trigger: 'blur' }
                    ],
                    info: [
                        { type:'string',required: true, message: '填写介绍', trigger: 'blur' }
                    ],
                    image: [
                        { type:'string',required: true, message: '上传图片', trigger: 'blur' }
                    ],
                    content: [
                        { type:'string',required: true, message: '填写内容', trigger: 'blur' }
                    ]
                }
            }
        },
        mounted(){
            // console.log(this.$refs.myQuillEditor);
        	/*页面初始化调用方法*/
            //this.getTable();
        },
        methods:{
            /*entity实体初始化*/
            initEntity(){
                this.entity.title = null;
                this.entity.info = null;
                this.entity.image = null;
                this.entity.content = null;
            },
            /*entityNew设置*/
            entitySet(e){
                this.entity.title = e.title;
                this.entity.info = e.info;
                this.entity.image = e.image;
                this.entity.content = e.content;
            },
            dateGet(e){
                var time = new Date(parseInt(e));
                return time.getFullYear()+"-"+(time.getMonth()+1)+"-"+time.getDate()+" "+time.getHours()+":"+time.getMinutes(); 
            },
            listDateSet(e){
                for (var i = e.length - 1; i >= 0; i--) {
                    e[i].time = this.dateGet(e[i].time);
                }
            },
            handleSuccess (res, file) {
                this.entity.image = res.url;
                file.url = res.url;
                file.name = res.url;
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
            contentGet(e){
                this.entity.content = e;
            },
            submit(entity){
                this.$refs[entity].validate((valid) => {
                    if (valid) {
                        this.axios({
                            method: 'post',
                            url: '/admin/interests/interest',
                            data: this.entity
                        }).then(function (response) {
                            this.interestContent = this.interestContent+'.';
                            this.initEntity();
                            this.$Message.info('新建成功');
                        }.bind(this)).catch(function (error) {
                            this.$Message.error('新建失败');
                        }.bind(this));  
                    }
                })
            },
            reset(){
                this.interestContent = this.interestContent+'.';
                this.initEntity();
            }
        }
    }
</script>