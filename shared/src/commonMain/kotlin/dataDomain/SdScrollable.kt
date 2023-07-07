package dataDomain

sealed interface SdScrollable {
    object Scroll : SdScrollable
    object NonScroll : SdScrollable
}
