package de.pcp11.startups.controller

import de.pcp11.startups.model.Startup
import de.pcp11.startups.repository.StartupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/startups")
@CrossOrigin("*")
class StartupController {

    @Autowired
    private lateinit var repository: StartupRepository

    @GetMapping
    fun findAll(@RequestParam(name = "page", defaultValue = "1") page: Int,
                @RequestParam(name = "size", defaultValue = "50") size: Int): Mono<PageResponse> {
        return repository.findByOrderByTotalFundsDesc()
                .collectList()
                .map { data ->
                    PageResponse(
                            data.asSequence()
                                    .drop((page - 1) * size)
                                    .take(size)
                                    .toList(),
                            page,
                            size,
                            data.size)
                }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Mono<Startup> {
        return repository.findById(id)
    }
}

class PageResponse(val data: List<Startup>, val page: Int, val size: Int, val totalResults: Int)