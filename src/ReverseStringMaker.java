import java.util.Scanner;

public class ReverseStringMaker {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String stringToReverse = input.nextLine();
        int length = stringToReverse.length();
        ToReverseMethods reverse = new ToReverseMethods();

        System.out.println(reverse.iterationReverse(stringToReverse));
        System.out.println(reverse.stringBuilderReverse(stringToReverse));
        System.out.println(reverse.charAdditionReverse(stringToReverse));
    }
}
