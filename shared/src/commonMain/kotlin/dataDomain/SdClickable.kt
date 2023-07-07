package dataDomain

data class SdClickable(
    val deeplink: SdDeeplink,
    val tracking: SdTracking? = null,
)
