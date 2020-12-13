package edu.umb.cs680.hw15.apfs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw15.apfs.ApfsDirectory;
import edu.umb.cs680.hw15.fs.FSElement;

public class ApfsLink extends ApfsElement {
	private ApfsElement target;

	public ApfsLink(ApfsDirectory parent, String name, int size, String owner, LocalDateTime creationTime, LocalDateTime lastModified, ApfsElement target) {
		super(parent, name, size, owner, creationTime, lastModified);
		if(target == null) {
			throw new NullPointerException("File or Directory do not exist");
		}
		this.target = target;
	}
	
	@Override
	public boolean isDirectory() {
		return false;
	}

	public ApfsDirectory getParent() {
		return this.parent;
	}

	public String getName() {
		return this.name;
	}

	public int getTargetSize() {
		if (target.isDirectory()) {
			ApfsDirectory temp = (ApfsDirectory) target;
			return temp.getTotalSize();
		} else {
			return target.getSize();
		}
	}

	public String getCreationTime() {
		return this.creationTime.toString();
	}

	public int getSize() {
		return this.size;
	}
	public ApfsElement getTarget() {
		return this.target;
	}
	
}
