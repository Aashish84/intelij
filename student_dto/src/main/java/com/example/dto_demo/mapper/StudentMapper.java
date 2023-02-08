package com.example.dto_demo.mapper;

import com.example.dto_demo.dto.StudentDto;
import com.example.dto_demo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    StudentMapper STUDENT_INSTANCE = Mappers.getMapper(StudentMapper.class);
    @Mapping(source = "description" , target = "comment")
    @Mapping(target="password" , ignore = true)
    StudentDto studentToStudentDto (Student student);
    List<StudentDto> studentsToStudentDtos (List<Student> students);

    @Mapping(source = "comment" , target = "description")
    Student studentDtoToStudent (StudentDto studentDto);
}
