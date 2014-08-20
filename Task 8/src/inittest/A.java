package inittest;

public class A {
    {
	System.out.println("1");
    }
    static
    {
	System.out.println("2");
    }
    private String b;
    
    public A()
    {
	b="3";
	System.out.println(b);
    }
}
