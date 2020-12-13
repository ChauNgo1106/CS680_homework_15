package edu.umb.cs680.hw15.apfs;

import java.time.LocalDate;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Objects;

import edu.umb.cs680.hw15.apfs.ApfsDirectory;
import edu.umb.cs680.hw15.fs.FSElement;
import edu.umb.cs680.hw15.fs.FileSystem;

public class APFS extends FileSystem {
	private static APFS instance = null;

	// default constructor
	private APFS() {}

	// Singleton
	public static APFS getFileSystem() {
		try {
			return Objects.requireNonNull(instance);
		} catch (NullPointerException ex) {
			instance = new APFS();
			return instance;
		}
	}

	protected FSElement createDefaultRoot() {
		return new ApfsDirectory(null, "root", 0, "Chau Ngo",
				LocalDateTime.of(LocalDate.of(2019, 11, 15), LocalTime.of(20, 40, 59)),
				LocalDateTime.of(LocalDate.of(2019, 11, 15), LocalTime.of(20, 40, 59)));
	}
	public ApfsDirectory getRootDir() {
		//file system contains multiple roots onto different kinds of systems: APFS, FAT,.....
		return (ApfsDirectory)this.rootDirs.get(0);
	}
	public String getName() {
		return this.name;
	}
	public int getCapacity() {
		return this.capacity;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
