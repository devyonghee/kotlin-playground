package me.devyonghee.lotto.model

data class Money(
    val amount: Int
) {
    init {
        require(isZeroOrPositive()) {
            "amount(${amount}) must be greater than 0"
        }
    }


    private fun isZeroOrPositive() = amount >= 0

    operator fun div(money: Money): Int {
        return amount / money.amount
    }

    operator fun times(target: Int): Money {
        return Money(amount * target)
    }
}