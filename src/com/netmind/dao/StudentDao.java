package com.netmind.dao;

import java.util.Arrays;

import com.netmind.model.Student;

public class StudentDao {

	public static Student[] studentArr;

	public static void addStudent(Student student) {

		studentArr = Arrays.copyOf(studentArr, studentArr.length + 1);
		studentArr[studentArr.length - 1] = student;

	}
}
