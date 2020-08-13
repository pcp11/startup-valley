<template>
    <div class="container mt-3">
        <div class="card">
            <div class="card-body">
                <h1 class="card-title">{{startup.name}}</h1>
                <div class="row">
                    <div class="col-md-6 mt-3">
                        <div class="row">
                            <div class="col">Founded At:</div>
                            <div class="col">{{formatDateString(startup.foundedAt)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Status:</div>
                            <div class="col">
                            <span v-bind:class="{'badge' : true,
                                       'badge-success': (startup.status === 'operating'),
                                       'badge-danger': (startup.status === 'closed'),
                                       'badge-warning': (startup.status === 'acquired')}">{{startup.status}}</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">Country:</div>
                            <div class="col">{{startup.countryCode}}</div>
                        </div>
                        <div class="row">
                            <div class="col">State:</div>
                            <div class="col">{{startup.stateCode}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Region:</div>
                            <div class="col">{{startup.region}}</div>
                        </div>
                        <div class="row">
                            <div class="col">City:</div>
                            <div class="col">{{startup.city}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Market:</div>
                            <div class="col">{{startup.market}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Total Funds:</div>
                            <div class="col">{{formatToUSD(startup.totalFunds)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Funding Rounds:</div>
                            <div class="col">{{startup.fundingRounds}}</div>
                        </div>
                        <div class="row">
                            <div class="col">First Funded At:</div>
                            <div class="col">{{formatDateString(startup.firstFoundingAt)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Last Funded At:</div>
                            <div class="col">{{formatDateString(startup.lastFoundingAt)}}</div>
                        </div>
                    </div>
                    <div class="col-md-6 mt-3">
                        <div class="row">
                            <div class="col">Seed:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.seed)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Venture:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.venture)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Equity Crowdfunding:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.equityCrowdFunding)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Undisclosed:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.undisclosed)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Convertible Note:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.convertibleNote)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Debt financing:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.debtFinancing)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Angel:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.angel)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Grant:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.grant)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Private Equity:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.privateEquity)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Post IPO Equity:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.postIpoEquity)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Post IPO Debt:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.postIpoDebt)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Secondary Market:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.secondaryMarket)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Porduct Crowdfunding:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.productCrowdFunding)}}</div>
                        </div>
                        <div class="row mt-3">
                            <div class="col">Round A:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.roundA)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Round B:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.roundB)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Round C:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.roundC)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Round D:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.roundD)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Round E:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.roundE)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Round F:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.roundF)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Round G:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.roundG)}}</div>
                        </div>
                        <div class="row">
                            <div class="col">Round H:</div>
                            <div class="col">{{formatToUSD(startup.fundingDetails.roundH)}}</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-footer" style="min-height: 50px;">
              <span v-for="categorie in parseCategories(startup.categories)"
                    :key="categorie"
                    class="badge badge-info mr-2">{{categorie}}</span>
            </div>
        </div>
    </div>
</template>

<script>
    import {formatToUSD} from "@/utils";

    export default {
        name: "StartupDetail",
        props: {
            startup: Object
        },
        computed: {},
        methods: {
            formatDateString(val) {
                const date = new Date(val);
                return date.toLocaleDateString("en-Us");
            },
            formatToUSD(val) {
                return val !== 0 ? formatToUSD(val) : "-";
            },
            parseCategories(categories) {
                return categories.trim()
                    .split("|")
                    .filter(category => !!category);
            }
        }
    };
</script>