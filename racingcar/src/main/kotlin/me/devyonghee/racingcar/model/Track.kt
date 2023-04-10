package me.devyonghee.racingcar.model

data class Track(
    val car: RacingCar,
    val distance: Distance = INIT_DISTANCE
) {

    fun nextRound(): Track {
        return Track(car, distance + car.movedDistance())
    }

    companion object {
        private val INIT_DISTANCE = Distance.from(0)
    }
}

fun List<Track>.nextRounds(): List<Track> {
    return map { it.nextRound() }
}

fun List<Track>.furthestTracks(): List<Track> {
    return filter { track -> track.distance == maxOf { it.distance } }
}
