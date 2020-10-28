package com.renatomateusx.clean.arch.main

import java.util.*

@SpringBootApplication
class Boot {
    companion object{
        @JvmStatic
        fun main(args: Array<String>){
            TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"))
            runApplication<Boot>(*args)
        }
    }
}