package HomeWork04.part01;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class P01 {

    public static void main(String [] args)
    {

        Set<String> words = new TreeSet<>();
        words.add("Moscow");
        words.add("Tula");
        words.add("Kaluga");
        words.add("Moscow");
        words.add("Krasnodar");
        words.add("Sochi");
        words.add("Moscow");
        words.add("Kalliningrad");
        words.add("Tula");
        words.add("Anapa");
        words.add("Vladivostok");
        words.add("Moscow");
        words.add("Krasnodar");

        //вывод на печать слов без дубликатов
        System.out.println(words);



        //вывод на печать количества слов.
        Iterator<String> iter = words.iterator();
        int i = 0;
        while (iter.hasNext()) {
            String str = iter.next();
            {i++;}
        }
        System.out.println("Количество слов: " + i);
    }
}
