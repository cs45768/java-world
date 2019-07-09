package cn.zch;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World，JDK7!" );
        System.out.println( "Hello World，JDK7!" );
        String varietyCode ="F005";
    	System.err.println(varietyCode.substring(2, 4));
    	
    	TestObject o1 = new TestObject();
    	o1.setAge("1");
    	o1.setName("zz");
    	TestObject o2 = new TestObject();
    	o2.setAge("2");
    	o2.setName("cc");
    	List<TestObject> list = new  ArrayList();
    	list.add(o1);
    	list.add(o2);
    	
    	for(TestObject o:list){
    		 System.out.println( o.toString() );
    		 o.setAge("33");
    		 break;
    		
    	}
    	System.out.println("------------------------");
    	for(TestObject o:list){
    		 System.out.println( o.toString() );
    		 continue;
    	}
    	
    }
}
