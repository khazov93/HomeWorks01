package HomeWork03.part01;

import java.util.Arrays;

public class P01
{

        static Integer[] arrayInteger = {1, 2, 3, 4};

        public static void main (String[] args)
    {
        ChangeArray <Object> changeArray = new ChangeArray<>();

            System.out.println(Arrays.toString(changeArray.changeElements(arrayInteger, 0, 1)));

    }

}
