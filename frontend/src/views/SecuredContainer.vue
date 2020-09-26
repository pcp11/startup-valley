<template>
    <Secured :data="data" :error="error"/>
</template>

<script>
    import Secured from "@/components/Secured.vue";
    import {getSecureKey} from "@/backend";

    export default {
        name: "SecuredContainer",
        data() {
            return {
                data: null,
                error: null
            };
        },
        components: {
            Secured
        },
        watch: {
            async $route() {
                await this.testAuthenticated();
            }
        },
        async created() {
            await this.testAuthenticated();
        },
        methods: {
            async testAuthenticated() {
                const {data, error} = await getSecureKey();
                this.data = data;
                this.error = error && error.message || error ;
            }
        }
    };
</script>
