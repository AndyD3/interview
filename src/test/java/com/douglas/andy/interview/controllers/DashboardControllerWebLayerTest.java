package com.douglas.andy.interview.controllers;

import com.douglas.andy.interview.entities.Dashboard;
import com.douglas.andy.interview.service.DashboardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DashboardController.class)
public class DashboardControllerWebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DashboardService dashboardService;

    @Test
    public void shouldReturnRecordAddedFromSQLScripts() throws Exception {

        final Dashboard expectedDashboard1 = new Dashboard();
        expectedDashboard1.setId(1);
        expectedDashboard1.setTitle("title_1");
        expectedDashboard1.setCreatedAt(Timestamp.valueOf("1984-01-18 01:01:01.0"));
        expectedDashboard1.setUpdatedAt(Timestamp.valueOf("2038-01-19 10:10:10.0"));

        final Dashboard expectedDashboard2 = new Dashboard();
        expectedDashboard2.setId(2);
        expectedDashboard2.setTitle("title_2");
        expectedDashboard2.setCreatedAt(Timestamp.valueOf("2000-02-18 02:02:02.0"));
        expectedDashboard2.setUpdatedAt(Timestamp.valueOf("2038-01-19 20:20:20.0"));

        final String expectedBody = "[{'id':1,'createdAt':'1984-01-18T01:01:01.000+00:00','updatedAt':'2038-01-19T10:10:10.000+00:00','title':'title_1'}," +
                "{'id':2,'createdAt':'2000-02-18T02:02:02.000+00:00','updatedAt':'2038-01-19T20:20:20.000+00:00','title':'title_2'}]";

        when(dashboardService.getDashboards()).thenReturn(new ArrayList<>(Arrays.asList(expectedDashboard1, expectedDashboard2)));

        this.mockMvc.perform(get("/dashboards")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(content().json(expectedBody));
    }
}