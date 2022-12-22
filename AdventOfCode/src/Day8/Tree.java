package Day8;

public class Tree {
	private int height;
	private char visibility; 
	private int east;
	private int west;
	private int north;
	private int south;
	
	public Tree() {
		this.height = -1;
		this.visibility = 'u';
		this.east = -1;
		this.west = -1;
		this.north = -1;
		this.south = -1;
	}
	
	public Tree(int height, char visibility, int east) {
		this.height = height;
		this.visibility = visibility;
		this.east = east;
		this.west = -1;
		this.north = -1;
		this.south = -1;
	}
	public Tree(int height, char visibility, int east, int west) {
		this.height = height;
		this.visibility = visibility;
		this.east = east;
		this.west = west;
		this.north = -1;
		this.south = -1;
	}
	public Tree(int height, char visibility, int east, int west, int north, int south) {
		this.height = height;
		this.visibility = visibility;
		this.east = east;
		this.west = west;
		this.north = north;
		this.south = south;
	}
	public void setVisibilty(char c) {
		visibility = c;
	}
	public int getHeight() {
		return height;
	}
	public char getVisibility() {
		return visibility;
	}
	public int getNorth() {
		return north;
	}
	public void setNorth(int north) {
		this.north = north;
	}
	public int getEast() {
		return east;
	}
	public void setEast(int east) {
		this.east = east;
	}
	public int getWest() {
		return west;
	}
	public void setWest(int west) {
		this.west = west;
	}
	public int getSouth() {
		return south;
	}
	public void setSouth(int south) {
		this.south = south;
	}
}
