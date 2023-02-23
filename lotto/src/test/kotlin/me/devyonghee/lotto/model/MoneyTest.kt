package me.devyonghee.lotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

@DisplayName("돈")
class MoneyTest : StringSpec({

    "0 또는 양수로 생성" {
        listOf(0, 10).forAll {
            shouldNotThrowAny { Money(it) }
        }
    }

    "음수로 생성 불가" {
        listOf(-1, Int.MIN_VALUE).forAll {
            shouldThrow<IllegalArgumentException> { Money(it) }
        }
    }

    "금액 10 과 3을 곱하면 30" {
        Money(10) * 3 shouldBe Money(30)
    }
})
