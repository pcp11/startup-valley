package de.pcp11.startups.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "startups")
data class Startup(
        @Id
        val id: Long,
        val name: String,
        val market: String,
        val countryCode: String,
        val totalFunds: Long
)