import axios from 'axios'

const request = axios.create({
  baseURL: '/api',
  timeout: 10000
})

request.interceptors.request.use((config) => {
  // Add auth tokens here if needed
  return config
})

request.interceptors.response.use(
  (response) => response,
  (error) => {
    // Basic error handling
    return Promise.reject(error)
  }
)

export default request
