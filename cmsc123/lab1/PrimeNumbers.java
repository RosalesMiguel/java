import java.util.Scanner;
import java.lang.Math;


public class PrimeNumbers {

	public static void solution(int N) {
		boolean notprime;
		if (N < 2){
			System.out.println("Invalid input. Please enter number greater than 1.");
		}
		else{
			for (int i = 2; i < N+1; i++){
				notprime = false;
				for (int j = 2; j < Math.sqrt(i)+1; j++) { 
					if (i % j == 0) { 
						 notprime = true;
					}
				} 
				if(i == 2 || !notprime){
					System.out.print(i + " ");
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter N: ");
		int n = input.nextInt();
		solution(n);
		input.close();
	}
}