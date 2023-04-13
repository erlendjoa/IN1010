import java.util.*;
import java.io.*;

public class Startup {

    
    public static ArrayList<Pokemon> lagPokemons() {
        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        private final File file = new File("listOfPokemon.csv");

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String[] line = scanner.nextLine().strip().split(";");

                String[] types = new String[2];
                String[] tempTypes = line[1].split(",");
                types[0] = tempTypes[0];
                if (tempTypes.length == 2) {
                    types[1] = tempTypes[1]; 
                }

                Pokemon pokemon = new Pokemon(line[0], types, Integer.parseInt(line[2]), Integer.parseInt(line[3]));
                pokemonList.add(pokemon);
            }
            scanner.close();
            return pokemonList;

        } catch (FileNotFoundException e){
            System.out.println("Fant ikke fil.");
            return new ArrayList<Pokemon>();
        }
    }
}