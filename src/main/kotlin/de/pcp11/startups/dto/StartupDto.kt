package de.pcp11.startups.dto

import com.opencsv.bean.CsvBindByName
import de.pcp11.startups.model.Startup


class StartupDto {

    @CsvBindByName
    var id: Long? = null;

    @CsvBindByName
    var name: String? = null

    @CsvBindByName
    var market: String? = null

    @CsvBindByName(column = "country_code")
    var countryCode: String? = null

    @CsvBindByName(column = "funding_total_usd")
    var totalFunds: String? = null

    @CsvBindByName(column = "homepage_url")
    var homepageUrl: String? = null

    @CsvBindByName(column = "category_list")
    var categories: String? = null

    @CsvBindByName
    var status: String? = null

    constructor()
    constructor(
            id: Long?,
            name: String?,
            market: String?,
            countryCode: String?,
            totalFunds: String?,
            homepageUrl: String?,
            categories: String?,
            status: String?
    ) {
        this.id = id
        this.name = name
        this.market = market
        this.countryCode = countryCode
        this.totalFunds = totalFunds
        this.homepageUrl = homepageUrl
        this.categories = categories
        this.status = status
    }

    override fun toString(): String {
        return "StartupDto(id=$id, name=$name, market=$market, countryCode=$countryCode, totalFunds=$totalFunds)"
    }

    fun convert(): Startup {
        val id = this.id!!
        val name = this.name!!.trim()
        val market = this.market!!.trim()
        val countryCode = this.countryCode!!.trim()
        val totalFunds = this.convertFunds()
        val homepageUrl = this.homepageUrl!!
        val categories = this.categories!!
        val status = this.status!!

        return Startup(
                id = id,
                name = name,
                market = market,
                countryCode = countryCode,
                totalFunds = totalFunds,
                homepageUrl = homepageUrl,
                categories = categories,
                status = status)
    }

    private fun convertFunds(): Long {
        return try {
            this.totalFunds!!.replace(",", "").toDouble().toLong()
        } catch (fe: NumberFormatException) {
            0L
        }
    }
}