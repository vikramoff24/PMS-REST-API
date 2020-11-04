package com.vikram.springboot.PMSRESTAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikram.springboot.PMSRESTAPI.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{

}