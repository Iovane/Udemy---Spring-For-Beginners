package com.practice.curddemo.dao;

import com.practice.curddemo.entity.Course;
import com.practice.curddemo.entity.Instructor;
import com.practice.curddemo.entity.InstructorDetail;
import com.practice.curddemo.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor theinstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsById(int theId);

    Course findCourseAndStudentsById(int theId);

    Student findStudentAndCoursesByStudentId(int theId);

    void update(Student tempStudent);

    void deleteStudentById(int theId);

}
