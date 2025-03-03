package Java_Examples;

public class Test9 {
    public static void main(String[] args) {
        int[] a= {0,2,4,1,3};
        for(int i = 0; i < a.length; i++){
            a[i] = a[(a[i] + 3) % a.length];
        }
        System.out.println(a[1]);

        String t1=new String("Test");
        String t=new String("Test");

        System.out.println("T="+t.hashCode());
        System.out.println("T1="+t1.hashCode());

        System.out.println(System.identityHashCode(t));

        int k=1;
        System.out.println(++k + ++k);
    }
}
