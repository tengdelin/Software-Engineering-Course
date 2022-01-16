import {createRouter, createWebHistory} from 'vue-router'
import Layout from "../layout/Layout";

const routes = [
    {
        path: '/',
        name: 'Layout',
        component: Layout,
        redirect: "/user",
        children: [
            {
                path: 'user',
                name: 'user',
                component: () => import("@/views/User")
            },
            {
                path: 'person',
                name: 'person',
                component: () => import("@/views/Person")
            },
            {
                path: 'student',
                name: 'student',
                component: () => import("@/views/Student")
            },
            {
                path: 'student-index',
                name: 'student-index',
                component: () => import("@/views/Student-index")
            },
            {
                path: '1-sw',
                name: '1-sw',
                component: () => import("@/views/1-sw")
            },
            {
                path: '1-ts',
                name: '1-ts',
                component: () => import("@/views/1-ts")
            },
            {
                path: '2-sw',
                name: '2-sw',
                component: () => import("@/views/2-sw")
            },
            {
                path: '2-ts',
                name: '2-ts',
                component: () => import("@/views/2-ts")
            },
            {
                path: '3-sw',
                name: '3-sw',
                component: () => import("@/views/3-sw")
            },
            {
                path: '3-ts',
                name: '3-ts',
                component: () => import("@/views/3-ts")
            },
            {
                path: '4-sw',
                name: '4-sw',
                component: () => import("@/views/4-sw")
            },
            {
                path: '4-ts',
                name: '4-ts',
                component: () => import("@/views/4-ts")
            },
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import("@/views/Login")
    },
    {
        path: '/register',
        name: 'Register',
        component: () => import("@/views/Register")
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
