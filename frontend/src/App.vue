<template>
  <div class="app">
    <el-container>
      <el-header>
        <el-row align="middle" type="flex" justify="space-between">
          <el-col>
            <h2>Vue 3 + Vite + Element Plus</h2>
          </el-col>
          <el-col>
            <RouterLink to="/">Home</RouterLink>
          </el-col>
        </el-row>
      </el-header>
      <el-main>
        <RouterView />
      </el-main>
    </el-container>
  </div>
</template>

<script setup>
</script>

<style>
.app {
  min-height: 100vh;
}
</style>
