package me.devyonghee.racingcar.model

private val FACTORY: MutableMap<Int, Distance> = mutableMapOf()

data class Distance private constructor(
    val value: Int
) : Comparable<Distance> {
    init {
        require(value >= 0) { "distance value($value) must be equal or greater than 0" }
    }

    operator fun plus(distance: Distance): Distance {
        return Distance(this.value + distance.value)
    }

    override fun compareTo(other: Distance): Int {
        return this.value.compareTo(other.value)
    }

    companion object {
        fun from(value: Int): Distance {
            return FACTORY.computeIfAbsent(value, ::Distance)
        }
    }
}
