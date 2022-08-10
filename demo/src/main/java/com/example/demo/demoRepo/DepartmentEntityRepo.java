package com.example.demo.demoRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.DemoEntity.DepartmentEntity;
import com.example.demo.request.DepartmentRequest;
@Repository
public interface DepartmentEntityRepo extends JpaRepository<DepartmentEntity, Integer> {

	

	

}
