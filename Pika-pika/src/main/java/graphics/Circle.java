package graphics;
public class Circle {
	private double radius;
	public Circle(double radius) {
		this.radius = radius;
	}
	public double area(){
		return 3.14*this.radius*this.radius;
	}
}
