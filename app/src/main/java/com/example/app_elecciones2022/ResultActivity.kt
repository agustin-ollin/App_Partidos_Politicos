package com.example.app_elecciones2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView

/**
 * Activity de resultados
 */
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_result)

        cargarDatos()

    }

    /**
     * Función para cargar los datos obtenidos del MainActivity
     */
    fun cargarDatos(){
        val extras: Bundle = intent.extras!!

        val vPan = extras.getInt("pan")
        val vPrd = extras.getInt("prd")
        val vPri = extras.getInt("pri")
        val vPt = extras.getInt("pt")
        val vVerde = extras.getInt("verde")
        val vAlianza = extras.getInt("alianza")
        val vTotal = extras.getInt("cantidadVotos")

        imprimirInterfaz(vPan, vPrd, vPri, vPt, vVerde, vAlianza, vTotal)
    }

    /**
     * Función para imprimir los datos en pantalla
     */
    fun imprimirInterfaz(num1: Int, num2: Int,num3: Int,num4: Int,num5: Int,num6: Int,num7: Int,){
        val pan: TextView = findViewById(R.id.vPan)
        val prd: TextView = findViewById(R.id.vPrd)
        val pri: TextView = findViewById(R.id.vPri)
        val pt: TextView = findViewById(R.id.vPt)
        val verde: TextView = findViewById(R.id.vVerde)
        val alianza: TextView = findViewById(R.id.vAlianza)

        val p1: TextView = findViewById(R.id.porcPan)
        val p2: TextView = findViewById(R.id.porcPrd)
        val p3: TextView = findViewById(R.id.porcPri)
        val p4: TextView = findViewById(R.id.porcPt)
        val p5: TextView = findViewById(R.id.porcVerde)
        val p6: TextView = findViewById(R.id.porcAlianza)
        val total: TextView = findViewById(R.id.total)

        pan.setText(num1.toString())
        prd.setText(num2.toString())
        pri.setText(num3.toString())
        pt.setText(num4.toString())
        verde.setText(num5.toString())
        alianza.setText(num6.toString())
        total.setText(num7.toString())

        p1.setText("${stringFormatRed(convertirPorcentaje(num1, num7))} %")
        p2.setText("${stringFormatRed(convertirPorcentaje(num2, num7))} %")
        p3.setText("${stringFormatRed(convertirPorcentaje(num3, num7))} %")
        p4.setText("${stringFormatRed(convertirPorcentaje(num4, num7))} %")
        p5.setText("${stringFormatRed(convertirPorcentaje(num5, num7))} %")
        p6.setText("${stringFormatRed(convertirPorcentaje(num6, num7))} %")
    }

}