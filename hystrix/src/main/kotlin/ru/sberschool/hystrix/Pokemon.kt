package ru.sberschool.hystrix

import feign.Param
import feign.RequestLine

class Pokemon {
    var order: Int? = null
    var name: String? = null
    var weight: Int? = null
    var height: Int? = null

    override fun toString(): String {
        return "Pokemon(\n" +
                "\torder=$order,\n" +
                "\tname=$name,\n" +
                "\tweight=$weight,\n" +
                "\theight=$height,\n)"
    }

    override fun equals(other: Any?): Boolean {
        return hashCode() == order.hashCode()
    }

    override fun hashCode(): Int {
        return toString().hashCode()
    }
}

interface PokemonData {
    @RequestLine("GET {poke}")
    fun getPokemon(@Param("poke") poke: String): Pokemon
}