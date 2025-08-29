package 為什麼;

public class Main {
  public static void main(String[] args){
	  char letter = 'b';
	    int i = 0;
	    switch(letter){
	      case 'a':
	        i++;
	        break;
	      case 'b':
	        i++;
	      case 'c' | 'd': // line 1
	        i++;
	        break;
	      case 'f':
	        i++;
	        break;
	      default:
	        System.out.print(letter);
	    }
	    System.out.println(i);
  }
}