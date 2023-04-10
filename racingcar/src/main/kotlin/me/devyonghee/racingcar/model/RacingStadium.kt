package me.devyonghee.racingcar.model

data class RacingStadium(
    val cars: List<RacingCar>
) {
    fun racingHistory(cycleCount: Int): List<List<Track>> {
        require(MIN_CYCLE_COUNT <= cycleCount) { "cycle count($cycleCount) must be equal or greater than $MIN_CYCLE_COUNT" }
        var currentTracks = cars.map { Track(it) }
        return (1..cycleCount)
            .map { _ ->
                currentTracks = currentTracks.nextRounds()
                currentTracks
            }
    }

    companion object {
        private const val MIN_CYCLE_COUNT = 1
    }
}
