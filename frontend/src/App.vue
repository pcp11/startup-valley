<template>
    <div id="app">
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <router-link
                        class="navbar-brand ml-5"
                        active-class="active"
                        exact
                        :to="{ name: 'startups' }">
                    Startup-Valley
                </router-link>
                <button class="navbar-toggler"
                        type="button"
                        data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <router-link
                                    class="nav-link"
                                    active-class="active"
                                    exact
                                    :to="{ name: 'secure' }">
                                Secure
                            </router-link>
                        </li>
                    </ul>
                    <ul class="navbar-nav mr-5">
                        <li class="nav-item">
                            <router-link
                                    class="nav-link"
                                    active-class="active"
                                    exact
                                    :to="{ name: 'login' }">
                                Log in
                            </router-link>
                        </li>
                        <li class="nav-item">
                            <router-link
                                    class="nav-link text-dark"
                                    active-class="active"
                                    exact
                                    :to="{ name: 'register' }">
                                Sign up
                            </router-link>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <router-view/>
    </div>
</template>

<script>
    export default {
        name: "App",
        components: {},
        methods: {}
    }
</script>