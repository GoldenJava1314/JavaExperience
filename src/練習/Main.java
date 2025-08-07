package 練習;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.w3c.dom.ls.LSOutput;

public class Main{
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread());
	      Thread t2 = new Thread(new MyThread());
	      Thread t3 = new Thread(new MyThread());

	      t1.start();
	      t2.run();
	      t3.start();

//	      t1.start();
	}
	
	}
