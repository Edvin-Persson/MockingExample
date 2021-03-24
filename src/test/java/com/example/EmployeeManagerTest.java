package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {


    @Test
    @DisplayName("Paid employee")
    void paidEmployee() {

        BankServiceTest bankService = new BankServiceTest();
        EmployeeRepositoryTest employeeRepository = new EmployeeRepositoryTest();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);


        var actual = employeeManager.payEmployees();

        assertEquals(1, actual);


    }


    @Test
    @DisplayName("Not paying employee")
    void notPayingEmployee() {

        Employee employee = Mockito.spy(new Employee("01", 2000));


        BankService bankService = mock(BankService.class);
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        when(employeeRepository.findAll()).thenReturn(List.of(employee));


        doThrow(new RuntimeException()).when(bankService).pay("01", 2000);

        assertEquals(0, employeeManager.payEmployees());
        assertFalse(employee.isPaid());


    }


}