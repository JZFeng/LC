/*
 https://www.sigmainfy.com/blog/interview-question-6-validate-pop-sequence-of-stack.html
  
[Question] Push and Pop Sequences of Stacks

Given two integer sequences, one of which is the push sequence of a stack, 
please check whether the other sequence is a corresponding pop sequence or not.

For example, if 1, 2, 3, 4, 5 is a push sequence, 
4, 5, 3, 2, 1 is a corresponding pop sequence, 
but the sequence 4, 3, 5, 1, 2 is not.

Answer: http://www.shuati123.com/blog/2015/01/26/Push-and-Pop-Sequences-Stacks/

 */
package jz.lc.medium;

import java.util.Stack;

import jz.Util;

public class ValidStackPopSequence
{

    public static void main(String[] args)
    {
        int[] input = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] output = intArrayfromString("4 3 2 1 0 8 9 7 5 6");
        System.out.print(validSequence(input, output));

    }
    
    public static boolean validSequence(int[] input, int[] output) {
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        //search output[j] in the stack.
        while(j < output.length)
        {
            if(stack.isEmpty())
                stack.push(input[i++]);
            else
            {
                if(stack.peek() == output[j])
                {
                    stack.pop();
                    j++;
                }
                else
                {
                    if(i == input.length)
                        return false;
                    else
                        stack.push(input[i++]);
                }
            }
        }
        
        return true;
    }
    
    
    
    private static int[] intArrayfromString(String s)
    {
        String[] nums = s.trim().split("\\s{1,}");
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            res[i] = Integer.valueOf(nums[i]);

        return res;
    }

 

}
