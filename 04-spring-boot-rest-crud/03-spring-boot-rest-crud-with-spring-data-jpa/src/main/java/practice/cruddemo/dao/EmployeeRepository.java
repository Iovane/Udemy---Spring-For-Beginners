package practice.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
