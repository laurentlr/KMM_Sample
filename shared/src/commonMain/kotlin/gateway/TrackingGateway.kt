package gateway

interface EventTrackingGateway {

    fun trackInteraction(event: TrackingEvent)

    fun trackScreen(event: TrackingEvent)

    fun trackView(event: TrackingEvent)
}

interface UserTrackingGateway {

    suspend fun trackLogin(userId: String, token: String, params: Map<String, Any>)

    fun trackLogout()

    fun trackProfile(params: Map<String, Any>)
}

interface ErrorTrackingGateway {
    fun track(throwable: Throwable, vararg keys: Pair<String, Any>)

    fun log(message: String)

    fun applyKey(key: String, value: Any)

    fun setUserId(userId: String)
}

interface SessionRecordingGateway {
    fun startRecording()

    fun tagScreenName(screenName: String, additionalTag: String? = null)
}

interface PerformanceTrackingGateway {

    fun startTrace(name: PerformanceTrace)

    fun stopTrace(name: PerformanceTrace)
}
