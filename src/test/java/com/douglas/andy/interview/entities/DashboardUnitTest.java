package com.douglas.andy.interview.entities;

import org.jeasy.random.EasyRandom;
import org.junit.Test;

import java.sql.Timestamp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DashboardUnitTest {

    @Test
    public void shouldRetrieveValuesAsSet() {

        final EasyRandom generator = new EasyRandom();
        final String title = generator.nextObject(String.class);
        final Integer id = generator.nextInt();
        final Timestamp createdAt = generator.nextObject(Timestamp.class);
        final Timestamp updatedAt = generator.nextObject(Timestamp.class);

        Dashboard dashboard = new Dashboard();
        dashboard.setId(id);
        dashboard.setTitle(title);
        dashboard.setCreatedAt(createdAt);
        dashboard.setUpdatedAt(updatedAt);

        assertThat(dashboard.getId(), is(id));
        assertThat(dashboard.getTitle(), is(title));
        assertThat(dashboard.getCreatedAt(), is(createdAt));
        assertThat(dashboard.getUpdatedAt(), is(updatedAt));
    }
}
