package 연습장3;

public class Member {

String model;
String color;
int maxSpeed;


public Member() {}


public Member(String model) {
	this.model = model;
}


public Member(String model, String color) {
	this.model = model;
	this.color = color;
}


public Member(String model, String color, int maxSpeed) {
	this.model = model;
	this.color = color;
	this.maxSpeed = maxSpeed;
}

@Override
public String toString() {
	return "Car [model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
}


}//class e
