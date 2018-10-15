package CS251_HW5;

public class Pikachu extends Pokemon {

	protected static final int thunderBolt = 6;
	protected static final int swipe = 3;
	
	public Pikachu(int health, int power, int level) {
		super("Pikachu", health, power, level);
		
	}
	
	@Override
	public void specialAttack(Pokemon target) {
		if (target.isDefeated()) {
			return;
		}
		else if (getPower() == 0) {
			physicalAttack(target);
		}
		else if (getPower() < thunderBolt) {
			target.hurt(getPower());
			setPower(0);
		}
		target.hurt(thunderBolt);
		setPower((getPower() - thunderBolt));
	}
	
	@Override
	public void physicalAttack(Pokemon target) {
		if (target.isDefeated()) {
			return;
		}
		target.hurt(swipe);
		
	}
	
	
	public boolean equals(Object other) {
		if (other instanceof Pikachu) {
			Pokemon p = (Pokemon) other;
				if (p != null &&  p.getName().equalsIgnoreCase(this.name) && p.getHealth() == this.health && p.getPower() == this.power && p.getLevel() == this.level) {
					return true;
				}
				return false;
			}
			return false;
		}
	
	public String toString() {
		return "Name: " + this.getName() + ", Health: " + this.getHealth() + ", Power: " + this.getPower() + ", Level: " + this.getLevel();
	}
	
}
