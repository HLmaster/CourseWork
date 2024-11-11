<template>
    <div>
        <el-form ref="loginForm" :model="form" :rules="rules" label width=" 80px" class="login-box">
            <h3 class="login-title">欢迎登录</h3>
            <el-form-item label="账号" prop="username">
                <el-input type="text" placeholder=" 请输入账号" v-model="form.username"/>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input type="password" placeholder=" 请输入密码" v-model=" form.password"/>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
                <el-input type="password" placeholder=" 请确认密码" v-model="form.checkPass" />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" v-on:click="onSubmit('loginForm')">注册</el-button>
            </el-form-item>
        </el-form>
        <el-dialog
                title="温馨提示"
                :visible.sync="dialogVisible"
                width="30%"
                :before-close="handleClose">
            <span>请输入账号和密码</span>
            <span slot="footer" class="dialog-footer">
<el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
        </el-dialog>
    </div>
</template>
<script>
    export default {
        name: "Login",
        data() {
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.form.password) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return {
                form: {
                    username: '',
                    password: '',
                    checkPass: '',
                },
// 表单验证， 需要在el-form-item- 元素中增加prop属性
                rules: {
                    checkPass: [{validator: validatePass2, trigger: 'blur'}],
                    username: [{required: true, message: '账号不可为空', trigger: 'blur'}],
                    password: [{required: true, message: '密码不可为空', trigger: 'blur'}]
                },
//对话框显示和隐藏
                dialogVisible: false
            }
        },
        methods: {
            handleClose: function () {
                console.log("Handle Close，空函数");
            },
            onSubmit(formName) {
                //为表单绑定验证功能
                this.$refs [formName].validate((valid) => {
                    if (valid) {
                        this.$axios.post('/register', {
                            username: this.form.username,
                            password: this.form.password
                        })
                            .then(response => {
                                if(response.data.code===20000){
                                    //使用vue-router 路由到指定页面，该方式称之为编程式导航
                                    this.$router.push("/login");
                                    this.$message.success(response.data.msg)
                                }else{
                                    console.log(response.data);
                                    this.$message.error(this.form.username+"已被注册")
                                }
                            })


                    } else {
                        this.dialogVisible = true;
                        return false;
                    }
                });
            },

        },
        created() {
            console.log(this)
        }
    }
</script>
<style scoped>
    .login-box {
        border: 1px solid #DCDFE6;
        width: 350px;
        margin: 50px auto;
        padding: 35px 35px 15px 35px;
        border-radius: 5px;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        box-shadow: 0 0 25px #909399;
    }

    .login-title {
        text-align: center;
        margin: 0 auto 40px auto;
        color: #303133;
    }
</style>
