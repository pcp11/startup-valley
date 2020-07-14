<template>
    <div>
        <StartupList
                v-if="data && data.data"
                :startups="data.data"
                :changePage="changePage"
                :totalPages="totalPages"
                :selectedPage="selectedPage"/>
    </div>
</template>

<script>
    import StartupList from "@/components/StartupList.vue";
    import {myFetch} from "@/utils";
    import config from "@/config";

    export default {
        name: "StartupListContainer",
        components: {
            StartupList
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
                await this.fetchStartupDetails();
            }
        },
        async created() {
            await this.fetchStartupDetails();
        },
        computed: {
            totalPages() {
                return Math.ceil(
                    this.data.totalResults / (this.data.size || config.NUM_OF_ROWS)
                );
            },
            selectedPage() {
                return this.data.page || 1;
            }
        },
        methods: {
            async fetchStartupDetails() {
                this.loading = true;
                this.data = null;
                this.error = null;

                const page = this.$route.query.page || 1;
                const size = this.$route.query.size || config.NUM_OF_ROWS;

                const params = {...this.$route.query, page, size};

                const {data, error} = await myFetch(
                    `${config.ENDPOINT}/startups?${new URLSearchParams(params).toString()}`
                );
                this.data = data;
                this.error = error;
                this.loading = false;
            },
            changePage(page) {
                const {name, params, query: originalQuery} = this.$route;
                const query = {...originalQuery, page};
                this.$router.push({name, params, query});
            }
        }
    };
</script>
