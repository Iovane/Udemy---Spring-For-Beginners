package practice.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
