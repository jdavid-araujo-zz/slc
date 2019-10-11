package com.david.slc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.david.slc.model.Slc;

@Repository
public interface SlCRepository extends JpaRepository<Slc, Long> {

}
