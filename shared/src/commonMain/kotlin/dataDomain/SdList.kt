package dataDomain

data class SdList(
    val orientation: SdOrientation = SdOrientation.Vertical,
    val children: List<SdItem> = emptyList(),
    val scrollable: SdScrollable = SdScrollable.NonScroll,
    val indicator: SdIndicator? = null,
) : SdComponent, List<SdItem> by children {
    companion object {
        val DefaultOrientation: SdOrientation = SdOrientation.Vertical
        val DefaultScrollable: SdScrollable = SdScrollable.Scroll
    }
}
