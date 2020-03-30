package de.pcp11.startups

import de.pcp11.startups.dto.StartupDto
import de.pcp11.startups.parser.CSVParser
import de.pcp11.startups.repository.StartupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application: CommandLineRunner {

	@Autowired
	private lateinit var repository: StartupRepository

	override fun run(vararg args: String?) {
		repository.deleteAll()

		val startups: MutableList<StartupDto> = CSVParser().parse(javaClass.getResource("/investments_VC.csv").path)
		// call your function here
		(1..startups.size).asSequence().forEach { id ->
			val startup = startups[id - 1]
			startup.id = id.toLong()
			repository.save(startup.convert()).block()
		}
		println(repository.count().block())
	}
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
