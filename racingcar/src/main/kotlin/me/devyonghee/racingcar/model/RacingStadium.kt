package me.devyonghee.racingcar.model

class RacingStadium(
    cars: List<RacingCar>,
) {
    private val tracks: List<Track> = cars.map { Track(it) }

    fun racingHistory(cycleCount: Int): List<List<Track>> {
        require(MIN_CYCLE_COUNT <= cycleCount) { "cycle count(${cycleCount}) must be equal or greater than $MIN_CYCLE_COUNT" }
        var currentTracks = tracks
        val history: MutableList<List<Track>> = mutableListOf()
        for (i in 1..cycleCount) {
            currentTracks = currentTracks.nextRounds()
            history.add(currentTracks)
        }
        return history
    }

    companion object {
        private const val MIN_CYCLE_COUNT = 1
    }
}
