import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Заполнить список названиями планет Солнечной
 * системы в произвольном порядке с повторениями.
 * Вывести название каждой планеты и количество его
 * повторений в списке.
 * Пройти по списку из предыдущего задания и удалить
 * повторяющиеся элементы.
 */
public class SolarSystem {
    public static void main(String[] args) {
        List<String> planets = getPlanets();
        printPlanets(planets);
        System.out.println(deleteRepeatsPlanets(planets));
    }

    private static List<String> deleteRepeatsPlanets(List<String> planets) {
        List<String> result = new ArrayList<>(planets);
        for (int i = 0; i < result.size(); i++){
            int lastIndex = i;
            String planet = result.get(i);
            while((lastIndex = result.lastIndexOf(planet)) != i)
                result.remove(lastIndex);
        }
        return result;
    }

    private static void printPlanets(List<String> planets) {
        List<String> sortedPlanets = new ArrayList<>(planets);
        Collections.sort(sortedPlanets);
        String prevPlanet = "";
        int count = 0;
        for (String planet : sortedPlanets) {
            if (!prevPlanet.equals(planet)) {
                System.out.printf("%s%s\n", prevPlanet, (count > 0 ? " - " + (count + 1) : ""));
                prevPlanet = planet;
                count = 0;
            } else
                count++;
        }
    }

    private static List<String> getPlanets() {
        List<String> planets = new ArrayList<String>() {
            {
                addAll(Arrays.asList("Меркурий", "Меркурий", "Уран", "Меркурий", "Венера", "Венера", "Марс", "Юпитер", "Сатурн", "Уран",
                        "Юпитер", "Нептун"));
            }
        };
        return planets;
    }
}
