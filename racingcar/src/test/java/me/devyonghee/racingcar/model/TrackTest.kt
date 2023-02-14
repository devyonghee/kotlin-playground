package me.devyonghee.racingcar.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TrackTest : StringSpec({

    "생성" {
        shouldNotThrowAny {
            Track(ONLY_GO_CAR) shouldBe Track(ONLY_GO_CAR, Distance(0))
        }
    }

    listOf(ONLY_STOP_CAR to Distance(0), ONLY_GO_CAR to Distance(1))
        .forEach {
            "초기 상태에서 ${it.first} nextRound 는 ${it.second}" {
                Track(it.first).nextRound() shouldBe Track(it.first, it.second)
            }

        }
})
