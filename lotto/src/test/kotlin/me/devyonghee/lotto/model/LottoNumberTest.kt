package me.devyonghee.lotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

@DisplayName("로또 번호")
class LottoNumberTest : StringSpec({

    "1 ~ 45 사이의 숫자로 생성" {
        (1..45).toList().forAll {
            shouldNotThrowAny {
                LottoNumber(it)
            }
        }
    }

    "숫자 범위를 벗어나면 에러 발생" {
        listOf(Int.MIN_VALUE, -1, 0, 46, Int.MAX_VALUE).forAll {
            shouldThrow<IllegalArgumentException> {
                LottoNumber(it)
            }
        }
    }
})
