package dataDomain

data class SdMainButton(
    override val text: String,
    override val deeplink: SdDeeplink,
    override val style: SdStyle? = null,
    override val tracking: SdTracking? = null,
) : SdButton(text, deeplink, style, tracking)
