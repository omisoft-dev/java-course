package inittest;

public class B extends A{
    {
	System.out.println("4");
    }
    static
    {
	System.out.println("5");
    }
   
    private String c;
    public B()
    {
	super();
	c="6";
	System.out.println(c);
    }
}
