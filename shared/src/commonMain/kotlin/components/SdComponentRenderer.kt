package components

import androidx.compose.runtime.Composable
import dataDomain.*
import gateway.EventTrackingGateway

@Suppress("ComplexMethod")
@Composable
internal fun SdItem.Composable(eventTracking: EventTrackingGateway? = null) {
    when (this) {
        is SdBanner -> BannerView(this)
        //is SdExplore -> ExploreView(this, eventTracking)
        is SdList -> ListView(this, eventTracking)
        //is SdTransaction -> TransactionView(this)
        is SdSellCard -> SellCardView(this, eventTracking)
        //is SdStrip -> StripView(this)
        is SdTopCard -> TopCardView(this, eventTracking)
        is SdTopCardWithActions -> TopCardWithActionView(this, eventTracking)
        is SdCarousel -> CarouselView(this, eventTracking)
        //is SdAction -> ActionView(this, false, eventTracking)
        //is SdStatus -> StatusView(this, eventTracking)
        //is SdBottomAction -> BottomActionView(this, eventTracking)
        SdItem.Unknown -> Unit
        else -> {}
    }
}
