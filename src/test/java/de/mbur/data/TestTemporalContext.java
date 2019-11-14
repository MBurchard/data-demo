package de.mbur.data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

class TestTemporalContext {
	private static final Logger LOG = getLogger(TestTemporalContext.class);

	@Test
	void testNotFullyInitialized() {
		// given
		final ExactTemporalContext ctx = new ExactTemporalContext();
		final LocalDateTime now = LocalDateTime.now();

		// when
		ctx.setValidFrom(now);

		// then
		LOG.debug("Duration: {}", ctx.getDuration().toDays());
	}

	@Test
	void testValiditySet() {
		// given
		final ExactTemporalContext ctx = new ExactTemporalContext();
		final LocalDateTime now = LocalDateTime.now();

		// when
		ctx.setValidFrom(now);
		ctx.setValidTo(now.plusMinutes(1));

		// then
		assertThat(ctx.getValidTo().isAfter(ctx.getValidFrom())).isTrue();
		assertThat(ctx.getDuration()).isEqualByComparingTo(Duration.of(1, ChronoUnit.MINUTES));
	}

}
