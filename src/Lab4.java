package lab4;

public class Lab4 {

	/*
	 * (19), 91, 7, 17, 9, 12, 1, 20 91, 7, 17, \ (19) \ 9, 12, 1, 20 (91), 7,
	 * 17, /19/ (9), 12, 1, 20 (7) , 17 / 91 /19/
	 */

	static int[] data = new int[] { 19, 91, 7, 17, 9, 12, 1, 20 };
	static int[] temp = new int[7];

	public static void main(String[] args) {
	
		
		
		// 
		
		for (int x : data) {
			System.out.println(x);
		}

	}

	private static void merge(int data[], int temp[], int low, int middle,
			int high) {
		int ri = 0; // result index
		int ti = low;// temp index
		int di = middle;// data index
		int[] result = new int[high - low + 1];
		while (ti < middle && di <= high) {
			if (data[di] < temp[ti]) {
				result[ri++] = data[di++];// smaller is in data
			} else {
				result[ri++] = temp[ti++];// smaller is in temp
			}
		}
		while (ti < middle)
			result[ri++] = temp[ti++];
		while (di <= high)
			result[ri++] = data[di++];
		for (int i = 0; i < high; i++)
			data[low + i] = result[i];
	}

	public static void bubble(int dat[], int n) {
		int numSorted = 0;
		int index;
		while (numSorted < n) {
			for (index = 1; index < n - numSorted; index++) {
				if (data[index - 1] > data[index])
					swap(data, index - 1, index);
			}

			numSorted++;
		}

	}

	private static int partition(int data[], int left, int right)
	// pre: left<= right
	// post: data[left] placed in the correct location
	{
		while (true) {
			// move right "pointer" towards left
			while (left < right && data[left] < data[right])
				right--;
			if (left < right)
				swap(data, left++, right);
			// move left pointer towards right
			while (left < right && data[left] < data[right])
				left++;
			if (left < right)
				swap(data, left, right--);
			else
				return right;
		}
	}

	public static void swap(int data[], int left, int right) {
		int temp = data[left];
		data[left] = data[right];
		data[right] = temp;

	}

}
