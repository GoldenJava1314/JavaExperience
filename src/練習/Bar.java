package 練習;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Bar extends Foo {
	
//	public <T> Collection<T> foo(Stream<T> arg){
//		return null;
//		
//	}
	@Override
	public <T> List<T> foo(Collection<T> arg) {
		return null;
		
	}
}
