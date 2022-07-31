import java.util.Scanner;

//too many numbers compared to given length
class TooManyNumbers extends RuntimeException {
    public TooManyNumbers(String s){
        super(s);
    }
}
//not enough numbers compared to given length
class NotEnoughNumbers extends RuntimeException {
    public NotEnoughNumbers(String s){
        super(s);
    }
}
//invalid input
class InvalidInput extends RuntimeException {
    public InvalidInput(String s){
        super(s);
    }
}

public class StringSortCheck {
    static void inputExceptionHandling(String numbers, int userLength) throws RuntimeException{
        if (numbers.charAt(0) == 32) {
            throw new InvalidInput("You should start input with a number");
        }

        if (numbers.charAt(numbers.length() - 1) == 32) {
            throw new InvalidInput("You should use spaces only for separating numbers");
        }

        for (int i = 0; i < numbers.length() - 1; i++) {
            if ((numbers.charAt(i) == 32) && (numbers.charAt(i + 1) == 32)) {
                throw new InvalidInput("You can only input numbers and singular spaces to separate them");
            }
        }

        int spaceCount = 0;
        for (int i = 0; i < numbers.length(); i++) {
            if (((numbers.charAt(i) >=  48) && (numbers.charAt(i) <= 57)) || numbers.charAt(i) == 32) {
                if (numbers.charAt(i) == 32) {
                    spaceCount++;
                }
            }
            else {
                throw new InvalidInput("You can only input numbers and singular spaces to separate them");
            }
        }

        if (spaceCount != userLength - 1) {
            if (spaceCount < userLength - 1) {
                throw new NotEnoughNumbers("You have to input the amount of numbers you've already provided - " +
                        "now it's not enough numbers");
            }
            else {
                throw new TooManyNumbers("You have to input the amount of numbers you've already provided - " +
                        "now it's too many numbers");
            }
        }
    }

    static boolean CheckingIfArrayIsSorted (String[] array, int length) {
        boolean isSorted = true;
        for (int i = 0; i < length - 1; i++){
            if (Integer.parseInt(array[i]) > Integer.parseInt(array[i + 1])){
                isSorted = false;
                break;
            }
        }

        return(isSorted);
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        int length = input.nextInt();
        input.nextLine();
        String numbers = input.nextLine();

        try {
            inputExceptionHandling(numbers, length);
            String[] array = numbers.split(" ");
            System.out.println(CheckingIfArrayIsSorted(array, length));
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
