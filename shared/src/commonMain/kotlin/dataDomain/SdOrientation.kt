package dataDomain

sealed interface SdOrientation {
    object Horizontal : SdOrientation
    object Vertical : SdOrientation
}
