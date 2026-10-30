package LevelTwo.EmployeeManagement;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    private final List<Employee> employees = new ArrayList<>();

    public boolean addEmployee(Employee employee) {
        if (findById(employee.getId()) != null) {
            return false;
        }
        employees.add(employee);
        return true;
    }

    public Employee findById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public boolean updateEmployee(int id, String newName, String newDepartment, double newSalary) {
        Employee employee = findById(id);
        if (employee == null) {
            return false;
        }
        employee.setName(newName);
        employee.setDepartment(newDepartment);
        employee.setSalary(newSalary);
        return true;
    }

    public boolean deleteEmployee(int id) {
        Employee employee = findById(id);
        if (employee == null) {
            return false;
        }
        employees.remove(employee);
        return true;
    }
}