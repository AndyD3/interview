package com.douglas.andy.interview.service;

import com.douglas.andy.interview.entities.Dashboard;
import com.douglas.andy.interview.respositories.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;

    public List<Dashboard> getDashboards() {
        return dashboardRepository.findAll();
    }
}