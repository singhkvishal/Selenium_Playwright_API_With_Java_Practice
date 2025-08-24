package Java_Examples.InterviewPrograms;

import org.htmlunit.csp.value.Hash;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDuplicateElement {
    @Test
    public void DucplicateValue(){
        String str[]={"Java","C#","python","Java"};

        for(int i=0;i< str.length;i++){
            for(int j=i+1;j<str.length;j++){
                if(str[i].equals(str[j])){
                    System.out.println(str[i]+ " is duplicate Element");
                }
            }
        }
    }

    @Test
    public void DucplicateHasSet(){
        String str[]={"Java","C#","python","Java"};
       Set<String> el= new HashSet<>();

        for(int i=0;i< str.length;i++){
           if(el.contains(str[i])){
               System.out.println(str[i]+ " = is duplicate Element");
           }else{
               el.add(str[i]);
           }
        }
    }
    @Test
    public void DucplicateStoreMap(){
        String str[]={"Java","C#","python","Java"};
        Map<Integer,String> el= new HashMap();

        for(int i=0;i< str.length;i++){
            if(el.containsValue(str[i])){
                System.out.println(str[i]+ " = is duplicate Element");
            }else{
                el.put(i,str[i]);
            }
        }
        System.out.println("Duplicate value is Removed "+ el.values());
    }

}
