package com.example.letras

import androidx.car.app.Screen

object MusicState {
    var currentSong: String = "Aguardando música"
    var currentLyrics: String = "A letra aparecerá aqui"
    var activeScreen: Screen? = null

    fun updateMusic(song: String) {
        currentSong = song
        currentLyrics = "Buscando letra na internet"
        activeScreen?.invalidate()

        val pedaços = song.split("\n")
        if (pedaços.size >= 2) {
            val titulo = pedaços[0]
            val artista = pedaços[1]

            // Chama buscador
            LyricsFetcher.buscarLetra(titulo, artista)
        }
    }

    fun updateLyrics(lyrics: String) {
        currentLyrics = lyrics
        activeScreen?.invalidate()
    }
}