package me.devyonghee.lotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

@DisplayName("로또")
class LottoTest : StringSpec({

    "로또 번호는 6개" {
        shouldNotThrowAny {
            Lotto((1..6).map { LottoNumber(it) })
        }
    }

    "로또 번호는 반드시 6개" {
        listOf(1..5, 1..7).forAll {
            Lotto(it.toList().map { number ->
                LottoNumber(number)
            })
        }
    }

    "로또 번호는 중복되면 안됨" {
        shouldNotThrowAny {
            Lotto(listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) })
        }
    }
})
