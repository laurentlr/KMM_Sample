package components

import androidx.compose.runtime.Composable
import dataDomain.SdTopCardWithActions
import gateway.EventTrackingGateway

@Composable
internal fun TopCardWithActionView(
    topCardWithActions: SdTopCardWithActions,
    eventTracking: EventTrackingGateway? = null
) {
    topCardWithActions.topCard.Composable(eventTracking)
}
