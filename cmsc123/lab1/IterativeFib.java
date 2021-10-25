import java.util.Scanner; 
import java.math.BigInteger;


public class IterativeFib {



	public static void iterativeFib(int N) {
		if(N == 0){
			System.out.println("0");
		}
		else if(N == 1){
			System.out.println("1");
		}
		else {
			BigInteger[] arr = new BigInteger[3];
			arr[0] = BigInteger.valueOf(0);
			arr[1] = BigInteger.valueOf(1);
			for(int i = 0; i < N-1; i++){
				arr[2] = arr[0].add(arr[1]);
				arr[0] = arr[1];
				arr[1] = arr[2];
			}
		System.out.println(arr[2]);
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter N: ");
		int N = input.nextInt();
		iterativeFib(N);
		input.close();
	}
}