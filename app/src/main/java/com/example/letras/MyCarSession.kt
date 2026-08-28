package com.example.letras

import android.content.Intent
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.Session
import androidx.car.app.model.Action
import androidx.car.app.model.LongMessageTemplate
import androidx.car.app.model.Template

class MyCarSession : Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        return LyricScreen(carContext)
    }
}

class LyricScreen(carContext: CarContext) : Screen(carContext) {

    init {
        MusicState.activeScreen = this
    }

    override fun onGetTemplate(): Template {
        // Pega a música e letra
        val musica = MusicState.currentSong
        val letra = MusicState.currentLyrics

        // Arruma o título pra barra superior
        val tituloFormatado = musica.replace("\n", " - ")

        // Cria a tela de texto longo que permite rolar para baixo
        return LongMessageTemplate.Builder(letra)
            .setTitle(tituloFormatado)
            .setHeaderAction(Action.BACK)
            .build()
    }
}