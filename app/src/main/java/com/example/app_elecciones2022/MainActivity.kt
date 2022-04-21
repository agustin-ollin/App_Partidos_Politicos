package com.example.app_elecciones2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

/**
 * Clase para votar por los diferentes partidos políticos
 */
class MainActivity : AppCompatActivity() {
    var cantidadVotos = 0
    var votPan: Int = 0
    var votPrd: Int = 0
    var votPri: Int = 0
    var votPt: Int = 0
    var votVerde: Int = 0
    var votAlianza: Int = 0

    // Componentes a instanciar
    lateinit var panButton: ImageButton
    lateinit var prdButton: ImageButton
    lateinit var priButton: ImageButton
    lateinit var ptButton: ImageButton
    lateinit var verdeButton: ImageButton
    lateinit var alianzaButton: ImageButton

    lateinit var btnResult: Button

    /**
     * Función OnCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        eventButtonPartidos()
        eventResult()
    }

    /**
     * Función que asigna OnClickListener a Button para ir al activity de resultados
     */
    fun eventResult(){
        btnResult = findViewById(R.id.btnResultados)
        btnResult.setOnClickListener {
            sendActivity()
        }
    }

    /**
     * Función para lanzar Activity
     */
    fun sendActivity(){
        if (votPan == 0 && votPrd == 0 && votPri == 0 && votPt == 0 && votVerde == 0 && votAlianza == 0){
            Toast.makeText(this, "Vote por lo menos por un partido político", Toast.LENGTH_SHORT).show()
        } else{
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("pan", votPan)
            intent.putExtra("prd", votPrd)
            intent.putExtra("pri", votPri)
            intent.putExtra("pt", votPt)
            intent.putExtra("verde", votVerde)
            intent.putExtra("alianza", votAlianza)
            intent.putExtra("cantidadVotos", cantidadVotos)

            startActivity(intent)
        }
    }

    /**
     * Función para asignarle eventos a los Buttons y realizar el incremento de votos a los partidos por los que se quiera votar
     */
    fun eventButtonPartidos(){
        panButton = findViewById(R.id.panButton)
        prdButton = findViewById(R.id.prdButton)
        priButton = findViewById(R.id.priButton)
        ptButton = findViewById(R.id.ptButton)
        verdeButton = findViewById(R.id.verdeButton)
        alianzaButton = findViewById(R.id.alianzaButton)

        panButton.setOnClickListener{
            votPan++
            panButton.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_click))
            contarVotos()
        }

        prdButton.setOnClickListener {
            votPrd++
            prdButton.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_click))
            contarVotos()
        }

        priButton.setOnClickListener {
            votPri++
            priButton.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_click))
            contarVotos()
        }

        ptButton.setOnClickListener {
            votPt++
            ptButton.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_click))
            contarVotos()
        }

        verdeButton.setOnClickListener {
            votVerde++
            verdeButton.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_click))
            contarVotos()
        }

        alianzaButton.setOnClickListener {
            votAlianza++
            alianzaButton.startAnimation(AnimationUtils.loadAnimation(this, R.anim.image_click))
            contarVotos()
        }

    }

    /**
     * Función para incrementar la cantidad de votos totales
     */
    fun contarVotos(){
        cantidadVotos++
    }
}