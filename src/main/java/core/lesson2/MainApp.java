package core.lesson2;
//Для получения MyArrayDataException в методе myArrayFiller есть закоментированные строчки
public class MainApp {
    static int x=4, y=4;
    static String[][] myArray = new String[4][4];
    static int summ=0;
    static String dataError = "Ошибка конвертации в позиции: ";

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        myArrayFiller();
        arrayPrint(myArray);
        System.out.println();
        workMethod(myArray);
    }

    private static void arraySizeCheck(String[][] array) throws MyArraySizeException {
        if(array.length != x || array[0].length != y) throw new MyArraySizeException(); //Условие для if пришлось подсмотреть. Расскажите, пожалуйста, как это работает
    }

    public static void workMethod(String[][] array) throws MyArraySizeException, MyArrayDataException {
        arraySizeCheck(array);
        int i=0;
        int j=0;
        try {
            for(; i<x; i++) {
                for(; j<y; j++) {
                    summ += Integer.parseInt(array[i][j]);

                }
                j=0;
            }
        } catch (NumberFormatException m) {
            throw new MyArrayDataException(dataError + i +":"+ j);
        }

            System.out.println("Сумма элементов массива равна: " + summ);
    }

    public static void myArrayFiller() {
        for(int i = 0; i<x; i++) {
            for(int j = 0; j<y; j++) {
                myArray[i][j] = String.valueOf(j);
            }
        }

        //myArray[0][1] = "fail";
        //myArray[1][3] = "fail";
        //myArray[3][2] = "fail";
        //myArray[2][0] = "fail";

    }

    public static void arrayPrint(Object[][] array) {
        for(int i = 0; i<x; i++) {
            for(int j = 0; j<y; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
