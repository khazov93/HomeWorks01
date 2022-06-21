package HomeWork02;

public class HW02 {

    static String[][] doubleArray = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};

    static String[][] troubleDoubleArray = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "f", "4"}};

    static String[][] arrayBadSizeException = {{"1", "2"}, {"1", "2",}, {"1", "2"}, {"1", "2"}};

    static int sizeX = 4;
    static int sizeY = 4;

    public static void main (String [] args)
    {

        // Правильный массив
        try {
            System.out.println("Сумма массива: " + getSumm(doubleArray));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }


        // Неправильный размер массива
        try {
            System.out.println("Сумма массива: " + getSumm(arrayBadSizeException));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }

        // Ошибка в наполнении массива

        try {
            System.out.println("Сумма массива: " + getSumm(troubleDoubleArray));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }

    }

    static void checkValue(String[][] array)

            throws MyArraySizeException
    {
        if(array.length!=sizeX || array[0].length!=sizeY) throw new MyArraySizeException();
    }


    static int getSumm(String[][] array)

            throws MyArrayDataException,MyArraySizeException
    {
        checkValue(array);
        int result = 0;
        int i =0;
        int j =0;
        try {
            for (; i < array.length; i++) {
                j = 0;
                for (; j < array.length; j++) {
                    result = result + Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException ex){
            throw new  MyArrayDataException("Ошибка в позиции: " + ( i + 1 ) + " , " + ( j + 1 ));
        }

        return result;
    }


}
