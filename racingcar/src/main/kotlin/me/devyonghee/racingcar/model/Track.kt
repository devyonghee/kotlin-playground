package me.devyonghee.racingcar.model

private val initDistance = Distance(0)

class Track(
    val car: RacingCar,
    val distance: Distance = initDistance,
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
}

fun List<Track>.nextRounds(): List<Track> {
    return map { it.nextRound() }
}
