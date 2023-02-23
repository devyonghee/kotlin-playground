package me.devyonghee.lotto.model

class PurchasedLotto(
    val price: Money,
    val lottoList: Collection<Lotto>
) {

    val count: Int
        get() = lottoList.size

    val totalPrice: Money
        get() = price * count
}