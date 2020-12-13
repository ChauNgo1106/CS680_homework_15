package edu.umb.cs680.hw15.fs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import edu.umb.cs680.hw15.apfs.ApfsDirectory;


/*Metadata
• File type (kind)
• Physical file location in a disk
• Logical file location (i.e., file path)
• File owner
• last-modified time (the time that the file was last modified), last-backed-up time, last-opened time
• Access permission (who can see/read/edit a file)
 */
public abstract class FileSystem {

	protected String name;
	protected int capacity;
	protected int id;
	
	//the type of generic will be determined in FAT and APFS
	protected ArrayList<FSElement> rootDirs = new ArrayList<>();

	//initialize for APFS system
	public FSElement initFileSystemAPFS(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		FSElement root = createDefaultRoot();

		if (root.isDirectory() && capacity >= (((ApfsDirectory) root).getSize())) {
			setRoot(root);
			this.id = root.hashCode();
			return root;
		} else {
			return null;// we can throw an exception in here.
		}
	}

	protected void setRoot(FSElement root) {
		this.rootDirs.add(root);
	}
	
	//Those abstract methods will be implemented in FAT and APFS respectively
	abstract public String getName();

	abstract public int getCapacity();

	abstract public int getId();

	abstract protected FSElement createDefaultRoot();

}
