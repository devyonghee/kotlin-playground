package me.devyonghee.racingcar.model

private val FACTORY: MutableMap<Int, Distance> = mutableMapOf()

class Distance private constructor(
    val value: Int,
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Distance

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return "Distance(value=$value)"
    }

    companion object {
        fun from(value: Int): Distance {
            return FACTORY.computeIfAbsent(value, ::Distance)
        }
    }
}
