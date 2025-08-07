package b;
public class Person{
	private String name;
	private String age;
	
  protected Person(){              //line1
  }
  
  protected Person(String name, String age){     
	  this.name = name;
	  this.age = age;
  }
}