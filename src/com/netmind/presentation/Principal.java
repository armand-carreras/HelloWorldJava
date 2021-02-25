package com.netmind.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.netmind.business.StudentBL;
import com.netmind.dao.StudentDao;
import com.netmind.dao.StudentFile;
import com.netmind.model.Student;

public class Principal {

	public enum Options {
		EXIT, ADD, OLDEST, AVERAGE;
	}

	@SuppressWarnings("deprecation")

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		StudentBL studentBL = new StudentBL();

		do {

			Date dateOfBirth = new Date();

			System.out.println("Welcome to Student Managment System.");
			System.out.println("Enter your 'N' select Option:");
			System.out.println("   1 - ADD new Student");
			System.out.println("   2 - Older Student");
			System.out.println("   3 - Average age");
			System.out.println("   0 - Exit");

			int option = Integer.parseInt(scanner.nextLine());

			switch (option) {
			case 1:
				int idStudent = dateOfBirth.hashCode();
				System.out.println("ADD new Student");
				System.out.println("Enter Student name: ");
				String name = scanner.nextLine();
				System.out.println(name);
				System.out.println("Enter Student surname: ");
				String surname = scanner.nextLine();
				System.out.println(surname);
				System.out.println("Enter Student Date of Birth: DD-MM-YYYY");
				String formatedDate = scanner.nextLine();
				try {
					dateOfBirth = new SimpleDateFormat("dd-MM-yyyy").parse(formatedDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(dateOfBirth.toLocaleString());

				Student newStudent = new Student(idStudent, name, surname, dateOfBirth);
				studentBL.add(newStudent);
				System.out.println(newStudent.toString());
				System.out.println(StudentDao.studentArrayList.toString());

				break;

			case 2:
				System.out.println("Oldest Student: ");
				System.out.println(studentBL.olderStudent(StudentDao.studentArrayList));

				break;
			case 3:
				System.out.println("Age average");
				System.out.println(studentBL.average(StudentDao.studentArrayList));

				break;
			case 4:
				System.out.println("Exiting...");

				exit = true;
				break;
			}

		} while (!exit);
		scanner.close();
		System.out.println("I'll proceed to add those students to Student.txt");
		System.out.println(StudentDao.studentArrayList.toString());
		StudentFile studentFile = new StudentFile();
		boolean response = studentFile.writeFile(StudentDao.studentArrayList);
		System.out.println(response);
		String file = studentFile.readFile();
		System.out.println(file);
	}

}
