package com.practice.curddemo.dao;

import com.practice.curddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theinstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
