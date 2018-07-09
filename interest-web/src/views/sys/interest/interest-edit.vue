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
        	<Form-item label="兴趣：">
                <Select v-model="interestId" filterable style="width: 200px" @on-change="e=>{selectChange(e)}">
                    <Option v-for="item in interestList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                </Select>
            </Form-item>
            <Form-item label="标题：" prop="title">
                <Input v-model="entity.title" style="width: 204px"/>
            </Form-item>
            <Form-item label="排序：" prop="sort">
                <Input v-model="entity.sort" style="width: 204px"/>
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
                <interest-quill-editor v-bind:interestContent="interestContent"  class="editor" @editor-change="e=>{contentGet(e)}"></interest-quill-editor>
            </Form-item>
            <FormItem>
                <Button type="primary" @click="submit('entity')">修改</Button>
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
            	interestId:null,
            	interestList:[],
                content:null,
                headers:{
                    Authorization:'bearer '+ localStorage.getItem("currentUser_token")
                },
                /*entity实体*/
                entity:{     
                	id:null,                        
                    title:null,
                    info:null,
                    image:null,
                    content:null,
                    sort:null
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
                    ],
                    sort: [
                        { required: true, message: '输入排序', trigger: 'blur' },
                        {validator(rule, value, callback) {
                            if (!Number.isInteger(+value)) {
                                callback(new Error('请输入数字'));
                            } else {
                                callback();
                            }
                          
                        }, trigger: 'blur'}
                    ]
                }
            }
        },
        mounted(){
            // console.log(this.$refs.myQuillEditor);
        	/*页面初始化调用方法*/
            //this.getTable();
            this.axios({
              method: 'get',
              url: '/public/interests'
            }).then(function (response) {
                var listTemp = response.data;
                for (var i = 0; i < listTemp.length; i++) {
                    this.interestList.push({
                        "value": listTemp[i].id,
                        "label": listTemp[i].title
                    });
                }
            }.bind(this)).catch(function (error) {
              alert(error);
            });
        },
        methods:{
            /*entity实体初始化*/
            initEntity(){
            	this.entity.id = null;
                this.entity.title = null;
                this.entity.info = null;
                this.entity.image = null;
                this.entity.content = null;
                this.entity.sort = null;
            },
            /*entityNew设置*/
            entitySet(e){
            	this.entity.id = e.id;
                this.entity.title = e.title;
                this.entity.info = e.info;
                this.entity.image = e.image;
                this.entity.content = e.content;
                this.entity.sort = e.sort+'';
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
                            method: 'put',
                            url: '/admin/interests/interest',
                            data: this.entity
                        }).then(function (response) {
                            this.$Message.info('修改成功');
                        }.bind(this)).catch(function (error) {
                            this.$Message.error('修改失败');
                        }.bind(this));  
                    }
                })
            },
            selectChange(e){
            	this.axios({
                    method: 'get',
                    url: '/public/interests/interest',
                    params: {
                        'id': e
                    }
                }).then(function (response) {
                    this.entitySet(response.data)
                    this.interestContent = this.entity.content;
                }.bind(this)).catch(function (error) {
                    this.$Message.error('请选择');
                }.bind(this)); 
            }
        }
    }
</script>