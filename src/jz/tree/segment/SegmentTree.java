package jz.tree.segment;

class SegmentTreeNode {
    int start;
    int end;
    SegmentTreeNode left;
    SegmentTreeNode right;
    
    SegmentTreeNode(int start, int end) {
	this.start = start;
	this.end = end;
	this.left = null;
	this.right = null;
    }
}

public class SegmentTree {
    SegmentTreeNode root ;
    
    public static void main(String[] args) {
	SegmentTree st = new SegmentTree(1,10);
	System.out.println(st);
    }
    
    SegmentTree() {
	root = null;
    }
    
    SegmentTree(int start, int end) {
	this.root = build(start, end);
    }
    public SegmentTreeNode build(int start, int end) {
	if(start > end) {
	    return null;
	}
	
	SegmentTreeNode root = new SegmentTreeNode(start, end);
	
	if(start != end) {
	    int mid = (start + end ) / 2;
	    root.left = build(start, mid);
	    root.right = build(mid + 1, end);
	}
	
	return root;
    }
}
