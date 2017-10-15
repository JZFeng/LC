package jz.lc;

import java.util.*;

public class DataStreamMedian {

    public static void main(String[] args) {

    }

    public int[] medianII(int[] nums) {
	// write your code here
	if (nums == null || nums.length <= 1) {
	    return nums;
	}

	int[] res = new int[nums.length];
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
	    public int compare(Integer i1, Integer i2) {
		return i2 - i1;
	    }
	});

	PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	for (int i = 0; i < nums.length; i++) {
	    maxHeap.offer(nums[i]);
	    minHeap.offer(maxHeap.poll());
	    if (maxHeap.size() < minHeap.size()) {
		maxHeap.offer(minHeap.poll());
	    }

	    res[i] = maxHeap.peek();
	}

	return res;
    }

}
