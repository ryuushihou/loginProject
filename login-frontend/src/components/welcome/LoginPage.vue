<script setup>
import {Lock, User} from "@element-plus/icons-vue";
</script>

<template>
  <div style="text-align: center;margin: 0 20px">
    <div style="margin-top:150px">
      <div style="font-size: 25px;font-weight: bold">LOGIN</div>
    </div>
    <div style="margin-top: 50px">
      <el-input type="text" placeholder="Username/Email">
        <template #prefix>
          <el-icon><User /></el-icon>
        </template>
      </el-input>
      <el-input type="text" placeholder="Password">
        <template #prefix>
          <el-icon><Lock /></el-icon>
        </template>
      </el-input>
    </div>
    <div style="margin-top: 10px">
      <el-row>
        <el-col :span="12" style="text-align: left">
          <el-checkbox v-model="checked1" label="remember me"/>
        </el-col>
        <el-col :span="12" style="text-align: right">
          <el-link>forgot password?</el-link>
        </el-col>

      </el-row>

    </div>
    <div style="margin-top: 50px">
      <el-button style="width: 200px" type="success" plain>Login</el-button>
    </div>
    <el-divider>
      <span style="color: gray;font-size: 13px">No Account</span>
    </el-divider>
    <div>
      <el-button style="width: 200px" type="warning" plain>Register</el-button>
    </div>
  </div>
</template>

<style scoped>

</style>