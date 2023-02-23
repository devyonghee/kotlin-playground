package me.devyonghee.lotto.model

object OneToSixLottoMachine : LottoMachine {

    override val lotto: Lotto
        get() = (1..6).map {
            LottoNumber(it)
        }.let {
            Lotto(it)
        }

}
