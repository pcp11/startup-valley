import Vue from 'vue';
import Router from 'vue-router';
import StartupListContainer from '@/views/StartupListContainer.vue';
import StartupDetailContainer from '@/views/StartupDetailContainer.vue';
import RegisterContainer from '@/views/RegisterContainer.vue';
import LoginContainer from "./views/LoginContainer";
import SecuredContainer from "./views/SecuredContainer";

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'startups',
            component: StartupListContainer
        },
        {
            path: '/startup/:id',
            name: 'startupDetail',
            component: StartupDetailContainer
        },
        {
            path: '/register',
            name: 'register',
            component: RegisterContainer
        },
        {
            path: '/login',
            name: 'login',
            component: LoginContainer
        },
        {
            path: '/secure',
            name: 'secure',
            component: SecuredContainer
        },
        // Otherwise redirect to home
        {
            path: '*',
            redirect: '/'
        }
    ],
});
