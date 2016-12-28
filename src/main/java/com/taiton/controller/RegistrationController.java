package com.taiton.controller;

import com.taiton.entity.EmployeeEntity;
import com.taiton.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Taiton on 12/27/2016.
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/employeeList.json")
    public List<EmployeeEntity> getTrainList() {
        return employeeService.findAll();
    }

    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody EmployeeEntity employee){
        employeeService.save(employee);
    }

    @PutMapping("/updateEmployee")
    public void updateEmployee(@RequestBody EmployeeEntity employee){
        employeeService.saveAndFlush(employee);
    }

    @DeleteMapping("/removeEmployee/{id}")
    public void removeEmployee(@PathVariable("id") int id){
        employeeService.delete(id);
    }

}
