package com.omisoft.basic_java.objects.task2;
/**
 * Creating a point
 * 
 * @author bkoprinski
 *
 */
public class Point extends Figure {
	private double x;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	private double y;
	
	/**
	 * Initialize point
	 * @param x - X coordinate
	 * @param y - Y coordinate
	 */
	public Point(double x,double y)
	{
		this.setX(x);
		this.setY(y);
	}
	/**
	 * Gets X coordinate
	 * @return - x
	 */
	public double getX() {
		return x;
	}
	/**
	 * Sets X coordinate
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * Gets Y coordinate
	 * @return - y
	 */
	public double getY() {
		return y;
	}
	/**
	 * Sets Y coordinate
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * Prints Draw point text
	 */
	public void draw() {
		
		System.out.println("Draw point");
	}

	/**
	 * Resize
	 */
	public void resize() {
	
		System.out.println("Resize point");
	}
	/**
	 * Empty function
	 */
	public void findSurface()
	{
		
	}
}
