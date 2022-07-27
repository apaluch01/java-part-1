import java.util.Scanner;

//too many numbers compared to given length
class TooManyNumbers extends Exception {
    public TooManyNumbers(String s){
        super(s);
    }
}
//not enough numbers compared to given length
class NotEnoughNumbers extends Exception {
    public NotEnoughNumbers(String s){
        super(s);
    }
}
//invalid input
class InvalidInput extends Exception {
    public InvalidInput(String s){
        super(s);
    }
}

public class CheckIfArrayIsSorted {
    static boolean exceptionHandler(String numbers, int userLength) {
        try {
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
        catch (InvalidInput | NotEnoughNumbers | TooManyNumbers e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isSorted = true;

        int length = input.nextInt();
        input.nextLine();
        String numbers = input.nextLine();

        if (exceptionHandler(numbers, length)) {
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
}
