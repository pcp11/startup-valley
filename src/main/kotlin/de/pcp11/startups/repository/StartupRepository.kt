package de.pcp11.startups.repository

import de.pcp11.startups.model.Startup
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface StartupRepository: ReactiveMongoRepository<Startup, Long>