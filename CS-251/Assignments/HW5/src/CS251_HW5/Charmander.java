package CS251_HW5;

public class Charmander extends Pokemon {
	
	protected static final int fireBall = 5;
	protected static final int bite = 4;

	@Override
	public void specialAttack(Pokemon target) {
		if (target.isDefeated()) {
			return;
		}
		else if (getPower() == 0) {
			physicalAttack(target);
		}
		else if (getPower() < fireBall) {
			target.hurt(getPower());
			setPower(0);
		}
		target.hurt(fireBall);
		setPower((getPower() - fireBall));
	}
	
	@Override
	public void physicalAttack(Pokemon target) {
		if (target.isDefeated()) {
			return;
		}
		target.hurt(bite);
		
	}
	
	public boolean equals(Object other) {
		if (other instanceof Pokemon) {
			Pokemon p = (Pokemon) other;
			
			if ( thi)
		}
	}
	
	public String toString() {
		System.out.println(");
	}
	
}
