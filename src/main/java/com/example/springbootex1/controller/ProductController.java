package com.example.springbootex1.controller;

import com.example.springbootex1.model.Product;
import com.example.springbootex1.repository.ProductRepository;
import com.example.springbootex1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(
        path = "/product"
)
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController( ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/createProduct")
    @Secured({"admin" , "manager"})
    public ResponseEntity<?> createProduct(@RequestParam("product") Product product) {
        productService.createProduct(product);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }


    @GetMapping("/getProduct")
    @Secured({"admin" , "manager"})
    public Product getProduct(@RequestParam("id") int id) {
        return productService.getProduct(id);
    }

    @PutMapping("/updatePrice")
    @Secured({"admin" , "manager"})
    public ResponseEntity<?> updatePrice(@RequestParam("id") int id, @RequestParam("price") double price) {
        productService.updatePrice(id, price);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @Secured({"admin" , "manager"})
    public ResponseEntity<?> delete(@RequestParam("productId") int productId) {
        productService.delete(productId);
        return ResponseEntity.ok(HttpStatus.OK);
    }



}

