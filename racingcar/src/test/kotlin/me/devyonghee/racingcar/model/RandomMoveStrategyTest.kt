package me.devyonghee.racingcar.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlin.random.Random

@DisplayName("랜덤 이동 전략")
class RandomMoveStrategyTest : StringSpec({
    val random = mockk<Random>()

    "Random 객체로 생성" {
        shouldNotThrowAny {
            RandomMoveStrategy(random)
        }
    }

    listOf(1 to Movement.STOP, 3 to Movement.STOP, 4 to Movement.GO, 9 to Movement.GO).forAll {
        "movement 숫자가 ${it.first}이면 ${it.second}" {
            // given
            every { random.nextInt(any()) } returns it.first
            // when & then
            RandomMoveStrategy(random).movement() shouldBe it.second
        }
    }
})
