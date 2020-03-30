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

    constructor()
    constructor(id: Long?, name: String?, market: String?, countryCode: String?, totalFunds: String?) {
        this.id = id
        this.name = name
        this.market = market
        this.countryCode = countryCode
        this.totalFunds = totalFunds
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
        return Startup(id, name, market, countryCode, totalFunds)
    }

    private fun convertFunds(): Long {
        return try {
            this.totalFunds!!.replace(",", "").toDouble().toLong()
        } catch (fe: NumberFormatException) {
            0L
        }
    }
}