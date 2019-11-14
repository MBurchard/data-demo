package de.mbur.data

import java.io.Serializable
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.Temporal
import javax.persistence.Embeddable

interface TemporalContext : Serializable {
	val validFrom: Temporal
	val validTo: Temporal

	fun getDuration(): Duration {
		return Duration.between(validFrom, validTo)
	}
}

@Embeddable
open class ExactTemporalContext : TemporalContext {
	override var validFrom: LocalDateTime = LocalDateTime.MIN
	override var validTo: LocalDateTime = LocalDateTime.MAX
}

@Embeddable
class DailyTemporalContext : TemporalContext {
	override var validFrom: LocalDate = LocalDate.MIN
	override var validTo: LocalDate = LocalDate.MAX
}