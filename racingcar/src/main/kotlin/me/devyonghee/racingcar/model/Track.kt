package me.devyonghee.racingcar.model

class Track(
    val car: RacingCar,
    val distance: Distance = INIT_DISTANCE,
) {

    fun nextRound(): Track {
        return Track(car, distance + car.movedDistance())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Track

        if (car != other.car) return false
        if (distance != other.distance) return false

        return true
    }

    override fun hashCode(): Int {
        var result = car.hashCode()
        result = 31 * result + distance.hashCode()
        return result
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
