package de.pcp11.startups.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document(collection = "startups")
data class Startup(
        @Id
        val id: Long,
        val name: String,
        val market: String,
        val countryCode: String,
        val stateCode: String,
        val region: String,
        val city: String,
        val totalFunds: Long,
        val fundingRounds: Int,
        val homepageUrl: String,
        val categories: String,
        val status: String,
        val foundedAt: LocalDate?,
        val firstFoundingAt: LocalDate?,
        val lastFoundingAt: LocalDate?,
        val seed: Long,
        val venture: Long,
        val equityCrowdFunding: Long,
        val undisclosed: Long,
        val convertibleNote: Long,
        val debtFinancing: Long,
        val angel: Long,
        val grant: Long,
        val privateEquity: Long,
        val postIpoEquity: Long,
        val postIpoDebt: Long,
        val secondaryMarket: Long,
        val productCrowdFunding: Long,
        val roundA: Long,
        val roundB: Long,
        val roundC: Long,
        val roundD: Long,
        val roundE: Long,
        val roundF: Long,
        val roundH: Long
)