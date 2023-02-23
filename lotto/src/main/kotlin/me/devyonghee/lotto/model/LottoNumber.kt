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

    operator fun rangeTo(to: LottoNumber): Iterable<LottoNumber> {
        return (number..to.number).map { LottoNumber(it) }
    }

    companion object {
        private const val MIN_NUMBER: Int = 1
        private const val MAX_NUMBER: Int = 45

        val MIN = LottoNumber(MIN_NUMBER)
        val MAX = LottoNumber(MAX_NUMBER)
    }
}