package Java_Examples.strings;
//A palindrome string is the same string backwards or forwards.
public class checkPalindromeString {
    public static void main(String[] args) {
        String sValue = "ABCCBA";
        int aLen = sValue.length();

        for (int i = 0; i < aLen/2; i++) {
            if(sValue.charAt(i)!=sValue.charAt(aLen-i-1)){
                System.out.println("Not Palindrome String");
            }
        }
    }
}
