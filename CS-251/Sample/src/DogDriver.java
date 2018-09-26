

public class DogDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Average dog weight before creating any dogs: " + Dog.getAverageWeight());
		System.out.println();

		Dog d1 = new Dog();
		
		Dog d2 = new Dog("Collie" , 50, 6, "Monty");
		System.out.println("Dog d2: " + d2);
		
		System.out.println();
		System.out.println("Is " + d1.getName() + " barking? " + d1.isBarking());

		System.out.println("Average dog weight: " + Dog.getAverageWeight());
		
		System.out.println();
		System.out.println("Does d1 equal d2: " + d1.equals(d2));
		System.out.println("Does d1 equal d1: " + d1.equals(d1));
		
		System.out.println();
		PetOwner nate = new PetOwner("Nate");
		nate.addDog(d1);
		nate.addDog(d2);
		nate.printDogs();
		
		System.out.println();
		System.out.println("Dog " + d1.getName() + " owner is: " + d1.getOwner().getName());

		
	}

}
