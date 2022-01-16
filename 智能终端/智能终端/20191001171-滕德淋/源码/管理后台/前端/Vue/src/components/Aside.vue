<template>
  <div>
    <el-menu
        style="width: 200px;min-height: calc(100vh - 50px)"
        router
        :uniqueOpened="true"
        default-active="2"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
      <el-menu-item index="user">
        <template #title>
          <i class="el-icon-user"></i>
          <span>用户管理</span>
        </template>
      </el-menu-item>
      <el-sub-menu index="1">
        <template #title>
          <i class="el-icon-user-solid"></i>
          <span>实习一</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="1-sw">软件</el-menu-item>
          <el-menu-item index="1-ts">测试</el-menu-item>
        </el-menu-item-group>
      </el-sub-menu>
      <el-sub-menu index="2">
        <template #title>
          <i class="el-icon-menu"></i>
          <span>实习二</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="2-sw">软件</el-menu-item>
          <el-menu-item index="2-ts">测试</el-menu-item>
        </el-menu-item-group>
      </el-sub-menu>
      <el-sub-menu index="3">
        <template #title>
          <i class="el-icon-document"></i>
          <span>实习三</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="3-sw">软件</el-menu-item>
          <el-menu-item index="3-ts">测试</el-menu-item>
        </el-menu-item-group>
      </el-sub-menu>
      <el-sub-menu index="4">
        <template #title>
          <i class="el-icon-setting"></i>
          <span>实习四</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="4-sw">软件</el-menu-item>
          <el-menu-item index="4-ts">测试</el-menu-item>
        </el-menu-item-group>
      </el-sub-menu>
      <el-sub-menu index="5" v-if="user.role === 1">
        <template #title>
          <i class="el-icon-odometer"></i>
          <span>软件工程</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="student">学生信息</el-menu-item>
          <el-menu-item index="student-index">学生主页</el-menu-item>
        </el-menu-item-group>
      </el-sub-menu>
    </el-menu>
  </div>
</template>


<style scoped>

</style>

<script>
import request from "../utils/request";

export default {
  name: "Aside",
  data() {
    return {
      user: {},
      path: this.$route.path   // 设置默认高亮的菜单
    }
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  },
  created() {
    let userJson = sessionStorage.getItem("user");
    if (userJson==null) {
      return
    }
    let userId = JSON.parse(userJson).id
    request.get("/user/" + userId).then(res => {
      console.log(res.data)
      this.user = res.data
    })
  }
}
</script>