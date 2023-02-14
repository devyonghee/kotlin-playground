package me.devyonghee.racingcar.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RacingCarTest : StringSpec({

    "생성" {
        shouldNotThrowAny {
            RacingCar("name", GO_MOVE_STRATEGY)
        }
    }

    "이름은 공백이 안되고 5자 이하" {
        listOf("", "123456").forAll {
            shouldThrow<IllegalArgumentException> {
                RacingCar("123456", GO_MOVE_STRATEGY)
            }
        }
    }

    listOf(STOP_MOVE_STRATEGY to Distance(0), GO_MOVE_STRATEGY to Distance(1))
        .forAll {
            "움직임이 ${it.first.movement()} 라면 움직인 거리는 ${it.second}" {
                // given
                val racingCar = RacingCar("any", it.first)
                // when & then
                racingCar.movedDistance() shouldBe it.second
            }
        }

})

val ONLY_GO_CAR = RacingCar("go", GO_MOVE_STRATEGY)
val ONLY_STOP_CAR = RacingCar("stop", STOP_MOVE_STRATEGY)
