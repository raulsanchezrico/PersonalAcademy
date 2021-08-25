package com.globant.observer

interface Observer {

    public fun update()
    public fun updateVueltas(numVueltas : Int)
    fun updateTracks(newTrack : Track)
}