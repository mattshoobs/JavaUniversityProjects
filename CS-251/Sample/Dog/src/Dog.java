
public class Dog {
	
	private String breed;
	private int weight;
	private int age;
	private String name;
	private static int totalCount;
	private static int totalWeight;
	private PetOwner owner;
	
	//default constructor
	public Dog() {
		this("lab",65,1,"Stanly");
	}
	
	//specifying constructor
	public Dog(String breed, int weight, int age, String name) {
		this.breed = breed;
		this.weight = weight;
		this.age = age;
		this.name = name;
		
		totalCount++;
		Dog.totalWeight += weight;
		
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if(weight < 0)
			return;
		
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age <= 1) {
			return;
		}
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setOwner(PetOwner o) {
		this.owner = o;
	}
	
	public PetOwner getOwner() {
		return this.owner;
	}
	
	public String isBarking() {
		if(Math.random() < .5) {
			return "Woof woof";
		}
		return "<silence>";
	}
	
	
	@Override
	public String toString() {
		return name + ", " + age + " years old, " + weight + "lbs, " + breed;
		
	}
	
	@Override
	public boolean equals(Object other) {
		
		if(other == null)
			return false;
		
		if(other == this)
			return true;
		
		if(this.getClass() != other.getClass())
			return false;
		
		Dog tmpDog = (Dog)other;
		
		return tmpDog.name.equals(this.name) && tmpDog.breed.equals(this.breed);
		
		//recursive call
		//return tmpDog.equals(this);

		//slightly shorter way to do this
/*		if(other instanceof Dog) {
			Dog tmpDog = (Dog)other;
			return tmpDog.name.equals(this.name) && tmpDog.breed.equals(this.breed);
		}
		return false;*/
		
	}
	
	public static double getAverageWeight() {
		if(Dog.totalCount == 0) {
			return 0;
		}
		return Dog.totalWeight / Dog.totalCount;
	}
	
}
