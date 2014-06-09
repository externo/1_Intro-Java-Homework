import java.util.Scanner;


public class _06_SumTwoNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		System.out.print("Enter first Value:  ");
		int first = in.nextInt();
		System.out.print("Enter second Value:  ");
		int second = in.nextInt();
		System.out.print("The sum is:  " + (first+second));
		in.close();
	}

}
