package de.mbur.data

import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class UserKotlin() {

	@Embedded
	val context: TemporalContext = DailyTemporalContext();

	@Id
	val id: Long? = null

	val username: String? = null

}