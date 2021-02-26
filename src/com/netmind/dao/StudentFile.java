package com.netmind.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.netmind.model.Property;
import com.netmind.model.Student;

public class StudentFile {

	Property PROP = new Property();
	Path path = Paths.get(PROP.getPath());
	String fileName = PROP.getPath();

	public boolean write(List<Student> studentArray) throws IOException {

		boolean done = false;

		try (FileWriter fileWriter = new FileWriter(fileName, true);
				BufferedWriter bufferWriter = new BufferedWriter(fileWriter)) {
			for (Student student : studentArray) {
				bufferWriter.write(student.toFileFormat());
				bufferWriter.write(System.lineSeparator());
			}
			done = true;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		return done;
	}

	public boolean writeFile(List<Student> studentArray) throws IOException {

		boolean done = false;
		StringBuilder builder = new StringBuilder();

		for (Student student : studentArray) {
			builder.append(student.toFileFormat());
		}
		String str = builder.toString();
		byte[] strToBytes = str.getBytes();
		try {
			Files.write(path, strToBytes, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			done = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return done;
	}

	public String readFileToString() {
		String data = "";

		try {
			Stream<String> lines = Files.lines(path);
			data = lines.collect(Collectors.joining("\n"));
			lines.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public List<Student> readFileToList() {
		System.out.println("readFile");
		List<Student> studentList = new ArrayList<Student>();
		List<String> lines = new ArrayList<String>();

		try {
			lines = Files.readAllLines(path);
			studentList = stringToStudent(lines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	private List<Student> stringToStudent(List<String> list) {
		System.out.println("StringToStudent");
		List<Student> studentList = new ArrayList<Student>();
		for (String str : list) {
			String[] arr = str.split(",");

			DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			try {
				date = format.parse(arr[4]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Student student = new Student(Integer.parseInt(arr[0]), arr[1], arr[2], Integer.parseInt(arr[3]), date);
			studentList.add(student);
		}
		return studentList;

	}

}
