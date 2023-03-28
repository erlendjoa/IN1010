import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Pokemon> pokemonList = Startup.lagPokemons();

        for (Pokemon pokemon : pokemonList) {
            System.out.println(pokemon.id + pokemon.name);
        }
    }
}