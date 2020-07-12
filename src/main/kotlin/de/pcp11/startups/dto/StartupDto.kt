package de.pcp11.startups.dto

import com.opencsv.bean.CsvBindByName
import de.pcp11.startups.model.Startup
import java.time.LocalDate
import kotlin.math.round


class StartupDto {

    @CsvBindByName
    var id: Long? = null;

    @CsvBindByName
    var name: String? = null

    @CsvBindByName
    var market: String? = null

    @CsvBindByName(column = "country_code")
    var countryCode: String? = null

    @CsvBindByName(column = "state_code")
    var stateCode: String? = null

    @CsvBindByName(column = "region")
    var region: String? = null

    @CsvBindByName(column = "city")
    var city: String? = null

    @CsvBindByName(column = "funding_total_usd")
    var totalFunds: String? = null

    @CsvBindByName(column = "funding_rounds")
    var fundingRounds: Int? = null

    @CsvBindByName(column = "homepage_url")
    var homepageUrl: String? = null

    @CsvBindByName(column = "category_list")
    var categories: String? = null

    @CsvBindByName
    var status: String? = null

    @CsvBindByName(column = "founded_at")
    var foundedAt: String? = null

    @CsvBindByName(column = "first_funding_at")
    var firstFoundingAt: String? = null

    @CsvBindByName(column = "last_funding_at")
    var lastFoundingAt: String? = null

    @CsvBindByName(column = "seed")
    var seed: Long? = null

    @CsvBindByName(column = "venture")
    var venture: Long? = null

    @CsvBindByName(column = "equity_crowdfunding")
    var equityCrowdFunding: Long? = null

    @CsvBindByName(column = "undisclosed")
    var undisclosed: Long? = null

    @CsvBindByName(column = "convertible_note")
    var convertibleNote: Long? = null

    @CsvBindByName(column = "debt_financing")
    var debtFinancing: Long? = null

    @CsvBindByName(column = "angel")
    var angel: Long? = null

    @CsvBindByName(column = "grant")
    var grant: Long? = null

    @CsvBindByName(column = "private_equity")
    var privateEquity: Long? = null

    @CsvBindByName(column = "post_ipo_equity")
    var postIpoEquity: Long? = null

    @CsvBindByName(column = "post_ipo_debt")
    var postIpoDebt: Long? = null

    @CsvBindByName(column = "secondary_market")
    var secondaryMarket: Long? = null

    @CsvBindByName(column = "product_crowdfunding")
    var productCrowdFunding: Long? = null

    @CsvBindByName(column = "round_A")
    var roundA: Long? = null

    @CsvBindByName(column = "round_B")
    var roundB: Long? = null

    @CsvBindByName(column = "round_C")
    var roundC: Long? = null

    @CsvBindByName(column = "round_D")
    var roundD: Long? = null

    @CsvBindByName(column = "round_E")
    var roundE: Long? = null

    @CsvBindByName(column = "round_F")
    var roundF: Long? = null

    @CsvBindByName(column = "round_G")
    var roundG: Long? = null

    @CsvBindByName(column = "round_H")
    var roundH: Long? = null

    constructor()
    constructor(
            id: Long?,
            name: String?,
            market: String?,
            countryCode: String?,
            stateCode: String?,
            region: String?,
            city: String?,
            totalFunds: String?,
            fundingRounds: Int?,
            homepageUrl: String?,
            categories: String?,
            status: String?,
            foundedAt: String?,
            firstFoundingAt: String?,
            lastFoundingAt: String?,
            seed: Long?,
            venture: Long?,
            equityCrowdFunding: Long?,
            undisclosed: Long?,
            convertibleNote: Long?,
            debtFinancing: Long?,
            angel: Long?,
            grant: Long?,
            privateEquity: Long?,
            postIpoEquity: Long?,
            postIpoDebt: Long?,
            secondaryMarket: Long?,
            productCrowdFunding: Long?,
            roundA: Long?,
            roundB: Long?,
            roundC: Long?,
            roundD: Long?,
            roundE: Long?,
            roundF: Long?,
            roundG: Long?,
            roundH: Long?
    ) {
        this.id = id
        this.name = name
        this.market = market
        this.countryCode = countryCode
        this.stateCode = stateCode
        this.region = region
        this.city = city
        this.totalFunds = totalFunds
        this.fundingRounds = fundingRounds
        this.homepageUrl = homepageUrl
        this.categories = categories
        this.status = status
        this.foundedAt = foundedAt
        this.firstFoundingAt = firstFoundingAt
        this.lastFoundingAt = lastFoundingAt
        this.seed = seed
        this.venture = venture
        this.equityCrowdFunding = equityCrowdFunding
        this.undisclosed = undisclosed
        this.convertibleNote = convertibleNote
        this.debtFinancing = debtFinancing
        this.angel = angel
        this.grant = grant
        this.privateEquity = privateEquity
        this.postIpoEquity = postIpoEquity
        this.postIpoDebt = postIpoDebt
        this.secondaryMarket = secondaryMarket
        this.productCrowdFunding = productCrowdFunding
        this.roundA = roundA
        this.roundB = roundB
        this.roundC = roundC
        this.roundD = roundD
        this.roundE = roundE
        this.roundF = roundF
        this.roundG = roundG
        this.roundH = roundH
    }

