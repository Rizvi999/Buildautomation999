package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

@Mock
private StudentRepository studentRepository;

@InjectMocks
private StudentService studentService;

private AutoCloseable mocks;

@BeforeEach
void setUp() {

mocks = MockitoAnnotations.openMocks(this);

System.out.println("Before each test");
}

@AfterEach
void tearDown() throws Exception {

mocks.close();

System.out.println("After each test");
}

@Test
void testGetStudentById() {

// Arrange
Student student =
new Student(1L, "John", "Java");

when(studentRepository.findById(1L))
.thenReturn(Optional.of(student));

// Act
Student result =
studentService.getStudentById(1L);

// Assert
assertNotNull(result);

assertEquals(1L, result.getId());

assertEquals("John", result.getName());

assertEquals("Java", result.getCourse());

// Verify repository interaction
verify(studentRepository)
.findById(1L);
}
}