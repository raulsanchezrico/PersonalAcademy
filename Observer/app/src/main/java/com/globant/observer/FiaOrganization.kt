package com.globant.observer

class FiaOrganization : Observable {

    private var teamsF1 = mutableListOf<Observer>()

    fun attachObserver(observer : Observer) {
        teamsF1.add(observer)
    }

    fun dettachObserver(observer: Observer) {
        teamsF1.remove(observer)
    }

    fun createNewRule() {
        notifyNewRule()
    }

    fun checkNumVueltas(numVueltas : Int) {
        notifyNumVueltas(numVueltas)
    }

    fun addTrack(track : Track) {
        notifyNewTrack(track)
    }

    override fun notifyNewRule() {
        for(team in teamsF1) {
            team.update()
        }
    }

    override fun notifyNumVueltas(numVueltas: Int) {
        for(team in teamsF1) {
            team.updateVueltas(numVueltas)
        }
    }

    override fun notifyNewTrack(newTrack: Track) {
        for (team in teamsF1) {
            team.updateTracks(newTrack)
        }
    }
}