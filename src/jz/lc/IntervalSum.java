package jz.lc;

import java.util.ArrayList;

import jz.Util;

public class IntervalSum {

	public static void main(String[] args) {
		int[] A = new int[]{1,2,7,8,5};
		ArrayList<Interval> queries = new ArrayList<>();
		queries.add(new Interval(0,4));
		queries.add(new Interval(1,2));
		queries.add(new Interval(2,4));
		ArrayList<Long> ans = intervalSum(A, queries);
		System.out.println(ans);

		
	}

	public static ArrayList<Long> intervalSum(int[] A, ArrayList<Interval> queries) {

        // write your code here
        ArrayList<Long> ans = new ArrayList<>();
        long[] intervalSum = new long[A.length];
        Util.printArray(A, 0, A.length -1);
        
        int sum = 0;
        for(int i = 0 ; i < A.length; i++){
            sum += A[i];
            intervalSum[i] = sum;
        }
        for(Interval interval: queries){
        	if(interval.start >= 1){
        		ans.add(intervalSum[interval.end] - intervalSum[interval.start - 1]);
        	}
        	else{
        		ans.add(intervalSum[interval.end] - 0);
        	}
        		
        }
        
        return ans;
    
	}

	public static class Interval {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}