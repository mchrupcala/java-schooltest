package com.lambdaschool.school.service;

import com.lambdaschool.school.SchoolApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

@RunWith(SpringRunner.class)
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
    public void findAll() {
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
    public void save() {
    }

    @Test
    public void findCourseById() {
        assertEquals("Node.js", courseService.findCourseById(3).getCoursename());
    }
}
