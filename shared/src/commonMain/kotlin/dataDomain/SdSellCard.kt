package dataDomain

data class SdSellCard(
    val title: SdText? = null,
    val body: SdText? = null,
    val button: SdButton? = null,
    val icon: SdIcon? = null,
    val style: SdStyle? = null,
    val clickable: SdClickable? = null,
) : SdComponent
