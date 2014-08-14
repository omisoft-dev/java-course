package com.omisoft.basic_java.objects.task2;
/**
 * Creating an arc
 * @author bkoprinski
 *
 */
public class Arc extends Circle {
	private double start;
	private double sweep;
	
	public Arc(double x, double y, double height, double width, double start, double sweep) {
		super(x, y, height, width);
		this.start=start;
		this.sweep=sweep;
		// TODO Auto-generated constructor stub
	}

	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	public double getSweep() {
		return sweep;
	}

	public void setSweep(double sweep) {
		this.sweep = sweep;
	}
	
	public void draw() {
		
		System.out.println("Draw arc");
	}

	public void resize() {
	
		System.out.println("Resize arc");
	}

}
