import java.util.*;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> pokemons = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int pokemonsLength = pokemons.size();
        int sum = 0;
        boolean remove = false;

        while (pokemonsLength > 0) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0) {
                int valueZero = pokemons.get(0);
                sum += valueZero;
                pokemons.set(0, pokemons.get(pokemons.size() - 1));
                for (int i = 0; i < pokemons.size(); i++) {
                    if (pokemons.get(i) <= valueZero) {
                        pokemons.set(i, pokemons.get(i) + valueZero);
                    } else {
                        pokemons.set(i, pokemons.get(i) - valueZero);
                    }
                }

            } else if (index >= pokemons.size()) {
                int valueLast = pokemons.get(pokemons.size() - 1);
                sum += valueLast;
                pokemons.set(pokemons.size() - 1, pokemons.get(0));
                for (int i = 0; i < pokemons.size(); i++) {
                    if (pokemons.get(i) <= valueLast) {
                        pokemons.set(i, pokemons.get(i) + valueLast);
                    } else {
                        pokemons.set(i, pokemons.get(i) - valueLast);
                    }
                }

            } else {
                int indexValue = pokemons.get(index);
                sum += indexValue;
                pokemons.remove(index);
                remove = true;
                for (int i = 0; i < pokemons.size(); i++) {
                    if (pokemons.get(i) <= indexValue) {
                        pokemons.set(i, pokemons.get(i) + indexValue);
                    } else {
                        pokemons.set(i, pokemons.get(i) - indexValue);
                    }
                }
            }

            if (remove) {
                pokemonsLength--;
                remove = false;
            }
        }

        System.out.println(sum);

    }
}