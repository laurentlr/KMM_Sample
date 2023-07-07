package dataDomain

sealed class SdButton(
    open val text: String,
    open val deeplink: SdDeeplink,
    open val style: SdStyle?,
    open val tracking: SdTracking? = null,
) : SdAtom
