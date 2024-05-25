package com.sabirov.springeshop.service;

import com.sabirov.springeshop.domain.Bucket;
import com.sabirov.springeshop.domain.User;
import com.sabirov.springeshop.dto.BucketDTO;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);
    void addProducts(Bucket bucket, List<Long> productIds);
    BucketDTO getBucketByUser(String name);
}
