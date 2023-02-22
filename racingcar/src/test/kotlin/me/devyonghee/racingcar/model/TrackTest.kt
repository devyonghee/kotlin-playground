package me.devyonghee.racingcar.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import me.devyonghee.racingcar.model.Distance
import me.devyonghee.racingcar.model.Track
import me.devyonghee.racingcar.model.furthestTracks

@DisplayName("트랙")
class TrackTest : StringSpec({

    "생성" {
        shouldNotThrowAny {
            Track(ONLY_GO_CAR) shouldBe Track(ONLY_GO_CAR, Distance.from(0))
        }
    }

    listOf(ONLY_STOP_CAR to Distance.from(0), ONLY_GO_CAR to Distance.from(1))
        .forEach {
            "초기 상태에서 ${it.first} nextRound 는 ${it.second}" {
                Track(it.first).nextRound() shouldBe Track(it.first, it.second)
            }
        }

    "멀리간 트랙 반환" {
        // given
        val oneDistanceTrack = Track(ONLY_GO_CAR, Distance.from(1))
        val twoDistanceTrack1 = Track(ONLY_GO_CAR, Distance.from(2))
        val twoDistanceTrack2 = Track(ONLY_GO_CAR, Distance.from(2))
        // when
        val furthestTracks = listOf(
            oneDistanceTrack,
            twoDistanceTrack1,
            twoDistanceTrack2
        ).furthestTracks()
        // then
        furthestTracks shouldBe listOf(twoDistanceTrack1, twoDistanceTrack2)
    }
})
