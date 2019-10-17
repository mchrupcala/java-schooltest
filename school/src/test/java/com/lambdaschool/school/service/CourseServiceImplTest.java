package com.lambdaschool.school.service;

import com.lambdaschool.school.SchoolApplication;
import com.lambdaschool.school.model.Course;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = SchoolApplication.class)
public class CourseServiceImplTest {

    @Autowired
    private CourseService courseService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void A_findAll() {
        assertEquals(12, courseService.findAll().size());
    }

    @Test
    public void getCountStudentsInCourse() {
    }

    @Test
    public void deleteFound() {
        courseService.delete(6);
        assertEquals(11, courseService.findAll().size());
    }

    @Test
    (expected = EntityNotFoundException.class)
    public void deleteNotFound() {
        courseService.delete(100);
        assertEquals(12, courseService.findAll().size());
    }

    @Test
    public void Tsave() {
        String course30Name = "Burrito Making";
        Course c30 = new Course(course30Name);

        Course addedCourse = courseService.save(c30);

        assertNotNull(addedCourse);

        Course foundCourse = courseService.findCourseById(addedCourse.getCourseid());
        assertEquals(addedCourse.getCoursename(), foundCourse.getCoursename());
    }

    @Test
    public void findCourseById() {
        assertEquals("Node.js", courseService.findCourseById(3).getCoursename());
    }
}
