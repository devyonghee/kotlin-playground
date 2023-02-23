package me.devyonghee.lotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoStoreTest : StringSpec({

    "로또 상점 생성" {
        shouldNotThrowAny {
            LottoStore(OneToSixLottoMachine)
        }
    }

    listOf(
        Money(100) to 0,
        Money(3000) to 3,
        Money(5500) to 5,
    ).forAll {
        "${it.first} 원으로 로또를 구매하면 ${it.second}개 구매" {
            LottoStore(OneToSixLottoMachine)
                .purchasedLotto(it.first)
                .count shouldBe it.second
        }
    }

})
