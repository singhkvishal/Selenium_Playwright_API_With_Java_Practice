package Java_Examples.strings;

public class RemoveSpecialCharacterInString {
	public static void main(String[] args) {
		String str = "!@**&(*$!^*%%&Remove{}|{Special,/.[]Characters~```+=_-";

		System.out.println("Input String: " + str);

		str = str.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println("Output String: " + str);
	}
}
