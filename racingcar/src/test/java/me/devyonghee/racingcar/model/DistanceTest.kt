package me.devyonghee.racingcar.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.should
import io.kotest.matchers.types.beOfType

class DistanceTest : StringSpec({

    "0이상 이어야 함" {
        listOf(0, 1, Int.MAX_VALUE).forAll {
            Distance(it) should beOfType<Distance>()
        }
    }

    "0미만이면 예외 발생" {
        listOf(-1, Int.MIN_VALUE).forAll {
            shouldThrow<IllegalArgumentException> {
                Distance(it)
            }
        }
    }
})
