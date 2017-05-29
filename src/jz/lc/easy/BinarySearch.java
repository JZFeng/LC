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

}
