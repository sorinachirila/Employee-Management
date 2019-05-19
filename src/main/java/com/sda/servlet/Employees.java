package com.sda.servlet;

import com.sda.dao.EmployeeDao;
import com.sda.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/employees")
public class Employees extends HttpServlet {

    private EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response)
            throws ServletException, IOException {
        Employee employee = employeeDao.getEntityById(Employee.class, 1L);
        response.getWriter().println("Hello World!");
    }
}
