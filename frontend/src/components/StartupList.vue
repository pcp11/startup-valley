<template>
    <div class="container">
        <div class="row search_result_row"
             v-for="startupPair in calcStartupList"
             :key="calcGroupArrayId(startupPair)">
            <div class="row col-xl-6 search_pair_column" v-for="startup in startupPair" :key="startup.id">
                <div class="col mt-5">
                    <router-link :to="{name: 'startupDetail', params: {id: startup.id}}">
                        <div class="card" style="width: 100%;">
                            <div class="card-body">
                                <div class="d-flex flex-row justify-content-between">
                                    <div>
                                        <h5 class="card-title">{{startup.name}} - {{startup.countryCode}}</h5>
                                        <p class="card-text">Total funding: {{formatToUSD(startup.totalFunds)}}</p>
                                    </div>
                                    <div>
                                      <span v-bind:class="{'badge' : true,
                                       'badge-success': (startup.status === 'operating'),
                                       'badge-danger': (startup.status === 'closed'),
                                       'badge-warning': (startup.status === 'acquired')}">{{startup.status}}</span>
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer" style="min-height: 50px;">
                              <span v-for="categorie in parseCategories(startup.categories)"
                                    :key="categorie"
                                    class="badge badge-info mr-2">{{categorie}}</span>
                            </div>
                        </div>
                    </router-link>
                </div>
            </div>
        </div>
        <div class="row mt-5" style="justify-content: center;">
            <nav aria-label="pagination">
                <paginate
                        :page-count="totalPages"
                        :click-handler="changePage"
                        :value="selectedPage"
                        container-class="pagination"
                        prev-class="page-item"
                        prev-link-class="page-link"
                        next-class="page-item"
                        next-link-class="page-link"
                        page-class="page-item"
                        page-link-class="page-link"/>
            </nav>
        </div>
    </div>
</template>

<script>
    import {groupByNum, formatToUSD} from "@/utils";
    import Paginate from "vuejs-paginate";

    export default {
        name: "StartupList",
        components: {
            paginate: Paginate
        },
        props: {
            startups: Array,
            changePage: Function,
            totalPages: Number,
            selectedPage: Number
        },
        computed: {
            calcStartupList() {
                return groupByNum(this.startups, 2);
            }
        },
        methods: {
            calcGroupArrayId(arr) {
                return arr.reduce((str, val) => str + val.id + "-", "");
            },
            formatToUSD(val) {
                return formatToUSD(val);
            },
            parseCategories(categories) {
                return categories.trim()
                    .split("|")
                    .filter(category => !!category);
            }
        }
    };
</script>

<style scoped>
    .search_pair_column {
        margin: 0;
        padding: 0;
        padding-right: 15px;
        padding-left: 15px;
    }
</style>