package com.netmind.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		builder.append(readFile());
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

	public String readFile() {
		String data = "";
		// StringBuilder builder = new StringBuilder();
		// String read = "";
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
	// assertEquals(str, read);

}
