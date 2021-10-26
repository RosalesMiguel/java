import java.util.Scanner;

public class RemoveAll {

	static class List {

		private Object[] arr;
		private int counter;

		public List(String[] arr) {
			this.arr = arr;
			this.counter = 0;
		}

		public List(Integer[] arr) {
			this.arr = arr;
			this.counter = 0;
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
					} else if (i == idx) {
						newArray[i] = x;
					} else {
						newArray[i] = this.arr[i - 1];
					}
				}
				this.arr = newArray;
			} else {
				for (int i = this.counter - 1; i > idx; i--) {
					this.arr[i] = this.arr[i - 1];
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
					} else if (i == idx) {
						newArray[i] = x;
					} else {
						newArray[i] = this.arr[i - 1];
					}
				}
				this.arr = newArray;
			} else {
				for (int i = this.counter - 1; i > idx; i--) {
					this.arr[i] = this.arr[i - 1];
				}
				this.arr[idx] = x;
			}
		}

		public void removeAll(Object value, String condition, String elemType) {
			String removed = "";

			if (elemType.equals("String")) {
				String strVal = value.toString();
				String[] strArr = new String[this.counter];
				for (int k = 0; k < this.counter; k++) {
					strArr[k] = this.arr[k].toString();
				}

				if (condition.equals("==")) {
					for (int l = 0; l < this.counter; l++) {
						if (strArr[l].equals(strVal)) {
							// do nothing
						} else {
							removed += strArr[l] + " ";
						}
					}
				} else if (condition.equals("!=")) {
					for (int l = 0; l < this.counter; l++) {
						if (strArr[l].equals(strVal)) {
							removed += strArr[l] + " ";
						}
					}
				} else {
					System.out.println("Condition invalid!");
					return;
				}
			}

			if (elemType.equals("Numeric")) {
				int intVal = (int) value;
				int[] intArr = new int[this.counter];
				for (int j = 0; j < this.counter; j++) {
					intArr[j] = (int) this.arr[j];
				}

				if (condition.equals("==")) {
					for (int i = 0; i < this.counter; i++) {
						if (intArr[i] == intVal) {
							// do nothing
						} else {
							removed += intArr[i] + " ";
						}
					}
				} else if (condition.equals(">")) {
					for (int i = 0; i < this.counter; i++) {
						if (intArr[i] > intVal) {
							// do nothing
						} else {
							removed += intArr[i] + " ";
						}
					}
				} else if (condition.equals("<")) {
					for (int i = 0; i < this.counter; i++) {
						if (intArr[i] < intVal) {
							// do nothing
						} else {
							removed += intArr[i] + " ";
						}
					}
				} else if (condition.equals(">=")) {
					for (int i = 0; i < this.counter; i++) {
						if (intArr[i] >= intVal) {
							// do nothing
						} else {
							removed += intArr[i] + " ";
						}
					}
				} else if (condition.equals("<=")) {
					for (int i = 0; i < this.counter; i++) {
						if (intArr[i] <= intVal) {
							// do nothing
						} else {
							removed += intArr[i] + " ";
						}
					}
				} else if (condition.equals("!=")) {
					for (int i = 0; i < this.counter; i++) {
						if (intArr[i] != intVal) {
							// do nothing
						} else {
							removed += intArr[i] + " ";
						}
					}
				} else {
					System.out.println("Condition invalid!");
					return;
				}
			}

			System.out.println(removed);
		}

	}

	public static void main(String[] args) {

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
			ls.removeAll(x, condition, elemType);

		} else if (elemType.equals("Numeric")) {

			Integer[] arr = new Integer[numElements];
			List ls = new List(arr);

			for (int i = 0; i < numElements; i++) {

				ls.insert(i, input.nextInt());

			}

			String condition = input.next();
			Integer x = input.nextInt();
			input.close();
			ls.removeAll(x, condition, elemType);

		} else {

			System.out.println("Unrecognized data type!");
			input.close();
			return;

		}
	}
}