package com.torvaldsinc.linushostings.model;

import java.util.*;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    private Integer cpuCores;

    private Integer ramMB;

    private Integer storageGB;

    private Integer bandwidthGB;

    @Column(nullable = false)
    private Double pricePerMonth;

    private Boolean isAvailable;

    @OneToMany(mappedBy = "servicePlan", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "servicePlan", cascade = CascadeType.ALL)
    private List<Server> servers = new ArrayList<>();
}
