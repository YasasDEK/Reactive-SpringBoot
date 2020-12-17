package com.hsenid.reactive.reactivemongodb.repository;

import com.hsenid.reactive.reactivemongodb.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String>  {

}
