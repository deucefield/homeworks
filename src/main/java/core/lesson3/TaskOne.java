package core.lesson3;

public class TaskOne{

    public static void main(String[] args) {
        TaskOneMethod<Object> taskOneMethod = new TaskOneMethod<>();
        Integer[] array = {1, 2, 3};
        for(int i = 0; i<3; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        taskOneMethod.shift(array, 0, 1);

        for(int i = 0; i<3; i++) {
            System.out.print(array[i] + " ");
        }
    }


}

