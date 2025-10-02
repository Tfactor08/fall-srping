package com.torvaldsinc.linus_hostings.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.torvaldsinc.linus_hostings.model.Product;
import com.torvaldsinc.linus_hostings.repository.ProductRepository;
import com.torvaldsinc.linus_hostings.specification.ProductSpecification;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ProductService {
    ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    //@Cachable(value="products", key="#root.methodName")
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    //@CacheEvict(value="products", allEntries=true)
    @Transactional
    public Product create(Product product) {
        return productRepo.save(product);
    }

    //@Cachable(value="product", key="#id")
    public Product getById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Transactional
    public Product update(Long id, Product updated) {
        return productRepo.findById(id).map(p -> {
            p.setName(updated.getName());
            p.setCost(updated.getCost());
            return productRepo.save(p);
        }).orElse(null);
    }

    @Transactional
    public boolean delete(Long id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return true;
        }

        return false;
    }

    public Page<Product> getByFilter(String name, Integer min, Integer max, Pageable pageable) {
        return productRepo.findAll(ProductSpecification.filter(name, min, max), pageable);
    }
}
