package com.tm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tm.model.Response;

@Repository
public interface ResponseRepository extends MongoRepository<Response, String> {
}
