package me.devyonghee.racingcar.model

import kotlin.random.Random

data class RandomMoveStrategy(
    private val random: Random
) : MoveStrategy {

    override fun movement(): Movement {
        return if (MOVE_LIMIT <= random.nextInt(UNTIL_VALUE)) {
            Movement.GO
        } else {
            Movement.STOP
        }
    }

    companion object {
        private const val UNTIL_VALUE: Int = 10
        private const val MOVE_LIMIT: Int = 4

        val default = RandomMoveStrategy(Random.Default)
    }
}
