<template>
    <StartupDetail v-if="data" :startup="data"/>
</template>

<script>
    import StartupDetail from "@/components/StartupDetail.vue";
    import {myFetch} from "@/utils";
    import config from "@/config";

    export default {
        name: "StartupDetailContainer",
        components: {
            StartupDetail
        },
        data() {
            return {
                loading: false,
                data: null,
                error: null
            };
        },
        watch: {
            async $route() {
                await this.fetchStartupDetail();
            }
        },
        async created() {
            await this.fetchStartupDetail();
        },
        methods: {
            async fetchStartupDetail() {
                const startupId = this.$route.params.id;
                this.loading = true;

                const {data, error} = await myFetch(
                    `${config.ENDPOINT}/startups/${startupId}`
                );
                this.data = data;
                this.error = error;
                this.loading = false;
            }
        }
    };
</script>
