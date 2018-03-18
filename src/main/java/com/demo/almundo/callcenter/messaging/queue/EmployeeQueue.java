package com.demo.almundo.callcenter.messaging.queue;

import com.demo.almundo.callcenter.models.Employee;

import java.util.Optional;

/**
 *
 */
public class EmployeeQueue{


    public boolean add(Employee call) {
        return false;
    }


    public Optional<Employee> poll() {
        return null;
    }
}
