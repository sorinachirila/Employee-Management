package com.sda.service;

import com.sda.dao.EmployeeDao;
import com.sda.model.Employee;

public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();

    public Employee findById(Long id){
        return employeeDao.getEntityById(Employee.class, id);
    }
}
