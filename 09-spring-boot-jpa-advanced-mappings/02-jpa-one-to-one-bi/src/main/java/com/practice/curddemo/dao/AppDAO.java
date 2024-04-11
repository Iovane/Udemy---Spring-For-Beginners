package com.practice.curddemo.dao;

import com.practice.curddemo.entity.Instructor;
import com.practice.curddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theinstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
