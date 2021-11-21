package ru.sberschool.hystrix

class FallbackSlowlyApi : PokemonData {
    override fun getPokemon(poke: String): Pokemon {
        return Pokemon()
    }
}


