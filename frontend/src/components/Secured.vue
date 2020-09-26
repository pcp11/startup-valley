<template>
    <div class="container">
        <div class="mt-5">
            <div v-if="this.data !== null">
                <div class="row align-items-center">
                    <div class="col">
                        <h4>Secret Key:</h4>
                    </div>
                    <div class="col">
                        <h4>{{this.data}}</h4>
                    </div>
                </div>
            </div>
            <div v-else>
                <h4>{{this.error}}</h4>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Secured",
        props: {
            data: String,
            error: String
        },
        computed: {},
        methods: {}
    };
</script>