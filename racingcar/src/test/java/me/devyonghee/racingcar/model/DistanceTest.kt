package me.devyonghee.racingcar.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class DistanceTest : StringSpec({

    "0 또는 양수로 생성" {
        listOf(0, 1, Int.MAX_VALUE).forAll {
            shouldNotThrowAny {
                Distance(it)
            }
        }
    }

    "반드시 0 또는 양수" {
        listOf(-1, Int.MIN_VALUE).forAll {
            shouldThrow<IllegalArgumentException> {
                Distance(it)
            }
        }
    }
})
