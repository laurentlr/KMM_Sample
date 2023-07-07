package gateway

import kotlin.jvm.JvmInline

/**
 * Names for custom code traces must meet the following requirements:
 * no leading or trailing whitespace, no leading underscore (_) character, and max length is 100 characters.
 */
@JvmInline
value class PerformanceTrace(val value: String)
