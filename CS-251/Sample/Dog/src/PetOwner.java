

public class PetOwner {

	private String name;
	private Dog[] myDogs;
	private int dogCounter = 0;
	
	public PetOwner(String name) {
		this.name = name;
		myDogs = new Dog[10];
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addDog(Dog d) {
		if(dogCounter >= myDogs.length)
			return;
		
		myDogs[dogCounter++] = d;
		d.setOwner(this);
	}
	
	public void printDogs() {
		System.out.println("PetOwner " + name + " has:");
		for(int i = 0; i < dogCounter; i++) {
			System.out.println(myDogs[i]);
		}
	}
	
	@Override
	public String toString() {
		return "Owner name: " + this.name;
	}
	
}
