/**
 * Преобразуйте пример с классом AllTheColorsOfTheRainbow в работающую
 * программу.
 */
public class AllTheColorsOfTheRainbow {
    int anIntegerRepresentingColors;

    void changeTheHueOfTheColor(int newHue) {
        if (newHue == 1) System.out.println("red");
        else if (newHue == 2) System.out.println("orange");
        else if (newHue == 3) System.out.println("yellow");
        else if (newHue == 4) System.out.println("green");
        else if (newHue == 5) System.out.println("blue");
        else if (newHue == 6) System.out.println("violet");
        else System.out.println("wrong number of color, use 1 - 6 numbers");
    }

    public static void main(String[] args) {
        AllTheColorsOfTheRainbow rainbow = new AllTheColorsOfTheRainbow();
        for (int i = 1; i < 7; i++)
            rainbow.changeTheHueOfTheColor(i);
    }
}
