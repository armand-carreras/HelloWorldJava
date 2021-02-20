package com.netmind.presentation;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import com.netmind.business.StudentBL;
import com.netmind.dao.StudentDao;
import com.netmind.model.Student;

public class Principal {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to Student Managment System.");
		System.out.println("Enter your 'N' select Option:");
		System.out.println("   1 - ADD new Student");
		System.out.println("   2 - Older Student");
		System.out.println("   3 - Average age");
		System.out.println("   4 - Exit");
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		Date dateOfBirth = new Date();
		StudentBL studentBL = new StudentBL();

		switch (option) {

		case 1:
			int idStudent = dateOfBirth.hashCode();
			System.out.println("Your desired option was 1 - ADD new Student");
			System.out.println("Enter Student name & surname separed by 1 space: ");
			String nameSurname = scanner.nextLine();
			System.out.println("Enter Student Age: ");
			int age = scanner.nextInt();
			System.out.println("Enter Student Year of Birth: YYYY");
			int year = scanner.nextInt();
			year -= 1900;
			dateOfBirth.setYear(year);
			System.out.println("Enter Student Month of Birth: MM");
			int month = scanner.nextInt();
			month--;
			dateOfBirth.setMonth(month);
			System.out.println("Enter Student Day of Birth: DD");
			int day = scanner.nextInt();
			dateOfBirth.setDate(day);
			String[] stInfo = nameSurname.split(" ");
			System.out.println(dateOfBirth.toLocaleString());
			Student newStudent = new Student(idStudent, stInfo[0], stInfo[1], age, dateOfBirth);
			StudentDao.addStudent(newStudent);
			System.out.println(Arrays.deepToString(StudentDao.studentArr));

			break;

		case 2:
			System.out.println("You've selected for the older Student: ");
			System.out.println(studentBL.olderStudent(StudentDao.studentArr));

			break;
		case 3:
			System.out.println("You've selected for the Age average");
			System.out.println(studentBL.average(StudentDao.studentArr));

			break;
		case 4:
			System.out.println("Exiting...");
			System.exit(0);
		}

		scanner.close();

	}

}
