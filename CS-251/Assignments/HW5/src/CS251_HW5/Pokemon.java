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
		return this.health;
	}

	public void setHealth(int health) {
		if (health < 0) {
			return;
		}
		this.health = health;
	}

	public int getPower() {
		return this.power;
	}

	public void setPower(int power) {
		if (power < 0) {
			return;
		}
		
		this.power = power;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		if (level < 0) {
			return;
		}
		this.level = level;
	}
 
	public String getName() {
		return this.name;
	}
	
	public boolean isDefeated() {
		if (getHealth() > 0) {
			return false;
		}
		return true;
	}
	
	protected void hurt(int damage) {
		if (damage < 0) {
			return;
		}
		if ((this.health - damage) < 0) {
			setHealth(0);
			
			
		}
		setHealth(this.health - damage);
		
	}
	
	public abstract void specialAttack(Pokemon target);
	
	public abstract void physicalAttack(Pokemon target);
	
	
	
}