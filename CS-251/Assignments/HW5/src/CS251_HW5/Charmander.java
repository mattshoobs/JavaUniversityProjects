package CS251_HW5;

public class Charmander extends Pokemon {

	protected static final int fireBall = 5;
	protected static final int bite = 4;

	public Charmander(int health, int power, int level) {
		super("Charmander", health, power, level);

	}

	@Override
	public void specialAttack(Pokemon target) {
		if (target.isDefeated() || this.isDefeated()) {
			return;
		} else if (getPower() == 0) {
			physicalAttack(target);
		} else if (getPower() < fireBall) {
			target.hurt(getPower());
			setPower(0);
		} else {
			target.hurt(fireBall);
			setPower((getPower() - fireBall));
		}

	}

	@Override
	public void physicalAttack(Pokemon target) {
		if (target.isDefeated() || this.isDefeated()) {
			return;
		}
		target.hurt(bite);

	}

	public boolean equals(Object other) {
		if (other instanceof Charmander) {
			Pokemon p = (Pokemon) other;
			if (p != null && p.getName().equalsIgnoreCase(this.name) && p.getHealth() == this.health
					&& p.getPower() == this.power && p.getLevel() == this.level) {
				return true;
			}
			return false;
		}
		return false;
	}

	public String toString() {
		return "Name: " + this.getName() + ", Health: " + this.getHealth() + ", Power: " + this.getPower() + ", Level: "
				+ this.getLevel();
	}

}
