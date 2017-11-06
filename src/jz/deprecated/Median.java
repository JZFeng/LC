package jz.deprecated;
//http://www.lintcode.com/en/problem/median/

public class Median {

    public static void main(String[] args) {
	int[] nums = new int[] { 4, 5, 1, 2, 3 };
	Median m = new Median();
	int mid = m.median(nums);
	System.out.println(mid);
    }

    public int median(int[] nums) {
	if (nums == null || nums.length == 0) {
	    return Integer.MAX_VALUE;
	}

	int k = (nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1);

	return quickSelect(nums, k, 0, nums.length - 1);
    }

    // find the kth smallest emelement
    private int quickSelect(int[] nums, int k, int start, int end) {
	if (start == end) {
	    return nums[start];
	}
	int left = start;
	int right = end;
	int pivot = nums[left + (right - left) / 2];
	while (left <= right) {
	    while (left <= right && nums[left] < pivot) {
		left++;
	    }
	    while (left <= right && nums[right] > pivot) {
		right--;
	    }
	    if (left <= right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
		left++;
		right--;
	    }
	    // left;
	}
	
	// start + k - 1 stands for the index of Kth smallest element
	if (start + k - 1 <= right) {
	    return quickSelect(nums, k, start, right);
	}
	if (start + k - 1 >= left) {
	    //减去index左边的元素
	    return quickSelect(nums, k - (left - start), left, end);
	}

	return Integer.MAX_VALUE;
    }

}
