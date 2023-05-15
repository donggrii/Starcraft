// 외부 클래스(내부 클래스를 포함하는 클래스)가 구현한 인터페이스의 디폴트 메서드와
// 인터페이스의 디폴트 인터페이스를 오버라이드한 상위 클래스의 메서드와
// 인터페이스의 디폴트 메서드와 이름이 같은 내부 클래스에 접근하는 예
package exercise;

interface Interface {
	void interfaceMethod();
	
	
	default void interfaceDefaultMethod() {
		System.out.println("인터페이스의 디폴트 메서드 호출");
		System.out.println("Interface.interfaceDefaultMethod()");
	}
}

class Outer implements Interface {
	@Override
	public void interfaceMethod() {
		System.out.println("외부 클래스가 구현한 인터페이스 메서드 호출");
		System.out.println("Outer.interfaceMethod()");
		Interface.super.interfaceDefaultMethod();  // 인터페이스의 디폴트 메서드
	}
	
	public void interfaceDefaultMethod() {
		System.out.println("외부 클래스가 오버라이드한 인터페이스 디폴트 메서드 호출");
		System.out.println("Outer.interfaceDefaultMethod()");
	}
	
	Inner2 inner2;
	
	void setInner2(Inner2 inner2) {
		this.inner2 = inner2;
	}
	
	class Inner implements Interface {
		@Override
		public void interfaceMethod() {
			
		}
		
		@Override
		public void interfaceDefaultMethod() {
			System.out.println("외부 클래스 또는 외부 클래스가 구현한 인터페이스의 메서드와 같은 이름의 내부 클래스의 메서드 호출");
			System.out.println("Outer.Inner.interfaceDefaultMethod()");
		}
		
		public void start() {
			interfaceDefaultMethod();  // Inner 클래스의 메서드
			this.interfaceDefaultMethod();  // Inner 클래스의 메서드

			Outer.this.interfaceDefaultMethod();  // Outer 클래스의 메서드
		
			Interface.super.interfaceDefaultMethod();  // Interface의 디폴트 메서드
		}
		
	}
	
}

class Inner2 {
	
}

class Inner3 extends Inner2 {
	
}

public class InterfaceDefaultMethodTest {

	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		
		inner.start();
		
		int sum = 0;
		for (int i = 0; i < 100; i++ ) {
			sum += i;
			
			if (i > 80) {
				break;
			}
		}
		
		System.out.println("sum = " + sum);
		
	}

}
