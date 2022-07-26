import java.util.Scanner;

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
