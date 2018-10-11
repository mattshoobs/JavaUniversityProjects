package CS251_HW5;

public abstract class Pokemon {
	
	protected String name;
	protected int health;
	protected int power;
	protected int level;
	
	
	public Pokemon() {
		this("Ditto", 50, 10, 7);
		
	}
	
	public Pokemon(String name, int health, int power, int level) {
		this.name = name;
		this.health = health;
		this.power = power;
		this.level = level;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}
	
	public boolean isDefeated() {
		
	}
	
	protected void hurt(int damage) {
		
	}
	
	public void abstract specialAttack(Pokemon target);
	
	
	
}