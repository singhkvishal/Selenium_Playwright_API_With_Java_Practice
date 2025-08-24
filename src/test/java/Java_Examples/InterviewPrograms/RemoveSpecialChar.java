package Java_Examples.InterviewPrograms;

import org.testng.annotations.Test;

public class RemoveSpecialChar {
    @Test
    public void RemoveSpecChar_DuplicateSpace(){
        String str="my^*&name^&*is__Vishal()Singh";
        System.out.println(str.replaceAll("[^1-9a-zA-Z]", " ").replaceAll(" +"," "));
    }
}
