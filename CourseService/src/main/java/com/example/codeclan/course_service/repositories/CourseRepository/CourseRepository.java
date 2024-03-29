package com.example.codeclan.course_service.repositories.CourseRepository;

import com.example.codeclan.course_service.models.Course;
import com.example.codeclan.course_service.models.Customer;
import com.example.codeclan.course_service.projections.EmbedCourseBookings;
import com.example.codeclan.course_service.projections.EmbedCustomerCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(excerptProjection = EmbedCourseBookings.class)
public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {
    List<Course> getCoursesForStarRating(int rating);

    List<Customer> getAllCustomersForCourse(Long id);

    List<Customer> getAllCustomersForCourseInTown(Long id, String town);

    List<Customer> getAllCustomersForCourseInTownOverAge(Long courseId, String town, int age);
}
