package com.ecommerce.techShop.business.service.services;

import com.ecommerce.techShop.business.dtos.ProductDto;
import com.ecommerce.techShop.business.service.serviceInterface.ProductService;
import com.ecommerce.techShop.common.service.BaseService;
import com.ecommerce.techShop.core.utilities.modelmappers.ModelMapperService;
import com.ecommerce.techShop.dataAccess.repositories.ProductRepository;
import com.ecommerce.techShop.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl extends BaseService<ProductRepository,Product, ProductDto>  implements ProductService {
    private final ModelMapperService modelMapperService;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ModelMapperService modelMapperService, ProductRepository productRepository) {
        super(productRepository,modelMapperService);
        this.modelMapperService = modelMapperService;
        this.productRepository = productRepository;
    }

    @Override
    public void add(ProductDto productDto) {
      Product product = this.modelMapperService.forRequest().map(productDto, Product.class);
        this.productRepository.save(product);
    }

    @Override
    public void update(ProductDto productDto) {

        Product product = this.modelMapperService.forRequest().map(productDto, Product.class);
        this.productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        this.productRepository.deleteById(id);

    }

    @Override
    public void deleteAll(List<ProductDto> productDtos) {
        List<Product> products = productDtos.stream()
                .map(cartDto -> this.modelMapperService.forRequest().map(productDtos, Product.class))
                .collect(Collectors.toList());
        productRepository.deleteAll(products);
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = this.productRepository.findAll();
        List<ProductDto> productDtos = products.stream().
                map(product -> this.modelMapperService.forResponse().map(product, ProductDto.class))
                .collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public ProductDto getById(int id) {
        Product product = this.productRepository.findById(id).orElseThrow();
        ProductDto productDto = this.modelMapperService.forResponse().map(product, ProductDto.class);

        return productDto;
    }


    @Override
    public List<ProductDto> findByCategory(String categoryName) {
        List<Product> products = this.productRepository.findByCategory(categoryName);

        List<ProductDto> productDtos = products.stream().
                map(product -> this.modelMapperService.forResponse().map(product, ProductDto.class))
                .collect(Collectors.toList());
        return productDtos;
    }

}
