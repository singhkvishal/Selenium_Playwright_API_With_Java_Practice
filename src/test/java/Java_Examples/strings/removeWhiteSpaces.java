package Java_Examples.strings;

public class removeWhiteSpaces {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        String name = "My name is Vishal Singh";

        for (int i = 0; i < name.length(); i++) {
            if (!Character.isWhitespace(name.charAt(i))) {
                output.append(name.charAt(i));
            }
        }
        // output.append(name.replaceAll(" ",""));
        System.out.println(output);
    }
}
