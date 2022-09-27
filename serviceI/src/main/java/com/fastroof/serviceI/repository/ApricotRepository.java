package com.fastroof.serviceI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fastroof.serviceI.entity.Apricot;

@Repository
public interface ApricotRepository extends CrudRepository<Apricot, Long> {
}
