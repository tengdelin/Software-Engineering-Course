<template>
  <div>
    <!--    头部-->
    <Header ref="VTU_COMPONENT"  /><!--:user="user"-->
    <!--    主体-->
    <div style="display: flex">
      <!--      侧边栏-->
      <Aside/>
      <!--      内容-->
      <router-view style="flex: 1"/>
    </div>
  </div>
</template>

<script>
import Header from "../components/Header";
import Aside from "../components/Aside";
import request from "../utils/request";

export default {
  name: "Layout",
  components: {
    Header,
    Aside
  },
  data() {
    return {
      user: {}
    }
  },
  created() {
    this.refreshUser()
  },
  methods: {
    refreshUser() {
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
}
</script>

<style scoped>

</style>