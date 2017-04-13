package com.tm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tm.model.Request;

@Repository
public interface RequestRepository extends MongoRepository<Request, String> {
}
