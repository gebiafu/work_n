<template>
  <div class="home">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>Home</span>
        </div>
      </template>
      <div class="content">
        <p>Welcome! This is your Vue 3 + Vite starter with Router, Pinia, Axios, and Element Plus.</p>
        <p>
          Backend health check:
          <el-button :loading="loading" type="primary" @click="checkHealth">Check</el-button>
          <el-tag v-if="status" type="success" class="ml-2">{{ status }}</el-tag>
        </p>
      </div>
    </el-card>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import request from '../utils/request'

const status = ref('')
const loading = ref(false)

async function checkHealth() {
  loading.value = true
  status.value = ''
  try {
    const { data } = await request.get('/health')
    status.value = data?.status || 'OK'
  } catch (e) {
    status.value = 'ERROR'
  } finally {
    loading.value = false
  }
}
</script>

<style scoped>
.home {
  max-width: 960px;
  margin: 2rem auto;
}
.ml-2 { margin-left: 0.5rem; }
</style>
