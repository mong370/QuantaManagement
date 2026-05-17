import AddQuanta from '@/home/AddQuanta.vue'
import CustomizeQuanta from '@/home/CustomizeQuanta.vue'
import ShowQuanta from '@/home/ShowQuanta.vue'
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/add",
      name: "add",
      component: AddQuanta
    },
    {
      path:"/show",
      name: "show",
      component: ShowQuanta
    },
    {
      path:"/custom",
      name:"custom",
      component: CustomizeQuanta
    }
  ],
})

export default router
