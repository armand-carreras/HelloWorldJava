package com.netmind.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

	Property PATH = new Property();
	Path path = Paths.get(PATH.getPath());

	public boolean writeFile(List<Student> studentArray) {

		boolean done = false;
		StringBuilder builder = new StringBuilder();

		builder.append(readFileToString());
		builder.append("\n");

		for (Student student : studentArray) {
			builder.append(student.toFileFormat());
		}

		String str = builder.toString();
		byte[] strToBytes = str.getBytes();

		try {
			Files.write(path, strToBytes);
			done = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		List<Student> studentList = new ArrayList<Student>();
		for (String str : list) {
			String[] arr = str.split(",");
			DateFormat format = new SimpleDateFormat("EE MMM dd HH:mm:ss zzzz yyyy");
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
