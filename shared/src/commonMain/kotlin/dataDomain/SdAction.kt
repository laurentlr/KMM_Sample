package dataDomain

data class SdAction(
    val icon: SdIcon? = null,
    val actionText: SdText? = null,
    val deeplink: SdDeeplink? = null,
    val tracking: SdTracking? = null,
) : SdMolecule
