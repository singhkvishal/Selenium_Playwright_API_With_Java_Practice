package Java_Examples;

public class RemoveExtraSpace {
    public static void main(String[] args) {
        String a = "Java  Spring   React Java";
        //System.out.println(a.replaceAll(" +"," "));
        //System.out.println(a.replaceAll("\\s{2,}", " ").trim());
        System.out.println(a.replaceAll("\\s+"," "));
       /* String[] array = a.split(" ");
        String value = "";
        for (String s : array) {
            if (!s.isEmpty()) {
                value = value + " " + s.trim();
            }
        }
        System.out.println(value);*/
    }
}
