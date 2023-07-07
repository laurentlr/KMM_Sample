package dataDomain


data class SdLinkButton(
    override val text: String,
    override val deeplink: SdDeeplink,
    override val style: SdStyle? = null,
    override val tracking: SdTracking? = null,
) : SdButton(text, deeplink, style, tracking)
