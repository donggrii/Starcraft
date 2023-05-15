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
		Interface.super.interfaceDefaultMethod();
	}
	
	@Override
	public void interfaceDefaultMethod() {
		System.out.println("외부 클래스가 오버라이드한 인터페이스 디폴트 메서드 호출");
		System.out.println("Outer.interfaceDefaultMethod()");
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
			interfaceDefaultMethod();
			this.interfaceDefaultMethod();
			
			
			Outer.this.interfaceDefaultMethod();
			
			Interface.super.interfaceDefaultMethod();
		}
		
	}
}


public class InterfaceDefaultMethodTest_prof {

	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		
		inner.start();
	}

}
