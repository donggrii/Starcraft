package ch10.sc.unit;

public class Marine extends Unit {

	static int atk;
	static int def;
	static String weapon;
	static String type;
	
	static {
		atk = 6;
		def = 0;
		weapon = "가우스 소총";
		type = "마린";
	}
	
	public Marine() {
		this(1);
	}

	public Marine(int num) {
		this(num, 40);
	}

	Marine(int num, int hp) {
		super(num, hp);
	}
	
	@Override
	public void reportStatus() {
		System.out.println(type + "#" + num + ":");
		System.out.println(String.format("  - 생명력: %d, 공격력: %d, 방어력: %d", 
				this.hp, atk, def));
		System.out.println("  - 무기 이름: " + weapon + "\n");
	}
	
	public void attack(Zergling z, int count) {
//		z.hp += (z.def - this.atk) * count;  // 직접 값에 접근하지 말고, 객체지향으로 data encapsulation을 적용 : 함수로 간접적으로 데이터 변경해야 함!
//		z.setHp(z.getHp() + count * (z.getDef() - this.atk));
		z.getAttacked(atk, count);
	}
	
}
