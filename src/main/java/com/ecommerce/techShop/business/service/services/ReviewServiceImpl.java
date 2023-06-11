package com.ecommerce.techShop.business.service.services;

import com.ecommerce.techShop.business.dtos.ReviewDto;
import com.ecommerce.techShop.common.service.BaseService;
import com.ecommerce.techShop.core.utilities.modelmappers.ModelMapperService;
import com.ecommerce.techShop.dataAccess.repositories.ReviewRepository;
import com.ecommerce.techShop.model.Product;
import com.ecommerce.techShop.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl extends BaseService<ReviewRepository, Review, ReviewDto> {
    private final ModelMapperService modelMapperService;
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ModelMapperService modelMapperService, ReviewRepository reviewRepository) {
        super(reviewRepository,modelMapperService);
        this.modelMapperService = modelMapperService;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void add(ReviewDto reviewDto) {

        Review review = this.modelMapperService.forRequest().map(reviewDto, Review.class);
        this.reviewRepository.save(review);
    }

    @Override
    public void delete(int id) {

        this.reviewRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<ReviewDto> reviewDtos) {
        List<Review> reviews = reviewDtos.stream()
                .map(cartDto -> this.modelMapperService.forRequest().map(reviewDtos, Review.class))
                .collect(Collectors.toList());
        reviewRepository.deleteAll(reviews);
    }

    @Override
    public void update(ReviewDto reviewDto) {

        Review review = this.modelMapperService.forRequest().map(reviewDto, Review.class);
        this.reviewRepository.save(review);
    }

    @Override
    public List<ReviewDto> getAll() {
        List<Review> reviews = this.reviewRepository.findAll();
        List<ReviewDto> reviewDtos = reviews.stream()
                .map(review -> this.modelMapperService.forResponse().map(review,ReviewDto.class))
                .collect(Collectors.toList());
        return reviewDtos;
    }

    @Override
    public ReviewDto getById(int id) {
        Review review = this.reviewRepository.findById(id).orElseThrow();
        ReviewDto reviewDto = this.modelMapperService.forResponse().map(review, ReviewDto.class);
        return reviewDto;
    }
}
