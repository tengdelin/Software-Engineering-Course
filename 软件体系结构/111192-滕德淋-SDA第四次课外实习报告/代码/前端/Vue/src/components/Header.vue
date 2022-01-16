<template>
  <div style="height: 50px;line-height: 50px;border-bottom:1px solid #ccc;display: flex ">
    <div style="width: 200px;padding-left:30px;font-weight:bold;color:dodgerblue">{{ title }}</div>
    <div style="flex: 1"></div>
    <div style="width: 100px">
      <el-dropdown>
        <span class="el-dropdown-link">
           {{ user.nickName }}<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="$router.push('/person')">{{userinfo}}</el-dropdown-item>
            <el-dropdown-item @click="$router.push('/login')">{{logout}}</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  // props:['user'],
  data() {
    return {
      title: '软件测试',
      user: {
        nickName:'小滕'
      },
      userinfo:'个人信息',
      logout:'退出系统'
    }
  },
  created() {
  },
  components:{
  }
}
</script>

<style scoped>

</style>