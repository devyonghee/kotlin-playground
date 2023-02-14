package me.devyonghee.racingcar.model

import kotlin.random.Random

class RandomMoveStrategy(
    private val random: Random
) : MoveStrategy {

    override fun movement(): Movement {
        return if (MOVE_LIMIT <= random.nextInt(UNTIL_VALUE)) {
            Movement.GO
        } else {
            Movement.STOP
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RandomMoveStrategy

        if (random != other.random) return false

        return true
    }

    override fun hashCode(): Int {
        return random.hashCode()
    }

    companion object {
        private const val UNTIL_VALUE: Int = 10;
        private const val MOVE_LIMIT: Int = 4;

        fun default() = RandomMoveStrategy(Random.Default)
    }
}
