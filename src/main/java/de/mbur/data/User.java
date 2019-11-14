package de.mbur.data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Embedded
	private DailyTemporalContext context = new DailyTemporalContext();
	@Id
	private long id;
	private String username;

	public DailyTemporalContext getContext() {
		return context;
	}

	public void setContext(final DailyTemporalContext context) {
		this.context = context;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}
}
