package gateway


data class TrackingEvent(
    val name: String,
    val params: Map<String, Any> = emptyMap(),
)
