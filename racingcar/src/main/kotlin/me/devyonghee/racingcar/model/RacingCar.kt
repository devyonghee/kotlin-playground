package me.devyonghee.racingcar.model

data class RacingCar(
    val name: String,
    val moveStrategy: MoveStrategy
) {
    init {
        require(name.isNotBlank()) { "car name must be not blank" }
        require(name.length <= MAX_NAME_LENGTH) { "car name($name) must be equal or less than 5" }
    }

    fun movedDistance(): Distance {
        return if (isGone()) {
            GO_DISTANCE
        } else {
            STOP_DISTANCE
        }
    }

    private fun isGone() = moveStrategy.movement() == Movement.GO

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private val GO_DISTANCE = Distance.from(1)
        private val STOP_DISTANCE = Distance.from(0)
    }
}
