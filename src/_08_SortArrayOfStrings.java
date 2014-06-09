import java.util.Scanner;

public class _08_SortArrayOfStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		System.out.print("Enter number of strings to enter:  ");
		int n = in.nextInt();	
		String[] Array = new String[n];
		for (int i = 0; i<n; i++){
			System.out.print("Enter string number " + (i+1) + ": ");
			Array[i] = in.next();
		}
		in.close();
		
		//sorting
		System.out.println("The sorted strings are:");
		for(int j=0; j<Array.length;j++)
		 {
		     for (int i=j+1 ; i<Array.length; i++)
		     {
		         if(Array[i].compareTo(Array[j])<0)
		         {
		             String temp= Array[j];
		             Array[j]= Array[i]; 
		             Array[i]=temp;
		         }
		     }
		     System.out.print(Array[j]);
		     System.out.println();
		 }
	}

}