    override fun toString(): String {
        return "StartupDto(id=$id, name=$name, market=$market, countryCode=$countryCode, totalFunds=$totalFunds)"
    }

    fun convert(): Startup {
        val id = this.id!!
        val name = this.name!!.trim()
        val market = this.market!!.trim()
        val countryCode = this.countryCode!!.trim()
        val stateCode = this.stateCode!!.trim()
        val region = this.region!!.trim()
        val city = this.city!!.trim()
        val totalFunds = this.convertFunds()
        val fundingRounds = this.fundingRounds!!
        val homepageUrl = this.homepageUrl!!
        val categories = this.categories!!
        val status = this.status!!
        val foundedAt = this.foundedAt!!.trim()
        val firstFoundingAt = this.firstFoundingAt!!.trim()
        val lastFoundingAt = this.lastFoundingAt!!.trim()
        val seed = this.seed!!
        val venture = this.venture!!
        val equityCrowdFunding = this.equityCrowdFunding!!
        val undisclosed = this.undisclosed!!
        val convertibleNote = this.convertibleNote!!
        val debtFinancing = this.debtFinancing!!
        val angel = this.angel!!
        val grant = this.grant!!
        val privateEquity = this.privateEquity!!
        val postIpoEquity = this.postIpoEquity!!
        val postIpoDebt = this.postIpoDebt!!
        val secondaryMarket = this.secondaryMarket!!
        val productCrowdFunding = this.productCrowdFunding!!
        val roundA = this.roundA!!
        val roundB = this.roundB!!
        val roundC = this.roundC!!
        val roundD = this.roundD!!
        val roundE = this.roundE!!
        val roundF = this.roundF!!
        val roundG = this.roundG!!
        val roundH = this.roundH!!

        return Startup(
                id = id,
                name = name,
                market = market,
                countryCode = countryCode,
                stateCode = stateCode,
                region = region,
                city = city,
                totalFunds = totalFunds,
                fundingRounds = fundingRounds,
                homepageUrl = homepageUrl,
                categories = categories,
                status = status,
                foundedAt = convertToLocalDate(foundedAt),
                firstFoundingAt = convertToLocalDate(firstFoundingAt),
                lastFoundingAt = convertToLocalDate(lastFoundingAt),
                seed = seed,
                venture = venture,
                equityCrowdFunding = equityCrowdFunding,
                undisclosed = undisclosed,
                convertibleNote = convertibleNote,
                debtFinancing = debtFinancing,
                angel = angel,
                grant = grant,
                privateEquity = privateEquity,
                postIpoEquity = postIpoEquity,
                postIpoDebt = postIpoDebt,
                secondaryMarket = secondaryMarket,
                productCrowdFunding = productCrowdFunding,
                roundA = roundA,
                roundB = roundB,
                roundC = roundC,
                roundD = roundD,
                roundE = roundE,
                roundF = roundF,
                roundH = roundH
        )
    }

    private fun convertFunds(): Long {
        return try {
            this.totalFunds!!.replace(",", "").toDouble().toLong()
        } catch (fe: NumberFormatException) {
            0L
        }
    }

    private fun convertToLocalDate(dateString: String?): LocalDate? {
        return if (!dateString.isNullOrEmpty()) LocalDate.parse(dateString) else null
    }
}