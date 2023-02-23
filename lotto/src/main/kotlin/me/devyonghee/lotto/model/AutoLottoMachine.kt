package me.devyonghee.lotto.model

object AutoLottoMachine : LottoMachine {

    private val LOTTO_NUMBERS = (LottoNumber.MIN..LottoNumber.MAX).toList()

    override val lotto: Lotto
        get() = Lotto(LOTTO_NUMBERS.shuffled().take(Lotto.SIZE))
}



