package jz.Deprecated;

import java.util.Iterator;
import java.util.List;

//http://lintcode.com/en/problem/zigzag-iterator/

public class ZigzagIterator {
	private List<Integer> v1;
	private List<Integer> v2;
	private Iterator<Integer> i1;
	private Iterator<Integer> i2;
	private boolean v1turn;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.v1 = v1;
		this.v2 = v2;
		i1 = v1.iterator();
		i2 = v2.iterator();
		v1turn = true;
	}

	/*
	 * @return: An integer
	 */
	public int next() {
		int res = Integer.MAX_VALUE;
		if (i1.hasNext() && i2.hasNext()) {
			if (v1turn) {
				res = i1.next();
			} else {
				res = i2.next();
			}
			v1turn = !v1turn;
		} else if (i1.hasNext()) {
			res = i1.next();
			v1turn = true;
		} else {
			res = i2.next();
			v1turn = false;
		}

		return res;
	}

	/*
	 * @return: True if has next
	 */
	public boolean hasNext() {
		// write your code here
		return i1.hasNext() || i2.hasNext();
	}
}

