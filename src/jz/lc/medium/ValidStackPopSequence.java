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
        int[] output = intArrayfromString("4 3 2 1 0 9 8 7 6 5");
        Util.printArray(output);
        System.out.print(validSequence(input, output)+" : ");
        Util.printArray(output);
        
        
/*        
        String[] outputs = new String[8];
        outputs[0] = "4 3 2 1 0 9 8 7 6 5";
        outputs[1] = "4 6 8 7 5 3 2 9 0 1";
        outputs[2] = "2 5 6 7 4 8 9 3 1 0";
        outputs[3] = "4 3 2 1 0 5 6 7 8 9";
        outputs[4] = "1 2 3 4 5 6 9 8 7 0";
        outputs[5] = "0 4 6 5 3 8 1 7 2 9";
        outputs[6] = "1 4 7 9 8 6 5 3 0 2";
        outputs[7] = "2 1 4 3 6 5 8 7 9 0";
        

        for(String output: outputs)
        {
            int[] outputIntArray = intArrayfromString(output);
            System.out.print(validSequence(input, outputIntArray)+" : ");
            Util.printArray(outputIntArray);
        }   */ 

    }

    public static boolean validSequence(int[] input, int[] sequenc) {
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
