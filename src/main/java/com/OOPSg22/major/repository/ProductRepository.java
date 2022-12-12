package com.OOPSg22.major.repository;

import com.OOPSg22.major.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByCategory_Id(int id);
}
