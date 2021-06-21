package com.douglas.andy.interview;

import com.douglas.andy.interview.entities.Dashboard;
import com.douglas.andy.interview.respositories.DashboardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBIntegrationTest {

    @Resource
    private DashboardRepository dashboardRepository;

    @Test
    public void shouldGetDashbardsWrittenFromDataDotSqlScript() {

        List<Dashboard> dashboards = dashboardRepository.findAll();

        assertEquals(dashboards.size(), 3);
        assertEquals(dashboards.get(0).getTitle(), "first title");
        assertEquals(dashboards.get(1).getTitle(), "second title");
        assertEquals(dashboards.get(2).getTitle(), "third title");
    }
}