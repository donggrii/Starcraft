package ch10.sc.unit;

public class Zealot extends Unit {

	static int atk;
	static int def;
	static String weapon;
	static String type;
	int shield;
	
	static {
		atk = 8 * 2;
		def = 1;
		weapon = "사이오닉 검";
		type = "질럿";
	}
	
	public Zealot() {
		this(1);
	}

	public Zealot(int num) {
		this(num, 100);
	}

	Zealot(int num, int hp) {
		super(num, hp);
		this.shield = 60;
	}
	
	@Override
	public void reportStatus() {
		System.out.println(type + "#" + num + ":");
		System.out.println(String.format("  - 생명력: %d, 공격력: %d, 방어력: %d, 보호막: %d", 
				this.hp, atk, def, this.shield));
		System.out.println("  - 무기 이름: " + weapon + "\n");
	}
	
	public void attack(Zergling z, int count) {
//		z.hp += (z.def - this.atk) * count;  // 직접 값에 접근하지 말고, 객체지향으로 data encapsulation을 적용 : 함수로 간접적으로 데이터 변경해야 함!
//		z.setHp(z.getHp() + count * (z.getDef() - this.atk));
		z.getAttacked(atk, count);
	}
	
}
