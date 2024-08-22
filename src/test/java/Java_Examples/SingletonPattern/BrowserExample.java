package Java_Examples.SingletonPattern;

public class BrowserExample {
    //1. Private static instance of the class
    private volatile static BrowserExample browserExample;//null;

    //2. Private constructor to prevent / avoid insatnce /object
    private BrowserExample(){}

    //3. Public static getInsatnce method to provide access to the instance/object

    public static  BrowserExample getInstance(){
        if(browserExample==null){
            synchronized (BrowserExample.class){
                if(browserExample==null){
                    browserExample=new BrowserExample();
                }
            }
        }
        return  browserExample;
    }
    public void DisplayMessage(){
        System.out.println("Browser Info");
    }
}
