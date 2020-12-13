package edu.umb.cs680.hw15.apfs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw15.apfs.ApfsDirectory;
import edu.umb.cs680.hw15.fs.FSElement;

public abstract class ApfsElement extends FSElement {

	protected ApfsDirectory parent;
	protected String owner;
	protected LocalDateTime lastModified;

	public ApfsElement() {}
	public ApfsElement(ApfsDirectory parent, String name, int size, String owner,
			LocalDateTime creationTime, LocalDateTime lastModified) {
	
		super(name, size, creationTime);
		if(this.name.length() < 0 || name.length() > 255) {
			throw new IllegalArgumentException("File name is allowed up to 255 characters");
		}
		this.parent = parent;
		this.owner = owner;
		this.lastModified = lastModified;
	}

	public ApfsDirectory getParent() {
		return this.parent;
	}

	public String getParentToString() {
		return this.parent.getName();
	}

	public void setParent(ApfsDirectory parent) {
		this.parent = parent;
	}
	public String getOwner() {
		return owner;
	}

	public String getLastModified() {
		return this.lastModified.toString();
	}
	
	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

}
