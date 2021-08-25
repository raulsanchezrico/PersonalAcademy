package com.globant.observer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.globant.observer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var fia : FiaOrganization = FiaOrganization()
    private var redBull : TeamF1 = TeamF1()
    private var ferrari : TeamF1 = TeamF1()
    private var mercedes : TeamF1 = TeamF1()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAdd.setOnClickListener { addTrack() }
        binding.btnNumTracks.setOnClickListener { numTracks() }

        fia.attachObserver(redBull)
        fia.attachObserver(ferrari)
        fia.attachObserver(mercedes)

        fia.createNewRule()
        fia.checkNumVueltas(55)
    }

    fun addTrack() {
        var track : String = binding.tvPista.text.toString()
        var vueltas : Int = binding.tvNumVueltas.text.toString().toInt()
        var longitud : Float = binding.tvLongitud.text.toString().toFloat()
        var curvas : Int = binding.tvCurvas.text.toString().toInt()
        var pais : String = binding.tvPais.toString()
        var ciudad : String = binding.tvCiudad.toString()

        val newTrack : Track = Track(track,vueltas,longitud,curvas,pais,ciudad)
        fia.addTrack(newTrack)

        cleanEdtitexts()
    }

    fun numTracks() {
        var num = redBull.getNumTracks()
        println("Tracks : $num")
    }

    fun cleanEdtitexts() {
        binding.tvPista.setText("")
        binding.tvNumVueltas.setText("")
        binding.tvLongitud.setText("")
        binding.tvCurvas.setText("")
        binding.tvPais.setText("")
        binding.tvCiudad.setText("")
    }
}