import java.util.Scanner;


public class FindAll{
	

	static class List {

		private Object[] arr;
		private int counter;

		public List(String[] arr) {
			this.arr = arr;
			this.counter=0;
		}

		public List(Integer[] arr) {
			this.arr = arr;
			this.counter=0;
		}

		public void display() {

	        String result = "";

	        for (int i = 0; i < this.counter; i++) {

	            if (i < this.counter - 1) {
	                result += this.arr[i] + " ";

	            }

	            else {
	                result += this.arr[i];
	            }
	        }

	        System.out.println(result);
    	}

    	public void insert(int idx, Object x) {
	        if (idx > this.counter) {
	            throw new IllegalArgumentException("Index Out of Range!");
	        }

	        this.counter++;

	        if (this.counter > this.arr.length) {

	            Object[] newArray = new Object[this.arr.length * 2];

	            for (int i = 0; i < this.counter; i++) {

	                if (i < idx) {
	                    newArray[i] = this.arr[i];
	                }
	                else if (i == idx) {
	                    newArray[i] = x;
	                }
	                else {
	                    newArray[i] = this.arr[i-1];
	                }
	            }
	            this.arr = newArray;
	        }
	        else {
	            for (int i = this.counter-1; i > idx; i--) {
	                this.arr[i] = this.arr[i-1];
	            }
	            this.arr[idx] = x;
	        }
    	}

    	public void insert(Object x) {
	        int idx = this.counter;
	        this.counter++;

	        if (this.counter > this.arr.length) {

	            Object[] newArray = new Object[this.arr.length * 2];

	            for (int i = 0; i < this.counter; i++) {

	                if (i < idx) {
	                    newArray[i] = this.arr[i];
	                }
	                else if (i == idx) {
	                    newArray[i] = x;
	                }
	                else {
	                    newArray[i] = this.arr[i-1];
	                }
	            }
	            this.arr = newArray;
	        }
	        else {
	            for (int i = this.counter-1; i > idx; i--) {
	                this.arr[i] = this.arr[i-1];
	            }
	            this.arr[idx] = x;
	        }
    	}


    	public void findAll(Object value, String condition, String elemType) {
    		//Write your code here
			String result = "";

			if (elemType.equals("String")){
				for (int i = 0; i < this.counter; i++) {

					if (i < this.counter - 1) {
						result += this.arr[i] + " ";

					}

					else {
						result += this.arr[i];
					}
				}
			}
			
			if (elemType.equals("Numeric")){
				
			}

	        System.out.println(result);
    	}


	}

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		int numElements = input.nextInt();
		String elemType = input.next();

		if (elemType.equals("String")) {

			String[] arr = new String[numElements];
			List ls = new List(arr);

			for (int i = 0; i < numElements; i++) {

				ls.insert(i, input.next());

			}

			String condition = input.next();
			String x = input.next();
			input.close();
			ls.findAll(x, condition, elemType);


		}else if (elemType.equals("Numeric")){

			Integer[] arr = new Integer[numElements]; 
			List ls = new List(arr);

			for (int i = 0; i < numElements; i++) {

				ls.insert(i, input.nextInt());

			}

			String condition = input.next();
			Integer x = input.nextInt();
			input.close();
			ls.findAll(x, condition, elemType);

		}else{

			System.out.println("Unrecognized data type!");
			return;

		}
	}
}