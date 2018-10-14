package CS251_HW5;

public class Pikachu extends Pokemon {

	protected static final int thunderBolt = 6;
	protected static final int swipe = 3;
	
	
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
		
	}
	
	public String toString() {
		
	}
	
}
