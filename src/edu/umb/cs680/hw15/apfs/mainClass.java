package edu.umb.cs680.hw15.apfs;

import java.time.LocalDate;


import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeAll;


public class mainClass {

	public static void main(String[] args) {

		// initialize APFS file system
		APFS.getFileSystem().initFileSystemAPFS("APFS", 10240);

		// assign root in APFS system into root variable
		ApfsDirectory root = APFS.getFileSystem().getRootDir();

		ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, "Chau Ngo",
				LocalDateTime.of(LocalDate.of(2019, 9, 15), LocalTime.of(13, 00, 40)),
				LocalDateTime.of(LocalDate.of(2019, 9, 15), LocalTime.of(13, 00, 40)));

		ApfsDirectory home = new ApfsDirectory(root, "home", 0, "Chau Ngo",
				LocalDateTime.of(LocalDate.of(2019, 10, 15), LocalTime.of(20, 30, 00)),
				LocalDateTime.of(LocalDate.of(2019, 10, 15), LocalTime.of(20, 30, 00)));
		ApfsDirectory code = new ApfsDirectory(home, "code", 0, "Chau Ngo",
				LocalDateTime.of(LocalDate.of(2019, 11, 15), LocalTime.of(20, 31, 00)),
				LocalDateTime.of(LocalDate.of(2019, 11, 15), LocalTime.of(20, 31, 00)));

		ApfsFile a = new ApfsFile(applications, "a", 2048, "Chau Ngo",
				LocalDateTime.of(LocalDate.of(2019, 9, 15), LocalTime.of(13, 01, 00)),
				LocalDateTime.of(LocalDate.of(2019, 9, 15), LocalTime.of(13, 01, 00)));
		ApfsFile b = new ApfsFile(applications, "b", 1024, "Chau Ngo",
				LocalDateTime.of(LocalDate.of(2019, 9, 15), LocalTime.of(13, 10, 00)),
				LocalDateTime.of(LocalDate.of(2019, 9, 15), LocalTime.of(13, 10, 00)));

		ApfsFile c = new ApfsFile(home, "c", 2048, "Chau Ngo",
				LocalDateTime.of(LocalDate.of(2019, 10, 15), LocalTime.of(21, 32, 45)),
				LocalDateTime.of(LocalDate.of(2019, 10, 15), LocalTime.of(21, 32, 45)));
		ApfsFile d = new ApfsFile(home, "d", 4096, "Chau Ngo",
				LocalDateTime.of(LocalDate.of(2019, 9, 15), LocalTime.of(21, 45, 18)),
				LocalDateTime.of(LocalDate.of(2019, 9, 15), LocalTime.of(21, 45, 18)));

		ApfsFile e = new ApfsFile(code, "e", 1024, "Chau Ngo",
				LocalDateTime.of(LocalDate.of(2019, 11, 15), LocalTime.of(20, 40, 59)),
				LocalDateTime.of(LocalDate.of(2019, 11, 15), LocalTime.of(20, 40, 59)));
		ApfsFile f = new ApfsFile(code, "f", 2048, "Chau Ngo",
				LocalDateTime.of(LocalDate.of(2019, 11, 15), LocalTime.of(20, 45, 51)),
				LocalDateTime.of(LocalDate.of(2019, 11, 15), LocalTime.of(20, 45, 51)));
		// symbolic Link
		ApfsLink x = new ApfsLink(home, "x", 0, "Chau Ngo",
				LocalDateTime.of(LocalDate.of(2019, 11, 17), LocalTime.of(20, 46, 00)),
				LocalDateTime.of(LocalDate.of(2019, 11, 17), LocalTime.of(20, 46, 00)), applications);
		ApfsLink y = new ApfsLink(code, "y", 0, "Chau Ngo",
				LocalDateTime.of(LocalDate.of(2019, 9, 16), LocalTime.of(20, 39, 00)),
				LocalDateTime.of(LocalDate.of(2019, 9, 16), LocalTime.of(20, 39, 00)), b);

		applications.appendChild(a);
		applications.appendChild(b);

		root.appendChild(applications);
		root.appendChild(home);

		home.appendChild(code);
		home.appendChild(c);
		home.appendChild(d);
		home.appendChild(x);

		code.appendChild(e);
		code.appendChild(f);
		code.appendChild(y);

		applications.getChildren(
				(ApfsElement child1, ApfsElement child2) -> (child2.getName().compareTo(child1.getName())));
		
		for(ApfsElement ae: applications.getChildren() ) {
			System.out.println(ae.getName());
		}
		
		System.out.println();
		applications.getFiles((ApfsElement child1, ApfsElement child2) -> (child1
				.getLastModified().toString().compareTo(child2.getLastModified().toString())));
		for(ApfsElement ae: applications.getFiles() ) {
			System.out.println(ae.getName());
		}
		
		System.out.println();
		home.getChildren((ApfsElement child1, ApfsElement child2) -> (child1
				.getLastModified().toString().compareTo(child2.getLastModified().toString())));
		for(ApfsElement ae: home.getChildren() ) {
			System.out.println(ae.getName());
		}
	}

}
