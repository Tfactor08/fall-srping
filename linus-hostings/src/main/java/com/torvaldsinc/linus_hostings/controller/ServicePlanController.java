package com.torvaldsinc.linus_hostings.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.torvaldsinc.linus_hostings.model.*;
import com.torvaldsinc.linus_hostings.service.ServicePlanService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/servicePlans")
public class ServicePlanController {
    private ServicePlanService servicePlanService;

    public ServicePlanController(ServicePlanService servicePlanService) {
        this.servicePlanService = servicePlanService;
    }

    @GetMapping
    public List<ServicePlan> getServicePlans() {
        return servicePlanService.getAll();
    }

    @PostMapping
    public ResponseEntity<ServicePlan> createServicePlan(@RequestBody @Valid ServicePlan servicePlan) {
        ServicePlan savedServicePlan = servicePlanService.create(servicePlan);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedServicePlan);
    }
}
