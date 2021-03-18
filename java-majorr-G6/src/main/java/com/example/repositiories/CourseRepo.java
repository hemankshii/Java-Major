package com.example.repositiories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{
	
	@Query(value = "SELECT c.course_id,c.course_desc,c.course_logo,c.course_name,c.course_price,c.likes,c.category_id FROM course c , enrolled_courses ec where c.course_id=ec.course_id and ec.user_id=?1", nativeQuery = true)
	List<Course> getEnrolledCourses(int uid);
	public Course findByCourseName(String name);
	

}
