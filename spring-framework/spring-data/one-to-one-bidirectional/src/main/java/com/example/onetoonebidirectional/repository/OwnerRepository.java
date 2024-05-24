package com.example.onetoonebidirectional.repository;

import com.example.onetoonebidirectional.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
