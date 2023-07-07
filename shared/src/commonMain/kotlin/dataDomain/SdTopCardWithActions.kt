package dataDomain

data class SdTopCardWithActions(
    val topCard: SdComponent,
    val actions: SdList?,
) : SdComponent
