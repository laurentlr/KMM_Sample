package dataDomain

data class SdText(
    val text: String,
    val sdStyle: SdStyle? = null,
) : SdAtom
