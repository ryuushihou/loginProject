<script setup>
import {Lock, User} from "@element-plus/icons-vue";
import {reactive} from "vue";
import {post} from "@/api";
import router from "@/router";
import {ElMessage} from "element-plus";

const form = reactive({
  username : '',
  password : '',
  remember : false
})

const login = () => {
  if(!form.username || !form.password){
    ElMessage.warning('username and password is required!!')
  }else{
    post('/api/auth/login',{
      username:form.username,
      password:form.password,
      remember:form.remember
    },(message)=>{
      ElMessage.success(message)
      router.push('/index')
    })
  }
}

</script>

<template>
  <div style="text-align: center;margin: 0 20px">
    <div style="margin-top:150px">
      <div style="font-size: 25px;font-weight: bold">LOGIN</div>
    </div>
    <div style="margin-top: 50px">
      <el-input v-model="form.username" type="text" placeholder="Username/Email">
        <template #prefix>
          <el-icon><User /></el-icon>
        </template>
      </el-input>
      <el-input v-model="form.password" type="text" placeholder="Password">
        <template #prefix>
          <el-icon><Lock /></el-icon>
        </template>
      </el-input>
    </div>
    <div style="margin-top: 10px">
      <el-row>
        <el-col :span="12" style="text-align: left">
          <el-checkbox v-model="form.remember" label="remember me"/>
        </el-col>
        <el-col :span="12" style="text-align: right">
          <el-link>forgot password?</el-link>
        </el-col>

      </el-row>

    </div>
    <div style="margin-top: 50px">
      <el-button @click="login" style="width: 200px" type="success" plain>Login</el-button>
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