import java.util.Scanner;

public class ReverseStringMaker {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String stringToReverse = input.nextLine();

        int length = stringToReverse.length();

        for (int i = 0; i < length; i++){
           System.out.print(stringToReverse.charAt(length - 1 - i));
        }
        System.out.println("\n");

        StringBuilder reverse = new StringBuilder(stringToReverse);
        reverse.reverse();
        System.out.println(reverse);
        System.out.println("\n");

        String frontAddition = "";
        for (int i = length - 1; i >= 0; i--){
            frontAddition = frontAddition + stringToReverse.charAt(i);
            System.out.println(frontAddition);
        }
        System.out.println(frontAddition);
    }
}
