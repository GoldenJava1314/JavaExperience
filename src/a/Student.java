// package a;
package a;
import b.Person;

public class Student extends Person {
	
	public Student() {
	} // ✅ 可以合法使用 protected 建構子
    
	
    public Student(String name, String age) {
        super(name, age); // ✅ 可以合法使用 protected 建構子
    }
}