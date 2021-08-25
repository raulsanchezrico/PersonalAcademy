package com.globant.observer

class TeamF1 : Observer{

    private var tracks = mutableListOf<Track>()

    fun getNumTracks() : Int {
        return tracks.size
    }

    override fun update() {
        println("NEW RULE ")
    }

    override fun updateVueltas(numVueltas: Int) {
        println("Vueltas : $numVueltas")
    }

    override fun updateTracks(newTrack: Track) {
        println("Recive new Track")
        println("Name : ${newTrack.track}")
        tracks.add(newTrack)
    }
}