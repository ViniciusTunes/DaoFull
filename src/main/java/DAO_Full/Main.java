package DAO_Full;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            List<Employee> employees;
            EmployeeDAO employeeDAO = new EmployeeDAOImp();

            employees = employeeDAO.getAll();

            for (Employee employee : employees) {
                System.out.println(employee);
            }

        }  catch (SQLException e) {
            throw new Error("Algo deu errado ao tentar: " + e);
        }
    }
}