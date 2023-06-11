package com.ecommerce.techShop.controller;

import com.ecommerce.techShop.business.dtos.ReviewDto;
import com.ecommerce.techShop.business.service.services.ReviewServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewServiceImpl reviewServiceImpl;

    @Autowired
    public ReviewController(ReviewServiceImpl reviewServiceImpl) {
        this.reviewServiceImpl = reviewServiceImpl;
    }
    @GetMapping("/{id}")
    public List<ReviewDto> getById(@PathVariable int id){
        return getById(id);
    }

    @GetMapping
    public List<ReviewDto> getAll(){
        return reviewServiceImpl.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid ReviewDto reviewDto){
        this.reviewServiceImpl.add(reviewDto);
    }


    @PutMapping
    public void update(@RequestBody ReviewDto reviewDto){
        this.reviewServiceImpl.update(reviewDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.reviewServiceImpl.delete(id);
    }
}
