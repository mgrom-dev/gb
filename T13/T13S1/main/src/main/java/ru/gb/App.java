package ru.gb;

import com.github.lalyos.jfiglet.FigletFont;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            String asciiArt = FigletFont.convertOneLine("Hello World!");
            System.out.println(asciiArt);
            System.out.println(FigletFont.convertOneLine("GB school!!!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
