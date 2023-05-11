package ch10.sc.unit;

public class Zergling extends Unit {

	static int atk;
	static int def;
	static String weapon;
	static String type;
	
	static {
		atk = 5;
		def = 0;
		weapon = "발톱";
		type = "저글링";
	}
	
	public Zergling() {
		this(1);
	}

	public Zergling(int num) {
		this(num, 35);
	}

	Zergling(int num, int hp) {
		super(num, hp);
	}
	
	@Override
	public void reportStatus() {
		System.out.println(type + "#" + num + ":");
		System.out.println(String.format("  - 생명력: %d, 공격력: %d, 방어력: %d", 
				this.hp, atk, def));
		System.out.println("  - 무기 이름: " + weapon + "\n");
	}
	
	@Override
	public String toString() {
		String report = type + "#" + num + ":\n";
		report += String.format("  - 생명력: %d, 공격력: %d, 방어력: %d\n", 
				this.hp, atk, def);
		report += "  - 무기 이름: " + weapon + "\n";
		
		return report;
	}
	
	private int calcDamage(int atkDamage) {
		return def - atkDamage;
	}
	
	public void getAttacked(int atkDamage, int count) {
//		this.hp += (this.def - atkDamage) * count;
		this.hp += calcDamage(atkDamage) * count;
	}
	
}
