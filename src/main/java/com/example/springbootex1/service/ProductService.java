package com.example.springbootex1.service;

import com.example.springbootex1.model.Product;
import com.example.springbootex1.model.Section;
import com.example.springbootex1.repository.ProductRepository;
import com.example.springbootex1.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create( final Product product) {
        productRepository.save(product);
    }

    public void createProduct( final Product product) {
        productRepository.save(product);
    }

    public Product get( final int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with id: " + id +" Not found"));
    }

    public void delete( final int id)  {
        productRepository.deleteById(id);
    }

    public void updatePrice( final int id, final double price) {

        final Product existingProduct = get(id);
        existingProduct.setPrice(price);
        productRepository.save(existingProduct);
    }

    public Product getProduct( int id) {


        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with id: " + id +" Not found"));
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
}