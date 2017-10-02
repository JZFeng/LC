package jz.tree.segment;

import java.util.ArrayList;

public class STN {
    public int start, end;
    public Long sum;
    public STN left, right;

    public STN(int start, int end, Long sum) {
	this.start = start;
	this.end = end;
	this.sum = sum;
	this.left = this.right = null;
    }

    public STN build(int start, int end, int[] A) {
	// write your code here
	if (start > end) { // check core case
	    return null;
	}

	STN root = new STN(start, end, 0L);

	if (start != end) {
	    int mid = (start + end) / 2; // start + (start -end) / 2; ??
	    root.left = build(start, mid, A);
	    root.right = build(mid + 1, end, A);

	    root.sum = root.left.sum + root.right.sum;// root.max =
						      // Math.max(root.left.max
						      // , root.right.max);
	} else {
	    root.sum = Long.valueOf(A[start]);

	}
	return root;
    }

    public Long query(STN root, int start, int end) {
	// write your code here
	if (start == root.start && root.end == end) { // 相等
	    return root.sum;
	}

	int mid = (root.start + root.end) / 2;
	Long leftsum = 0L, rightsum = 0L;
	// 左子区
	if (start <= mid) {
	    if (mid < end) { // 分裂
		leftsum = query(root.left, start, mid);
	    } else { // 包含
		leftsum = query(root.left, start, end);
	    }
	}
	// 右子区
	if (mid < end) { // 分裂 3
	    if (start <= mid) {
		rightsum = query(root.right, mid + 1, end);
	    } else { // 包含
		rightsum = query(root.right, start, end);
	    }
	}
	// else 就是不相交
	return leftsum + rightsum;
    }

    public ArrayList<Long> intervalSum(int[] A, ArrayList<Interval> queries) {
	// write your code here
	STN root = build(0, A.length - 1, A);
	ArrayList ans = new ArrayList<Long>();
	for (Interval in : queries) {
	    ans.add(query(root, in.start, in.end));
	}
	return ans;
    }

    public class Interval {
	int start, end;

	Interval(int start, int end) {
	    this.start = start;
	    this.end = end;
	}

    }

}
