public class ToReverseMethods{
    public String iterationReverse(String toReverse, int length){
        StringBuilder reverse = new StringBuilder();
        for (int i = 0; i < length; i++){
            reverse.append(toReverse.charAt(length - 1 - i));
        }
        return(reverse.toString());
    }

    public String stringBuilderReverse (String toReverse){
        StringBuilder reverse = new StringBuilder(toReverse);
        reverse.reverse();
        return(reverse.toString());
    }

    public String charAdditionReverse (String toReverse, int length){
        String frontAddition = "";
        for (int i = length - 1; i >= 0; i--){
            frontAddition = frontAddition + toReverse.charAt(i);
        }
        return(frontAddition);
    }
}
