package com.torvaldsinc.linus_hostings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torvaldsinc.linus_hostings.model.ServicePlan;

@Repository
public interface ServicePlanRepository extends JpaRepository<ServicePlan, Long> {
}