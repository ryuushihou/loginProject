<script setup></script>

<template>
  <div style="width: 100vw;height: 100vh;overflow: hidden;display: flex">
    <div style="flex: 1;background-color: dodgerblue">
      <el-image style="width: 100%;height: 100%" fit="cover"
                src="/src/assets/photos/1106010.jpg"/>
    </div>
    <div class="welcome-title">
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
      <div>this is my first vue + springboot！</div>
    </div>
    <div style="width: 300px;background-color: white">
      <router-view/>
    </div>
  </div>
</template>

<style scoped>
  .welcome-title{
    position: absolute;
    bottom: 30px;
    left: 30px;
    color: blueviolet;
    text-shadow: 0 0 10px black;
    font-weight: bold;
    font-size: 30px;
  }
</style>