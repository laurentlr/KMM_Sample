package components

import androidx.compose.runtime.Composable
import dataDomain.SdAction
import gateway.EventTrackingGateway

@Composable
internal fun SdAction.Composable(
    shimmerVisibility: Boolean = false,
    eventTracking: EventTrackingGateway? = null
) {
    ActionView(this, shimmerVisibility, eventTracking)
}
