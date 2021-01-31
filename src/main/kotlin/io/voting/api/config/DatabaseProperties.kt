package io.voting.api.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "database")
class DatabaseProperties(val options: Map<String, String>)