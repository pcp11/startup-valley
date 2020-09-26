<template>
    <div class="container">
        <div class="row mt-5">
            <div class="col-md-6 offset-md-3 col-xs-12">
                <h1 class="text-xs-center">Sign up</h1>
                <form @submit.prevent="onSubmit"
                      class="mt-3">
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input v-model="username"
                               type="text"
                               class="form-control"
                               placeholder="username">
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input v-model="password"
                               type="password"
                               class="form-control"
                               placeholder="password">
                    </div>
                    <button type="submit"
                            class="btn btn-primary float-right">Sign up
                    </button>
                    <div>{{this.error}}</div>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
    import {register} from "@/backend";

    export default {
        name: "Register",
        data() {
            return {
                username: "",
                password: "",
                error: null
            };
        },
        computed: {},
        methods: {
            async onSubmit() {
                const {error} = await register(this.username, this.password);
                this.error = error && error.message || error;

                if (!error) {
                    await this.$router.push({name: "startups"});
                }
            }
        }
    };
</script>