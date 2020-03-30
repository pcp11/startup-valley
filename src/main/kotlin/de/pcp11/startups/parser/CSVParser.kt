package de.pcp11.startups.parser

import com.opencsv.bean.CsvToBeanBuilder
import de.pcp11.startups.dto.StartupDto
import java.io.BufferedReader
import java.io.FileReader

class CSVParser {

    fun parse(filePath: String): MutableList<StartupDto> {
        BufferedReader(FileReader(filePath)).use {
            return CsvToBeanBuilder<StartupDto>(it)
                    .withType(StartupDto::class.java)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse()
        }
    }
}