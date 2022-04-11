package com.example.springbootex1;

import com.example.springbootex1.controller.ProductController;
import com.example.springbootex1.model.Product;
import com.example.springbootex1.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class GetAllProductsTest {

    @Autowired
    MockMvc mockMvc;


    @Mock
     ProductRepository productRepository;

   Product test1 =  new Product("Laptop", 15);
   Product test2 =  new Product("Phone",20);


   @Test
    public void getAllProducts() throws Exception {
       List<Product> products = new ArrayList<>(Arrays.asList(test1,test2));

       Mockito.when(productRepository.findAll()).thenReturn(products);

       List<Product> expectedProducts = productRepository.findAll();

       Assert.assertEquals(products.size(), expectedProducts.size());

   }

}
