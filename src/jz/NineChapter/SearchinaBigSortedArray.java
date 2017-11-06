package jz.NineChapter;
/*
 http://lintcode.com/en/problem/search-in-a-big-sorted-array/
 */
class ArrayReader {
	public int get(int i) {
		return 0;
	}
}

public class SearchinaBigSortedArray {
	
	public int searchBigSortedArray(ArrayReader reader, int target) {
		//倍增法
		int start = 0;
		int end = 1;
		while (reader.get(end) < target) {
			end = end * 2;
		}
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (reader.get(mid) >= target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (reader.get(start) == target) {
			return start;
		}
		if (reader.get(end) == target) {
			return end;
		}
		return -1;

	}

}
