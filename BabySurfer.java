import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BabySurfer {
	public static void display(BabyName baby) {
		
		int [] yrs = baby.getRanks();
		int yr = 1900;
		System.out.println("Name: " + baby.getName());
		for(int i = 0; i < 11; i++) {
			int rank = yrs[i];
			if(rank > 899) {
				System.out.println(yr + " * " + rank);
			}else if(rank > 799) {
				System.out.println(yr + " ** " + rank);
			}else if(rank > 699) {
				System.out.println(yr + " *** " + rank);
			}else if(rank > 599) {
				System.out.println(yr + " **** " + rank);
			}else if(rank > 499) {
				System.out.println(yr + " ***** " + rank);
			}else if(rank > 399) {
				System.out.println(yr + " ****** " + rank);
			}else if(rank > 299) {
				System.out.println(yr + " ******* " + rank);
			}else if(rank > 199) {
				System.out.println(yr + " ******** " + rank);
			}else if(rank > 99) {
				System.out.println(yr + " ********* " + rank);
			}else if(rank > 0) {
				System.out.println(yr + " ********** " + rank);
			}else {
				System.out.println(yr);
			}
			yr+= 10;
		}
	}//end display
	
	public static void main(String [] args) {
		//create variable for file name
		File inFile = new File("BabyName.txt");
		
		//instantiate linked queue
		LinkedQueue<Object> BabyQueue = new LinkedQueue<Object>();
		
		//no file error prevention
		try {
			//create file scanner
			Scanner Fscan = new Scanner(inFile);
			
			//iterate through file
			while(Fscan.hasNext()) {
				//instantiate variables
				String inLine, name;
				String [] line;
				int [] nums = new int[11];
				
				inLine = Fscan.nextLine();
				
				//separate name and ranks
				line = inLine.split(" ");
				name = line[0];
				int j = 0;
				for(int i = 1; i < 12; i++) {
					nums [j] = Integer.parseInt(line[i]);
					j++;
				}
				
				//send babyname object into queue
				BabyName n1 = new BabyName(name, nums);
				BabyQueue.enqueue(n1);
				
			}//end iteration through file
			
		} catch (FileNotFoundException e) {
			System.out.println("No file listed with that name");
		}//end try/catch
		
		Scanner Kscan = new Scanner(System.in);
		
		//ask user for name
		System.out.print("Enter a name: ");
		String choice = Kscan.next();
		
		//make flag for name found
		boolean found = false;
		
		while((!BabyQueue.isEmpty()) && found == false) {
			BabyName n2 = (BabyName) BabyQueue.dequeue();
			//check against name user provided
			if(n2.getName().equalsIgnoreCase(choice)) {
				found = true;
				display(n2);
			}
			//check if end of queue reached
			if(BabyQueue.isEmpty()) {
				System.out.println("Name not found.");
			}
		}//end while
	}//end main
}//end class

