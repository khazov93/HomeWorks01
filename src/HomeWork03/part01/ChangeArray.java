package HomeWork03.part01;

public class ChangeArray <T> {

    T buffer;

    public T[] changeElements( T[] array, int indexA, int indexB){
        buffer = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = buffer;
        return array;
    }

}
