package com.torvaldsinc.linus_hostings.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.torvaldsinc.linus_hostings.model.ServicePlan;
import com.torvaldsinc.linus_hostings.repository.ServicePlanRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ServicePlanService {
    ServicePlanRepository servicePlanRepo;

    public ServicePlanService(ServicePlanRepository servicePlanRepo) {
        this.servicePlanRepo = servicePlanRepo;
    }

    public List<ServicePlan> getAll() {
        return servicePlanRepo.findAll();
    }

    @Transactional
    public ServicePlan create(ServicePlan servicePlan) {
        return servicePlanRepo.save(servicePlan);
    }
}
