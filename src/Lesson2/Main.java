package Lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] arrCorrect = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };

        String[][] arrWrongSize = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3"},
        };

        String[][] arrWrongData = {
                {"1", "2", "3", "q"},
                {"1", "2", "3", "w"},
                {"1", "2", "3", "e"},
                {"1", "2", "3", "r"},
        };

        try {
            System.out.println(sum(arrWrongData));
        } catch (MyArraySizeException e) {
            System.out.println("Size of array must be 4x4");
        } catch (MyArrayDataException e) {
            System.out.println("Wrong data");
        }
    }

    public static int sum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        isMyArrSizeWrong(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    System.out.printf("В ячейке массива %d %d находится NaN\n", i, j);
                    System.out.println();
                    throw new MyArrayDataException();
                }
            }
        }
        return sum;
    }

    public static void isMyArrSizeWrong(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4 || arr[i].length != 4) {
                throw new MyArraySizeException();
            }
        }
    }
}

