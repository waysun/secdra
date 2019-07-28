package com.junjie

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker



@EnableJpaAuditing
@EnableCaching
@EnableAsync
@EnableWebSocketMessageBroker
//@EnableScheduling
@SpringBootApplication
class SecdraWebApplication : SpringBootServletInitializer() {
    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
        // 设置启动类，用于独立tomcat运行的入口
        return builder.sources(SecdraWebApplication::class.java)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SecdraWebApplication>(*args)
        }
    }
}
