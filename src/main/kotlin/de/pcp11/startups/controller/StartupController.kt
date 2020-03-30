package de.pcp11.startups.controller

import de.pcp11.startups.model.Startup
import de.pcp11.startups.repository.StartupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/startups")
class StartupController {

    @Autowired
    private lateinit var repository: StartupRepository

    @GetMapping
    fun findAll(): Flux<Startup> = repository.findAll()
}