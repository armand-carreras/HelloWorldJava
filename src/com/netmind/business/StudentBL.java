package com.netmind.business;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.netmind.dao.StudentDao;
import com.netmind.model.Student;

public class StudentBL {

	public boolean add(Student student) {
		Date date = new Date();
		int idStudent = date.hashCode();
		student.setIdStudent(idStudent);
		student.setAge(calculateAge(student.getDateOfBirth()));

		return StudentDao.add(student);
	}

	private int calculateAge(Date dateOfBirth) {
		Period edad = Period.between(dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				LocalDate.now());
		return edad.getYears();
	}

	public Student olderStudent(List<Student> studentArray) {
		Student result = new Student();
		result.setDateOfBirth(null);
		for (Student stdnt : studentArray) {
			if (stdnt.getDateOfBirth().getTime() > result.getDateOfBirth().getTime()) {

			}
		}
		return result;
	}

	public int average(List<Student> studentArray) {
		int result = 0;
		for (Student std : studentArray) {
			result += std.getAge();
		}
		return result / studentArray.size();

	}

}
