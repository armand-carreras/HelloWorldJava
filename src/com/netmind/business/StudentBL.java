package com.netmind.business;

import java.util.Date;

import com.netmind.model.Student;

public class StudentBL {

	private Student student = new Student();

	public void setStudent(String name, String surname, Integer age, Date dateOfBirth) {

		Date date = new Date();
		Integer idStudent = date.hashCode();
		student.setIdStudent(idStudent);
		student.setName(name);
		student.setSurname(surname);
		student.setAge(age);
		student.setDateOfBirth(date);

	}

	public Student olderStudent(Student[] studentArray) {
		Student result = new Student();
		result.setDateOfBirth(null);
		for (Student stdnt : studentArray) {
			if (stdnt.getDateOfBirth().getTime() > result.getDateOfBirth().getTime()) {

			}
		}
		return result;
	}

	public int average(Student[] studentArray) {
		int result = 0;
		for (Student std : studentArray) {
			result += std.getAge();
		}
		return result / studentArray.length;

	}

}
