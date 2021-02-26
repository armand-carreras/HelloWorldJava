package com.netmind.dao;

import java.util.ArrayList;
import java.util.List;

import com.netmind.model.Student;

public class StudentDao {

	public static List<Student> studentArrayList = new ArrayList<Student>();

	public static List<Student> getStudentArrayList() {
		return studentArrayList;
	}

	public static void setStudentArrayList(List<Student> studentArrayList) {
		StudentDao.studentArrayList = studentArrayList;
	}

	public static boolean add(Student student) {

		return studentArrayList.add(student);

	}

	public static List<Student> get() {
		return studentArrayList;
	}
}
