package dataDomain

data class SdTopCard constructor(
    val title: SdText? = null,
    val subtitle: SdText? = null,
    val button: SdButton? = null,
    val icon: SdIcon? = null,
    val style: SdStyle? = null,
    val obfuscatedTitle: SdText? = null,
    val obfuscatedSubtitle: SdText? = null,
    val obfuscatedIcon: SdIcon? = null,
) : SdComponent {

    fun isObfuscable(): Boolean {
        return obfuscatedIcon != null
    }

    fun getIcon(obfuscated: Boolean = false): SdIcon? {
        return if (isObfuscable() && obfuscated) obfuscatedIcon else icon
    }

    fun getTitle(obfuscated: Boolean = false): SdText? {
        return if (isObfuscable() && obfuscated) obfuscatedTitle else title
    }

    fun getSubtitle(obfuscated: Boolean): SdText? {
        return if (isObfuscable() && obfuscated) obfuscatedSubtitle else subtitle
    }
}
