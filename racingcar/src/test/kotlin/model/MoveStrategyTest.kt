package model

import me.devyonghee.racingcar.model.MoveStrategy
import me.devyonghee.racingcar.model.Movement

val GO_MOVE_STRATEGY: MoveStrategy = object : MoveStrategy {
    override fun movement(): Movement {
        return Movement.GO
    }
}

val STOP_MOVE_STRATEGY: MoveStrategy = object : MoveStrategy {
    override fun movement(): Movement {
        return Movement.STOP
    }
}
