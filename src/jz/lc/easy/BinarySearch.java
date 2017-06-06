package jz.lc.easy;

public class BinarySearch
{

    public static void main(String[] args)
    {
        

    }
    
    public static int binarySearch(int[] a, int key)
    {
        if(a == null || a.length == 0) return -1;
        
        int left = 0 ; int right = a.length -1;
        while(left <= right)
        {
            int mid = left + (right - left) /2 ;
            if(a[mid] == key) return mid;
            else if(a[mid] > key) right = mid -1;
            else left = mid + 1;
        }
        
        return -1;
    }

    public static int binarySearch(int key, int[] a, int low, int high) {
		if (a == null || a.length == 0)
			return -1;
		if (low > high)
			return -1;
		else {
			int mid = low + (high - low) / 2;
			if (key < a[mid])
				return binarySearch(key, a, 0, mid - 1);
			else if (key == a[mid]) {
				return mid;
			} else {
				return binarySearch(key, a, mid + 1, high);
			}
		}

	}


}
