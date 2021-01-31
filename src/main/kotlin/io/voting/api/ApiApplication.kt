package io.voting.api

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableConfigurationProperties
class ApiApplication(@Value("\${api.version}") val version: String) {

    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
                .info(Info().title("Voting API")
                        .description("Voting management api")
                        .version("v$version"))
    }
}

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
