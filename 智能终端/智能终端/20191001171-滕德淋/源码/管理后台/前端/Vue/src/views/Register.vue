<template>
  <div style="width: 100%; height: 100vh; overflow: hidden;" :style="bg"> <!--  :style="bg" 加背景图片-->
    <div style="width: 400px; margin: 100px auto">
      <div style="font-size: 30px; text-align: center; padding: 30px 0; color:aliceblue">欢迎注册</div>
      <el-form ref="form" :model="form" size="normal" :rules="rules">
        <el-form-item prop="username">
          <el-input prefix-icon="el-icon-user-solid" v-model="form.username" placeholder="请输入账号"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input prefix-icon="el-icon-lock" v-model="form.password" show-password placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item prop="confirm">
          <el-input prefix-icon="el-icon-lock" v-model="form.confirm" show-password placeholder="请确认密码"></el-input>
        </el-form-item>
        <el-form-item prop="nickname">
          <el-input prefix-icon="el-icon-lock" v-model="form.nickName" placeholder="请输入昵称"></el-input>
        </el-form-item>
        <el-form-item prop="age">
          <el-input prefix-icon="el-icon-lock" v-model="form.age" placeholder="请输入年龄"></el-input>
        </el-form-item>
        <el-form-item prop="sex">
          <el-radio v-model="form.sex" label="男">男</el-radio>
          <el-radio v-model="form.sex" label="女">女</el-radio>
        </el-form-item>
        <el-form-item prop="address">
          <el-input type="textarea" prefix-icon="el-icon-lock" v-model="form.address" placeholder="请输入地址"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100% " type="primary" @click="register">注册</el-button>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100% " type="primary" @click="$router.push('/login')">已有账号</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>

import request from "../utils/request";
import md5 from 'js-md5';

export default {
  name: "Login",
  data() {
    return {
      form: {},
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
        ],
        confirm: [
          {required: true, message: '请确认密码', trigger: 'blur'}
        ]
      },
      // 加背景图片
      bg: {
        backgroundImage: "url(" + require("@/assets/bg1.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100% 100%"
      }
    }
  },
  methods: {
    register() {
      if (this.form.password !== this.form.confirm) {
        this.$message({
          type: "error",
          message: '2次密码输入不一致！'
        })
        return
      }

      this.$refs['form'].validate((valid) => {
        if (valid) {
          this.form.role = 2//普通用户
          console.log("前：" + this.form.password)
          this.form.password = md5(this.form.password)
          console.log("后：" + this.form.password)
          request.post("/user/register", this.form).then(res => {
            if (res.code === '0') {
              this.$message({
                type: "success",
                message: "注册成功"
              })
              this.$router.push("/login")  //登录成功之后进行页面的跳转，跳转到主页
            } else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>