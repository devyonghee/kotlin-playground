package me.devyonghee.lotto.model

data class LottoNumber(
    val number: Int
) {

    init {
        require(isEqualOrGreaterThanMinNumber() && isEqualOrLessThanMaxNumber()) {
            "number(${number}) must between $MIN_NUMBER and $MAX_NUMBER"
        }
    }

    private fun isEqualOrLessThanMaxNumber() = number <= MAX_NUMBER

    private fun isEqualOrGreaterThanMinNumber() = MIN_NUMBER <= number

    companion object {
        const val MIN_NUMBER: Int = 1
        const val MAX_NUMBER: Int = 45
    }
}