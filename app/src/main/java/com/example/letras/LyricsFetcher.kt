package com.example.letras

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.URL
import java.net.URLEncoder

object LyricsFetcher {

    fun buscarLetra(titulo: String, artista: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val tituloLimpo = titulo.substringBefore("(").substringBefore("-").trim()
                val artistaLimpo = artista.trim()

                val artistaSeguro = URLEncoder.encode(artistaLimpo, "UTF-8")
                val tituloSeguro = URLEncoder.encode(tituloLimpo, "UTF-8")

                val url = "https://api.lyrics.ovh/v1/$artistaSeguro/$tituloSeguro"

                val resposta = URL(url).readText()

                val json = JSONObject(resposta)
                val letraEncontrada = json.getString("lyrics")

                Handler(Looper.getMainLooper()).post {
                    MusicState.updateLyrics(letraEncontrada)
                }

            } catch (e: Exception) {
                Handler(Looper.getMainLooper()).post {
                    MusicState.updateLyrics("Erro ao carregar a letra")
                }
            }
        }
    }
}