package com.netmind.dao;

import java.util.ArrayList;

import com.netmind.model.Student;

public class StudentDao {

	public static ArrayList<Student> studentArrayList = new ArrayList<Student>();

	public static ArrayList<Student> getStudentArrayList() {
		return studentArrayList;
	}

	public static void setStudentArrayList(ArrayList<Student> studentArrayList) {
		StudentDao.studentArrayList = studentArrayList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentDao [getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	public static boolean add(Student student) {

		return studentArrayList.add(student);

	}

	public static ArrayList<Student> get() {
		return studentArrayList;
	}
}
