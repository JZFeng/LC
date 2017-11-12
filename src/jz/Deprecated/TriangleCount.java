/*
 http://www.lintcode.com/en/problem/triangle-count/
 
 Given an array of integers, how many three numbers can be found in the array, 
 so that we can build an triangle whose three edges length is the three numbers that we find?

Example
Given array S = [3,4,6,7], return 3. They are:

[3,4,6]
[3,6,7]
[4,6,7]
Given array S = [4,4,4,4], return 4. They are:

[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]
  
 */
package jz.Deprecated;

import java.util.Arrays;

import jz.Util;

public class TriangleCount {

	public static void main(String[] args) {
		System.out.println(triangleCount(new int[] { 4, 6, 3, 6, 7 }));

	}

	public static int triangleCount(int nums[]) {
		Arrays.sort(nums);
		Util.printArray(nums);
		int length = nums.length;
		int count = 0;
		for (int i = 0; i < length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < length - 1; j++) {
				while (k < length && nums[i] + nums[j] > nums[k]) {
					k++;
				}
				count = count + (k - j - 1);
			}

		}

		return count;
	}

}
