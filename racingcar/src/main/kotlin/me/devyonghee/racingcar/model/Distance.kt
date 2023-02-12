package me.devyonghee.racingcar.model

class Distance(
    private val value: Int
) {

    init {
        require(value >= 0) { "distance value($value) must be equal or greater than 0" }
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
}
