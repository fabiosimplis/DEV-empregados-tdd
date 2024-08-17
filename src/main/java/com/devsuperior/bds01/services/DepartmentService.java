package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    public DepartmentRepository repository;

    @Transactional(readOnly = true)
    public List<DepartmentDTO> findAll(){

        var departments = repository.findAll(Sort.by("name"));

        List<DepartmentDTO> dtoList = new ArrayList<>();

        for (Department department : departments){
            var dto = new DepartmentDTO(department);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
