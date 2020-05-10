package array.practice;

public class MinimumSwap {

	private static int minimumSwap(int[] numbers) {
		int ans = 0;
		for(int i = 0 ; i < numbers.length; i++) {
			while(numbers[i] != i + 1) {
				int temp = numbers[numbers[i] - 1];
				numbers[numbers[i] - 1] = numbers[i];
				numbers[i] = temp;
				ans++;
			}
		}
	
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(minimumSwap(new int[] {4,3,1,2}));
	}

}
