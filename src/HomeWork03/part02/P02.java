package HomeWork03.part02;


import java.util.ArrayList;

public class P02 {

    public static void main (String [] args) {


        // Создание массивов коробок с фруктами

        Apple[] apples1 = new Apple[10];
        ArrayList <Apple> applesList1 = new ArrayList<>();

        Apple apple0 = new Apple();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();

        apples1[0] = apple0;
        applesList1.add(apple0);
        apples1[1] = apple1;
        applesList1.add(apple1);
        apples1[2] = apple2;
        applesList1.add(apple2);
        apples1[3] = apple3;
        applesList1.add(apple3);
        apples1[4] = apple4;
        applesList1.add(apple4);
        Box <Apple> box1 = new Box <> (applesList1);

        Apple[] apples2 = new Apple[10];
        ArrayList <Apple> applesList2 = new ArrayList<>();
        apples2[0] = apple0;
        applesList2.add(apple0);
        apples2[1] = apple1;
        applesList2.add(apple1);
        apples2[2] = apple2;
        applesList2.add(apple2);
//       apples2[3] = apple3;
//       applesList2.add(apple3);
//       apples2[4] = apple4;
//       applesList2.add(apple4);
       Box <Apple> box2 = new Box <> (applesList2);


        Orange[] oranges1 = new Orange[5];
        ArrayList <Orange> orangesList1 = new ArrayList<>();

        Orange orange0 = new Orange();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        oranges1[0] = orange0;
        orangesList1.add(orange0);
        oranges1[1] = orange1;
        orangesList1.add(orange1);
        oranges1[2] = orange2;
        orangesList1.add(orange2);
        oranges1[3] = orange3;
        orangesList1.add(orange3);
        Box <Orange> box3 = new Box <> (orangesList1);

        Orange[] oranges2 = new Orange[5];
        ArrayList <Orange> orangesList2 = new ArrayList<>();
        oranges2[0] = orange0;
        orangesList2.add(orange0);
        oranges1[1] = orange1;
        orangesList2.add(orange1);
        oranges1[2] = orange2;
        orangesList2.add(orange2);
        oranges1[3] = orange3;
        orangesList2.add(orange3);
        Box <Orange> box4 = new Box <> (orangesList2);

        // Методы

        System.out.println(apple0.getName() + ": вес в первом ящике = "+ box1.getWeightFruit() + " кг");
        System.out.println(apple0.getName() + ": вес во втором ящике = "+ box2.getWeightFruit() + " кг");
        System.out.println(apple0.getName() + " cравнение веса коробок (если равны = true, если нет = false) : " + box1.compare(box2));
        box1.toEmptyList(box2);

        System.out.println("");
        System.out.println("----------Далее апельсины----------");
        System.out.println("");

        System.out.println(orange0.getName() + ": вес в первом ящике = "+ box3.getWeightFruit() + " кг");
        System.out.println(orange0.getName() + ": вес в первом ящике = "+ box4.getWeightFruit() + " кг");

        System.out.println(orange0.getName() + " cравнение веса коробок (если равны = true, если нет = false) : " + box3.compare(box4));

        box3.toEmptyList(box4);

    }


}
