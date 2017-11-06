/**
https://leetcode.com/problems/fizz-buzz/#/description

412. Fizz Buzz

Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output "Fizz" instead of the number 
and for the multiples of five output "Buzz".
For numbers which are multiples of both three and five output �FizzBuzz�.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

 */
package jz.Deprecated;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author jzhfeng
 * @date May 12, 2017
 */
public class FizzBuzz
{

    public static void main(String[] args)
    {
        List<String> res = fizzBuzzII(16);
        Iterator<String> itr = res.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

    }

    public static List<String> fizzBuzz(int n)
    {
        List<String> res = new ArrayList<String>();
        if(n <= 0) return null;
        for(int i = 1 ; i <= n; i++)
        {
            if(i%5 == 0 && i%3 ==0) res.add("FizeBuzz");
            else if(i%5 == 0)  res.add("Buzz");
            else if(i%3 == 0 ) res.add("Fizz");
            else res.add(String.valueOf(i));
        }
        
        return res;

    }
    
    public static List<String> fizzBuzzII(int n)
    {
        List<String> res = new ArrayList<String>();
        if (n <= 0)
            return null;

        int c1 = 1;
        int c2 = 1;
        for (int i = 1; i <= n; i++)
        {
            if (c1 == 3 && c2 == 5)
            {
                res.add("FizzBuzz");
                c1 = 0;
                c2 = 0;
            }
            else if (c1 == 3)
            {
                res.add("Fizz");
                c1 = 0;
            }
            else if (c2 == 5)
            {
                res.add("Buzz");
                c2 = 0;
            }
            else
                res.add(String.valueOf(i));

            c1++;
            c2++;

        }

        return res;

    }

}
