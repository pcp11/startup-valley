package de.pcp11.startups.controller

import de.pcp11.startups.jwt.JwtUtil
import de.pcp11.startups.model.User
import de.pcp11.startups.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/auth")
class AuthenticationController {

    @Autowired
    private lateinit var jwtUtil: JwtUtil

    @Autowired
    private lateinit var repository: UserRepository

    @PostMapping("/signup")
    fun signUp(@RequestBody user: User): Mono<ResponseEntity<Void>> {
        return repository.existsById(user.name)
                .filter { !it }
                .flatMap { repository.save(user) }
                .map { ResponseEntity.status(HttpStatus.CREATED).build<Void>() }
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.CONFLICT).build<Void>()))
    }

    @PostMapping("/login")
    fun login(@RequestBody user: User): Mono<ResponseEntity<Void>> {
        return repository.findById(user.name)
                .filter { it.password == user.password }
                .map {
                    val jwt = jwtUtil.createJwt(it.name)
                    val authCookie = ResponseCookie.fromClientResponse("X-Auth", jwt)
                            .maxAge(3600)
                            .httpOnly(true)
                            .path("/")
                            .secure(false)
                            .build()

                    ResponseEntity.noContent()
                            .header("Set-Cookie", authCookie.toString())
                            .build<Void>()
                }
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()))
    }
}