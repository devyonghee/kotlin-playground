package me.devyonghee.racingcar.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class RacingStadiumTest : StringSpec({

    "생성" {
        shouldNotThrowAny {
            RacingStadium(listOf(ONLY_GO_CAR, ONLY_STOP_CAR))
        }
    }

    "race 라운드 수 만큼 트랙을 반환" {
        // given
        val cycleCount = 3
        val racingStadium = RacingStadium(listOf(ONLY_GO_CAR, ONLY_STOP_CAR))
        // when
        val race: List<List<Track>> = racingStadium.race(cycleCount)
        // then
        race shouldHaveSize cycleCount
        race.last() shouldBe listOf(
            Track(ONLY_GO_CAR, Distance(3)),
            Track(ONLY_STOP_CAR, Distance(0))
        )
    }

    "race 순환 횟수는 반드시 양수" {
        // given
        listOf(Int.MIN_VALUE, -1, 0).forAll {
            // when & then
            shouldThrow<IllegalArgumentException> {
                RacingStadium(listOf(ONLY_GO_CAR, ONLY_STOP_CAR)).race(it)
            }
        }
    }
})
