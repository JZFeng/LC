/**
 https://leetcode.com/problems/merge-intervals/#/description
 
 56. Merge Intervals
 
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 
 *
 */
package jz.lc;

import java.util.List;

/**
 *@author jzhfeng
 *@date May 10, 2017
 */
public class MergeIntervals
{

    public static void main(String[] args)
    {

    }

    public List<Interval> merge(List<Interval> intervals)
    {
        return intervals;

    }

    public class Interval
    {
        int start;

        int end;

        Interval()
        {
            start = 0;
            end = 0;
        }

        Interval(int s, int e)
        {
            start = s;
            end = e;
        }
    }

}
