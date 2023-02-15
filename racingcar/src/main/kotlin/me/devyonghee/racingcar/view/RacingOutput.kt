package me.devyonghee.racingcar.view

import me.devyonghee.racingcar.model.Track

fun printHistory(history: List<List<Track>>) {
    println()
    println("실행 결과")
    history.forEach { tracks ->
        tracks.forEach { track ->
            println("${track.car.name}: ${"-".repeat(track.distance.value)}")
        }
        println()
    }
}

fun printWinners(winners: List<Track>) {
    winners.joinToString(", ") {
        it.car.name
    }.let {
        println("${it}가 최종 우승했습니다.")
    }
}
