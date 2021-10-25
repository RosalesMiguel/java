import java.util.Arrays;
import java.util.Scanner;


public class ArrayRotate {

    public static int[] arrayRotation(int numElems, int[] A, int K) {
		int[] A_rot = new int[numElems];
		A_rot = A;
		int temp;
		for (int i = 0; i < K; i++){
			temp = A_rot[numElems-1]; //Stores last element of array
			for (int j = 1; j < numElems; j++){
				A_rot[numElems-j] = A_rot[numElems-(j+1)];
			}
			A_rot[0] = temp; //Moves stored last element to the first index
		}
		return A_rot;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		for (int i=0; i < n;i++) {
			arr[i] = input.nextInt();
		}
		int K = input.nextInt();
		input.close();
		int[] arrRot  = arrayRotation(n, arr, K);
		System.out.println(Arrays.toString(arrRot));
	}
}