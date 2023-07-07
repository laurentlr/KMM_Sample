package dataDomain

data class SdCarousel(
    val children: List<SdItem>,
) : SdItem, List<SdItem> by children
