package Day7;

public class FileEntry {
	private final long size;
	private final String name;
	
	public FileEntry(String name, long size) {
		this.size = size;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public long size() {
		return size;
	}
	
}
