package de.pcp11.startups.controller

import de.pcp11.startups.model.Startup
import de.pcp11.startups.repository.StartupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.math.BigInteger
import java.security.SecureRandom


@RestController
@RequestMapping("/api")
class StartupController {

    @Autowired
    private lateinit var repository: StartupRepository

    private val secret = generateRandomHexToken()

    @GetMapping("/startups")
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

    @GetMapping("/startup/{id}")
    fun findById(@PathVariable id: Long): Mono<Startup> {
        return repository.findById(id)
    }

    @GetMapping("/secured")
    fun secured(): Mono<String> {
        return Mono.just(secret)
    }

    private final fun generateRandomHexToken(): String {
        val secureRandom = SecureRandom()
        val token = ByteArray(16)
        secureRandom.nextBytes(token)

        return BigInteger(1, token).toString(16) //hex encoding
    }
}

class PageResponse(val data: List<Startup>, val page: Int, val size: Int, val totalResults: Int)