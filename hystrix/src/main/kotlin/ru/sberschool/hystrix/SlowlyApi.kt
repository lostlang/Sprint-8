package ru.sberschool.hystrix

import feign.Param
import feign.RequestLine

interface SlowlyApi {
    @RequestLine("GET {value}")
    fun getPokemon(@Param("value") value:String): Pokemon
}


