package dataDomain


data class SdBanner(
    val title: SdText? = null,
    val body: SdText? = null,
    val buttons: List<SdButton> = emptyList(),
    val icon: SdIcon? = null,
    val style: SdStyle? = null,
    val tracking: SdTracking? = null,
) : SdComponent
