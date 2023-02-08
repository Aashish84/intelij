package com.example.dto_demo.service;

import com.example.dto_demo.dto.StudentDto;
import com.example.dto_demo.entity.Student;
import com.example.dto_demo.mapper.StudentMapper;
import com.example.dto_demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getStudents() {
        List<Student> allStudents = studentRepository.findAll();
        List<StudentDto> studentDtos = StudentMapper.STUDENT_INSTANCE.studentsToStudentDtos(allStudents);
        return studentDtos;
    }

    @Override
    public StudentDto addStudent(Student student) {
        Student newStudent = studentRepository.save(student);
        StudentDto newStudentDto = StudentMapper.STUDENT_INSTANCE.studentToStudentDto(newStudent);
        newStudentDto.setNow(LocalDateTime.now());
        return newStudentDto;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
//        convert dto to entity
        Student student = StudentMapper.STUDENT_INSTANCE.studentDtoToStudent(studentDto);

//        save entity
        Student savedStudent = studentRepository.save(student);

//        convert entity to dto and return saved student
        StudentDto studentDtoResult = StudentMapper.STUDENT_INSTANCE.studentToStudentDto(savedStudent);
        studentDtoResult.setNow(LocalDateTime.now());

        return studentDtoResult;
    }
}
