package edu.umb.cs680.hw15.fs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw15.apfs.ApfsDirectory;

public abstract class FSElement {

	public abstract boolean isDirectory();

	protected String name;
	protected int size;
	protected LocalDateTime creationTime;
	
	public FSElement(String name, int size, LocalDateTime creationTime) {
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}
	public FSElement() {}

	public int getSize() {
		return this.size;
	}

	public String getName() {
		return this.name;
	}

	public String getCreationTime() {
		return this.creationTime.toString();
	}
}
