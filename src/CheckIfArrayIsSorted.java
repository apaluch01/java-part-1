import java.util.Scanner;

//too many numbers compared to given length
class TooManyNumbers extends Exception {

}
//not enough numbers compared to given length
class NotEnoughNumbers extends Exception {

}
//invalid input
class InvalidInput extends Exception {

}

public class CheckIfArrayIsSorted {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isSorted = true;

        int length = input.nextInt();
        input.nextLine();
        String numbers = input.nextLine();

        String[] array = numbers.split(" ");

        for (int i = 0; i < length - 1; i++){
            if (Integer.parseInt(array[i]) > Integer.parseInt(array[i + 1])){
                isSorted = false;
                break;
            }
        }

        System.out.println(isSorted);
    }
}
