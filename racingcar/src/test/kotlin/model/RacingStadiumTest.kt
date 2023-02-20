package model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import me.devyonghee.racingcar.model.Distance
import me.devyonghee.racingcar.model.RacingStadium
import me.devyonghee.racingcar.model.Track

@DisplayName("레이싱 경기장")
class RacingStadiumTest : StringSpec({

    "생성" {
        shouldNotThrowAny {
            RacingStadium(listOf(ONLY_GO_CAR, ONLY_STOP_CAR))
        }
    }

    "racingHistory 라운드 수 만큼 트랙을 반환" {
        // given
        val cycleCount = 3
        val racingStadium = RacingStadium(listOf(ONLY_GO_CAR, ONLY_STOP_CAR))
        // when
        val race: List<List<Track>> = racingStadium.racingHistory(cycleCount)
        // then
        race shouldHaveSize cycleCount
        race.last() shouldBe listOf(
            Track(ONLY_GO_CAR, Distance.from(3)),
            Track(ONLY_STOP_CAR, Distance.from(0))
        )
    }

    "racingHistory 순환 횟수는 반드시 양수" {
        // given
        listOf(Int.MIN_VALUE, -1, 0).forAll {
            // when & then
            shouldThrow<IllegalArgumentException> {
                RacingStadium(listOf(ONLY_GO_CAR, ONLY_STOP_CAR)).racingHistory(it)
            }
        }
    }
})
