package test;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Elephant {
	public static void main(String[] args) {
		 List<String> fruits = List.of("banana","orange","apple","lemon");
		    Stream<String> s1 = fruits.stream();
		    Stream<String> s2 = s1.peek(i->System.out.print(i+" "));
		    System.out.println("--------");
		    Stream<String> s3 = s2.sorted();
		    Stream<String> s4 = s3.peek(i->System.out.print(i+" "));
		    System.out.println("--------");
		    String strFruits = s4.collect(Collectors.joining(","));
		    System.out.println();
		    System.out.println(strFruits);
	}
	
    }
