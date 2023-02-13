package me.devyonghee.racingcar.model;


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
