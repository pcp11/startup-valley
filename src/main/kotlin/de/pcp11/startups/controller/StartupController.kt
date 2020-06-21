package de.pcp11.startups.controller

import de.pcp11.startups.model.Startup
import de.pcp11.startups.repository.StartupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux


@RestController
@RequestMapping("/startups")
@CrossOrigin("*")
class StartupController {

    @Autowired
    private lateinit var repository: StartupRepository

    @GetMapping
    fun findAll(@RequestParam(name = "page") page: Int,
                @RequestParam(name = "size") size: Int): Flux<Startup> = repository.findAllByIdNotNullOrderByTotalFundsDesc(PageRequest.of(page, size))
}