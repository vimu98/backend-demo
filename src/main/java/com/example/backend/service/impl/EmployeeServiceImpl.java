package com.example.backend.service.impl;

import com.example.backend.dto.EmployeeDTO;
import com.example.backend.entity.Employee;
import com.example.backend.repo.EmployeeRepo;
import com.example.backend.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo repo;
    @Autowired
    private ModelMapper mapper;

    public void save(EmployeeDTO dto) {
        log.info("save EmployeeDTO");
        repo.save(mapper.map(dto, Employee.class));
    }

    public List<EmployeeDTO> getAll() {

        return repo.findAll().stream()
                .map(e -> mapper.map(e, EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}
