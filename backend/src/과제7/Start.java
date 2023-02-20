package 과제7;

public class Start {
	public static void main(String[] args) {
	      	Dog dog = new Dog();
	        Cat cat = new Cat();
	        
	        dog.move();
	        dog.bark();
	        dog.eat();
	        
	        cat.move();
	        cat.move(100);
	        cat.bark();		
	        cat.eat();
	}
}
