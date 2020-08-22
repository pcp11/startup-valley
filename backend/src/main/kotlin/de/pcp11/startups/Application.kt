package de.pcp11.startups

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import de.pcp11.startups.dto.StartupDto
import de.pcp11.startups.parser.CSVParser
import de.pcp11.startups.repository.StartupRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import java.io.File
import java.net.URI


@SpringBootApplication
@EnableEncryptableProperties
class Application : CommandLineRunner {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(CommandLineRunner::class.java)
    }

    @Autowired
    private lateinit var repository: StartupRepository

    override fun run(vararg args: String) {
//        repository.deleteAll()
//
//        if (args.isEmpty()) {
//            LOG.info("Usage: ApplicationKt file_path.csv")
//            return
//        }
//        val filePath: String = args[0]
//        val file = File(filePath)
//        val startupList: MutableList<StartupDto> = CSVParser().parse(file)
//
//        // call your function here
//        (1..startupList.size).forEach { id ->
//            val startup = startupList[id - 1]
//            startup.id = id.toLong()
//            repository.save(startup.convert()).block()
//        }
//        LOG.info("StartUps imported: " + repository.count().block())
    }

    @Bean
    fun indexRouter(): RouterFunction<ServerResponse> {
        val redirectToIndex = ServerResponse.temporaryRedirect(URI("/index.html")).build()

        return router {
            GET("/") {
                redirectToIndex
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

