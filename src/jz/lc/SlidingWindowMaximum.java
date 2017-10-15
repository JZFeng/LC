package jz.lc;

import java.util.ArrayList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

    }
    
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // O(N * K ) double loop to maintain a sliding window;
	ArrayList<Integer> res = new ArrayList<>();
	if(nums == null || nums.length < k) {
	    return res;
	}

	for(int i = 0 ; i < nums.length - k + 1; i++) {
	    int max = Integer.MIN_VALUE;
	    for(int j = 0 ; j < k ; j++) {
		max = Math.max(max,  nums[i + j]);
	    }
	    res.add(max);
	}
	
	return res;
    }
    
    //滑动窗口，添加一个元素，删除一个元素，取最大值；
    //求一个集合中的最大值，想到的数据结构有maxHeap或者平衡树；
    // maxHeap，lgN，O(n), O(1),时间换空间，可以用hashMaxHeap，
    // AVL树，LgN, LgN, LgN;

}
