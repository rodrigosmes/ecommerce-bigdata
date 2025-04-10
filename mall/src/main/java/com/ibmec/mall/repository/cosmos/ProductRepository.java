package com.ibmec.mall.repository.cosmos;

import com.ibmec.mall.model.Product;
import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;


@Repository
public interface ProductRepository extends CosmosRepository<Product, String> {

}