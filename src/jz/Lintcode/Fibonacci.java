package jz.Lintcode;

public class Fibonacci
{
    //斐波那契数列定义 1,1,2,3,5,8....  n>1  -> f(n) = f(n-1) + f(n-2);
    public static void main(String[] args)
    {
        System.out.println(fibIII(45));
        System.out.println(fibII(45));
        System.out.println(fib(45));

    }

    public static int fib(int n)
    {
        if(n == 0 || n == 1) 
            return n;
        
        return fib(n-1) + fib(n-2);
    }
    
    public static int fibII(int n)
    {
        int[] res = new int[n+2];

        if(n >= 0)
            res[0] =0;
        if(n >=1)
            res[0] = 1;
        for(int i = 2; i <= n+1 ; i++)
        {
                res[i] = res[i-1]+res[i-2];
        }
        return res[n+1];
        
    }
    
    //save space
    public static int fibIII(int n)
    {
        int[] res = new int[2];

        if(n >= 0)
            res[0] =0;
        if(n >=1)
            res[0] = 1;
        
        int index = 0;
        for(int i = 2; i <= n+1 ; i++)
        {
            index = i&1; //i&1 = i%2; i^1 -->0->1, 1->0. 取反。 
            res[index] = res[index]+res[index ^1];
        }
        return res[index];
    }
    
    
	public static long fibIIII(int n) {
		if (n == 0 || n == 1)
			return n;
		else {
			long pre0 = 0;
			long pre1 = 1;
			long i = 2;
			while (i <= n) {
				long tmp = pre1;
				pre1 = pre0 + pre1;
				pre0 = tmp;
				i++;
			}
			return pre1;
		}
	}
}
