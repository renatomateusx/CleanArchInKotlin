package com.renatomateusx.clean.arch.main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.util.*

@EnableWebMvc
@SpringBootApplication
@ComponentScan("com.renatomateusx.clean.arch")
@EntityScan("com.renatomateusx.clean.arch")
class Boot {
    companion object{
        @JvmStatic
        fun main(args: Array<String>){
            TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"))
            runApplication<Boot>(*args)
        }
    }
}