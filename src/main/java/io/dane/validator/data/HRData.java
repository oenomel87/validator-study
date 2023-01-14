package io.dane.validator.data;

import io.dane.validator.domain.Department;
import io.dane.validator.domain.Employee;
import io.dane.validator.domain.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class HRData {

    private static HRData data;

    private List<Department> departments;

    private List<Employee> employees;

    private List<Position> positions;

    private HRData() {
        this.departments = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.positions = new ArrayList<>();
    }

    public static HRData getInstance() {
        if(data == null) {
            data = new HRData();
        }
        return data;
    }

    public List<Department> findAllDepartments() {
        return this.departments;
    }

    public List<Employee> findAllEmployees() {
        return this.employees;
    }

    public List<Position> findAllPositions() {
        return this.positions;
    }

    public void save(Department department) {
        if(this.departments.stream().noneMatch(d -> d.getCode().equals(department.getCode()))) {
            this.departments.add(department);
            return;
        }

        var index = this.departments.indexOf(department);
        this.departments.set(index, department);
    }

    public void save(Employee employee) {
        if(this.employees.stream().noneMatch(e -> e.getCode().equals(employee.getCode()))) {
            this.employees.add(employee);
            return;
        }

        var index = this.employees.indexOf(employee);
        this.employees.set(index, employee);
    }

    public void save(Position position) {
        if(!this.positions.contains(position)) {
            this.positions.add(position);
            return;
        }

        var index = this.positions.indexOf(position);
        this.positions.set(index, position);
    }

    public Optional<Department> findDepartmentByCode(String code) {
        return this.departments.stream().filter(d -> d.getCode().equals(code)).findFirst();
    }

    public Optional<Employee> findEmployeeByCode(String code) {
        return this.employees.stream().filter(d -> d.getCode().equals(code)).findFirst();
    }
}
