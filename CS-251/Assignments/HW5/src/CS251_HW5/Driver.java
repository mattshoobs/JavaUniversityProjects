package CS251_HW5;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Pokemon[] arrOfPokemons = new Pokemon[4];
		Scanner stdIn = new Scanner(System.in);

		Pokemon pokemon = null;

		for (int i = 0; i < arrOfPokemons.length; i++) {
			while (true) {
				System.out.println("Enter name, health, power, and level for Pokemon " + i + ": ");
				String input = stdIn.nextLine();
				String[] pokie = input.split(" ");

				pokemon = makePokemon(pokie[0], Integer.parseInt(pokie[1]), Integer.parseInt(pokie[2]),
						Integer.parseInt(pokie[3]));

				if (!contains(pokemon, arrOfPokemons)) {
					break;
				}

			}

			arrOfPokemons[i] = pokemon;

			// TODO
			// Read input from user.
			// Create a pokemon and add it to the array if it is not a duplicate.

		}

		System.out.println();

		System.out.println("Pokemons before playing");
		print(arrOfPokemons);

		System.out.println();
		for (int i = 0; i < 3; i++) {
			play(arrOfPokemons, stdIn, i);
		}

		System.out.println();
		System.out.println("Pokemons After playing");
		print(arrOfPokemons);

		stdIn.close();
	}

	private static void print(Pokemon[] arrOfPokemons) {

		// Print the pokemons in the arrOfPokemons array
		for (int index = 0; index < arrOfPokemons.length; index++) {
			System.out.printf("%d: %s\n", index, arrOfPokemons[index].toString());
		}

	}

	private static void play(Pokemon[] arrOfPokemons, Scanner stdIn, int numberOfPlay) {
		int firstPokemon = 0;
		int secondPokemon = 0;
		do {
			System.out.printf("# %d Please enter the pokemons you want to play 0 to 3: ", numberOfPlay);
			firstPokemon = stdIn.nextInt();
			secondPokemon = stdIn.nextInt();

		} while (firstPokemon < 0 || firstPokemon > 4 || secondPokemon < 0 || secondPokemon > 4);

		arrOfPokemons[firstPokemon].specialAttack(arrOfPokemons[secondPokemon]);

		// think of this part as a counterattack
		arrOfPokemons[secondPokemon].physicalAttack(arrOfPokemons[firstPokemon]);

	}

	/**
	 * Creates a pokemon based on name passed to method.
	 * 
	 * @param name
	 * @param health
	 * @param power
	 * @param level
	 * @return Pokemon (Charmander or Pikachu)
	 */
	static Pokemon makePokemon(String name, int health, int power, int level) {
		Pokemon pokemon = null;
		// TODO
		if (name.equalsIgnoreCase("Pikachu")) {
			pokemon = new Pikachu(health, power, level);
			
		} else if (name.equalsIgnoreCase("Charmander")) {
			pokemon = new Charmander(health, power, level);
		
		}
		return pokemon;
	}

	/**
	 * Tells if array contains a pokemon already.
	 * 
	 * @param pok
	 * @param arrOfPokemons
	 * @return boolean
	 */

	protected static boolean contains(Pokemon pok, Pokemon[] arrOfPokemons) {

		// TODO
		for (int i = 0; i < arrOfPokemons.length; i++) {
			if (pok != null && pok.equals(arrOfPokemons[i])) {
				return true;
			}
		}
		return false;
	}
}
