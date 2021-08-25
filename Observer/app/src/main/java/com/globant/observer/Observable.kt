package com.globant.observer

interface Observable {

    fun notifyNewRule()
    fun notifyNumVueltas(numVueltas : Int)
    fun notifyNewTrack(newTrack : Track)
}