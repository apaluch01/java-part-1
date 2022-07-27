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
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isSorted = true;

        int length = input.nextInt();
        input.nextLine();

        int spaceCount = 0;
        try{
            String numbers = input.nextLine();
            for (int i = 0; i < numbers.length(); i++) {
                if ((numbers.charAt(i) < 48) || (numbers.charAt(i) > 57)) {
                    if (numbers.charAt(i) == 32) {
                        spaceCount++;
                    }
                    else {
                        throw new InvalidInput("You can only input numbers and spaces to separate them");
                        break;
                    }
                }
            }

            if (spaceCount != length - 1) {
                if (spaceCount < length - 1) {
                    throw new NotEnoughNumbers("You have to input the amount of numbers you've already provided - " +
                            "now it's not enough numbers");
                }
                else {
                    throw new TooManyNumbers("You have to input the amount of numbers you've already provided - " +
                            "now it's too many numbers");
                }
            }
        }
        catch (InvalidInput e){
            System.out.println(e.getMessage());
        }
        catch (TooManyNumbers e){
            System.out.println(e.getMessage());
        }
        catch (NotEnoughNumbers e){
            System.out.println(e.getMessage());
        }

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
