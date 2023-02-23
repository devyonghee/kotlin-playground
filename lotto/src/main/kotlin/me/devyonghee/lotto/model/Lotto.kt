package me.devyonghee.lotto.model

data class Lotto(
    val lottoNumbers: Collection<LottoNumber>
) {
    init {
        require(lottoNumbers.distinct().size == SIZE) {
            "lottoNumbers(${lottoNumbers}) must not be duplicated and size must be $SIZE"
        }
    }

    companion object {
        const val SIZE = 6
    }
}