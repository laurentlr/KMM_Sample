package dataDomain

sealed interface SdItem {
    object Unknown : SdItem
}

interface SdComponent : SdItem
interface SdMolecule : SdItem
interface SdAtom : SdItem
