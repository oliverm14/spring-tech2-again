package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by coag on 07-11-2017.
 */
@Controller
public class StudentController {

    @Autowired
    private StudentRepository studRepo;

    @Autowired
    private CourseRepository courseRepo;

    @PostMapping("/student/add")
    @ResponseBody
    public Student addStudent(
            @RequestParam(name = "name", defaultValue = "NO_NAME")
                    String name,
            @RequestParam(name = "email", defaultValue = "NO_EMAIL")
                    String email,
            @RequestParam(name = "courseName", defaultValue = "NO_COURSE")
                    String courseName) {

        Course c = courseRepo.findByCourseName(courseName);
        if (c == null) {
            c = new Course();
            c.setCourseName(courseName);
            courseRepo.save(c);
        }

        Student s = new Student();
        s.setName(name);
        s.setEmail(email);
        s.setCourse(c);
        studRepo.save(s);
        return s;
    }

    @GetMapping("/student")
    public String studentView() {
        return "student";
    }
}
