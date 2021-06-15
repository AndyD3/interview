package com.douglas.andy.interview.controllers;

import com.douglas.andy.interview.entities.Dashboard;
import com.douglas.andy.interview.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping(value = "/dashboards", produces = "application/json")
    public List<Dashboard> getDashboards() throws IOException {
        return dashboardService.getDashboards();
    }
}