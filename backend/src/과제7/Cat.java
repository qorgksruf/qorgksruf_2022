package 과제7;

public class Cat implements Animal{
    @Override
    public void move(int a) {
        System.out.println(a + "사뿐사뿐~~");
    }
    
    @Override
    public void bark() {
        System.out.println("야옹~~");
    }

	@Override
	public void eat() {
		System.out.println("츄릅");
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}
