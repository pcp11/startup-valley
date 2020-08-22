import Vue from 'vue';
import Router from 'vue-router';
import StartupListContainer from '@/views/StartupListContainer.vue';
import StartupDetailContainer from '@/views/StartupDetailContainer.vue';

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'startups',
            component: StartupListContainer
        }, {
            path: '/startup/:id',
            name: 'startupDetail',
            component: StartupDetailContainer
        },
        // Otherwise redirect to home
        {
            path: '*',
            redirect: '/'
        }
    ],
});
