/**
 * 
 */
package warmup;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * @author Tamilthaaragai
 *
 */
public class Genexmpl {

	/**
	 * @param args
	 */
 	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		//String str = sc.nextLine();		
		String url = "http://howtodoinjava.com/java-initerview-quest!ions";
		StringTokenizer strTok = new StringTokenizer(url, "://.-![,?.\\_'@+]");
		System.out.println(strTok.countTokens());
		while (strTok.hasMoreTokens())
		{
		    System.out.println(strTok.nextToken());
		}
	}

}
