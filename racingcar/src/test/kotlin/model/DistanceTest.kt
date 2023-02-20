package model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import me.devyonghee.racingcar.model.Distance

@DisplayName("이동 거리")
class DistanceTest : StringSpec({

    "0 또는 양수로 생성" {
        listOf(0, 1, Int.MAX_VALUE).forAll {
            shouldNotThrowAny {
                Distance.from(it)
            }
        }
    }

    "반드시 0 또는 양수" {
        listOf(-1, Int.MIN_VALUE).forAll {
            shouldThrow<IllegalArgumentException> {
                Distance.from(it)
            }
        }
    }

    "더하기" {
        Distance.from(1) + Distance.from(2) shouldBe Distance.from(3)
    }
})
