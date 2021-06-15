package com.douglas.andy.interview.service;

import com.douglas.andy.interview.entities.Dashboard;
import com.douglas.andy.interview.respositories.DashboardRepository;
import org.jeasy.random.EasyRandom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DashboardServiceUnitTest {

    @Mock
    private DashboardRepository dashboardRepository;

    @InjectMocks
    private DashboardService dashboardService;

    @Test
    public void shouldReturnAllDashboardsFromRepository() {
        final EasyRandom generator = new EasyRandom();
        final Dashboard dashboard1 = generator.nextObject(Dashboard.class);
        final Dashboard dashboard2 = generator.nextObject(Dashboard.class);
        final Dashboard dashboard3 = generator.nextObject(Dashboard.class);

        when(dashboardRepository.findAll()).thenReturn(Arrays.asList(dashboard2, dashboard1, dashboard3));

        assertThat(dashboardService.getDashboards(), containsInAnyOrder(dashboard1, dashboard2, dashboard3));
        verify(dashboardRepository).findAll();
        verifyNoMoreInteractions(dashboardRepository);
    }
}
