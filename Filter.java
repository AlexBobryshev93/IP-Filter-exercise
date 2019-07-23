import java.io.*;

//should be a Servlet
public class Filter {
	public static void main(String[] args) {
		String temp;
		
		try {
			if (args.length != 1) {
				throw new RuntimeException();
			}
		} catch (RuntimeException exc) {
			System.out.println("Error: wrong parameters! Usage: java -jar Filter.jar \"{IP-adress}\" ");
			return;
		}

		try (BufferedReader fin = new BufferedReader(new FileReader("blacklist.txt"))) {
			for (int i = 0; ; i++) {
				temp = fin.readLine();
				if (temp == null) { // the blacklist has no more IP's or was empty from the beginning
					System.out.println("Access allowed");
					return;
				} else if (args[0].equals(temp)) { //the checked IP is on the blacklist  
					System.out.println("Access disallowed");
					return;
				} 
			}	
		} catch (IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
	}
}