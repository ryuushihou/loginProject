<script setup>
  import router from "@/router";
  import {ElMessage} from "element-plus";
  import {get} from "@/api";

  const logout = () => {
    get('/api/auth/logout',(message) => {
      ElMessage.success(message)
      router.push('/')
    })
  }

</script>

<template>
<div>
  welcome here！this is a f*****king shit project
</div>
  <div>
    <el-button @click="logout" type="danger" plain>exit</el-button>
  </div>
</template>

<style scoped>

</style>