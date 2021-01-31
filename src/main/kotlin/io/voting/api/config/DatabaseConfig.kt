package io.voting.api.config

import io.r2dbc.spi.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import reactor.core.publisher.Mono


@Configuration
class DatabaseConfig(val databaseProperties: DatabaseProperties) : AbstractR2dbcConfiguration() {

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        val optionsBuilder = ConnectionFactoryOptions.builder()

        databaseProperties.options.forEach { (key, value) -> optionsBuilder.option(Option.valueOf(key), value) }

        return ConnectionFactories.get(optionsBuilder.build())
    }
}