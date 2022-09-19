package core.lesson3;

public class TaskOneMethod<T> {

    public T[] shift(T[] array, int posOne, int posTwo) {
        T intermediate = array[posOne];
        array[posOne] = array[posTwo];
        array[posTwo] = intermediate;
        return array;
    }

}
