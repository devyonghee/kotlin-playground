package me.devyonghee.racingcar.controller

import me.devyonghee.racingcar.model.RacingCar
import me.devyonghee.racingcar.model.RacingStadium
import me.devyonghee.racingcar.model.RandomMoveStrategy
import me.devyonghee.racingcar.model.furthestTracks
import me.devyonghee.racingcar.view.inputCycleCount
import me.devyonghee.racingcar.view.inputNames
import me.devyonghee.racingcar.view.printHistory
import me.devyonghee.racingcar.view.printWinners


object CarRacingGame {

    private const val NAME_DELIMITER = ","

    fun race() {
        val racingHistory = RacingStadium(racingCars())
            .racingHistory(inputCycleCount())
        printHistory(racingHistory)
        printWinners(racingHistory.last().furthestTracks())
    }

    private fun racingCars(): List<RacingCar> {
        return inputNames().split(NAME_DELIMITER).map {
            RacingCar(it, RandomMoveStrategy.default)
        }
    }
}
