package me.devyonghee.lotto.model

class LottoStore(
    private val lottoMachine: LottoMachine
) {

    fun purchasedLotto(money: Money): PurchasedLotto {
        return PurchasedLotto(
            LOTTO_PRICE,
            lottoList(money)
        )
    }

    private fun lottoList(money: Money): Collection<Lotto> {
        return (money / LOTTO_PRICE).let { purchasedCount ->
            (0 until purchasedCount).map {
                lottoMachine.lotto
            }.toList()
        }
    }

    companion object {
        private val LOTTO_PRICE = Money(1000)
    }
}