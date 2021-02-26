package com.netmind.presentation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.netmind.business.StudentBL;
import com.netmind.dao.StudentDao;
import com.netmind.dao.StudentFile;
import com.netmind.model.OptionMenu;
import com.netmind.model.Student;

public class Principal {

	/*
	 * public enum Options { EXIT, ADD, OLDEST, AVERAGE, WRITE, PRINT;
	 * 
	 * }
	 */

	@SuppressWarnings("deprecation")

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		StudentBL studentBL = new StudentBL();
		StudentFile studentFile = new StudentFile();

		do {

			System.out.println("Welcome to Student Managment System.");
			System.out.println("Enter your 'N' select Option:");
			System.out.println("   1 - ADD new Student");
			System.out.println("   2 - Older Student");
			System.out.println("   3 - Average age");
			System.out.println("   4 - WriteFile");
			System.out.println("   5 - ReadFile");
			System.out.println("   6 - BufferedWrite");
			System.out.println("   0 - Exit");

			int option = Integer.parseInt(scanner.nextLine());
			OptionMenu options = OptionMenu.values()[option];

			switch (options) {
			case ADD:

				System.out.println("ADD new Student");
				System.out.println("Enter Student name: ");
				String name = scanner.nextLine();
				System.out.println(name);
				System.out.println("Enter Student surname: ");
				String surname = scanner.nextLine();
				System.out.println(surname);
				System.out.println("Enter Student Date of Birth: DD-MM-YYYY");
				Date formatedBirth = new Date();
				try {
					formatedBirth = new SimpleDateFormat("dd-MM-yyyy").parse(scanner.nextLine());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(formatedBirth.toLocaleString());

				Student newStudent = new Student(name, surname, formatedBirth);
				studentBL.add(newStudent);
				System.out.println(newStudent.toString());
				System.out.println(StudentDao.studentArrayList.toString());

				break;

			case OLDEST:
				System.out.println("Oldest Student: ");
				System.out.println(studentBL.olderStudent(StudentDao.studentArrayList));

				break;
			case AVERAGE:
				System.out.println("Age average");
				System.out.println(studentBL.average(StudentDao.studentArrayList));

				break;

			case WRITE:
				System.out.println("I'll proceed to add those students to Student.txt");
				System.out.println(StudentDao.studentArrayList.toString());
				boolean response = false;
				try {
					response = studentFile.writeFile(StudentDao.studentArrayList);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(response);

				break;

			case READ:
				System.out.println("Printing file");
				List<Student> file = studentFile.readFileToList();
				for (Student student : file) {
					System.out.println(student.toString());
				}
				break;
			case BufferedWrite:
				System.out.println("Write with Buffer");
				try {
					boolean resp = studentFile.write(StudentDao.studentArrayList);
					System.out.println(resp);
				} catch (IOException e) {
					e.printStackTrace();
				}
			case EXIT:
				System.out.println("Exiting...");

				exit = true;
				break;
			}

		} while (!exit);
		scanner.close();

	}

}
