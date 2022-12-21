package Day7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectoryEntry extends FileEntry{
	private final DirectoryEntry parent;
	private Map<String, FileEntry> files = new HashMap<>();
	
	public DirectoryEntry(DirectoryEntry parent, String name) {
		super(name, 0);
		this.parent = parent;
	}

	public Collection<FileEntry> getFiles(){
		return files.values(); 
	}
	public void addFile(FileEntry f) {
		files.put(f.getName(), f);
	}
	
	public long size() {
		long count = 0;
		for(FileEntry f : files.values()) {
			count += f.size();
		}
		return count;
	}

	public DirectoryEntry getParent() {
		return parent;
	}
	public DirectoryEntry getDir(String s) {
		return (DirectoryEntry) files.get(s);
	}
	public String getNameOfDir() {
		return this.getName();
	}
}
