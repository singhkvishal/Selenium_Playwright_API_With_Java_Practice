package Java_Examples.strings;

public class StringBuilder_ReverseString {
    public static void main(String[] args) {
        StringBuilder str=new StringBuilder();
        String sValue="1234";

        char []aString=sValue.toCharArray();
        for(int i=aString.length-1;i>=0;i--){
            str.append(aString[i]);
        }
        System.out.println(str);
    }
}
