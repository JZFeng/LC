package jz;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Util
{

    public static void main(String[] args) throws IOException
    {
        Random r = new Random();
        int size = 1 + r.nextInt(10);
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = r.nextInt(20);
        }

        int[] b = Arrays.copyOf(a, size);

        System.out.println("Originl Arrays: ");
        printArray(a);
        printArray(b);

        System.out.println("Sorted Arrays: ");
        Arrays.sort(b);
        printArray(b);

        quickSort(a, 0, size - 1);
        printArray(a);
        System.out.println(isEqual(a, b));

    }

    public static void quickSort(int[] a, int low, int high)
    {
        if (a == null || a.length == 0)
            return;

        if (low <= high)
        {
            int q = partition(a, low, high);
            if (low < q)
                quickSort(a, low, q - 1);

            if (high > q)
                quickSort(a, q + 1, high);
        }
    }

    public static int partition(int[] a, int left, int right)
    {
        int i = left;
        int j = right;
        int pivot = a[i];

        while (i < j)
        {
            while (a[i] < pivot)
                i++;
            while (a[j] > pivot)
                j--;

            if (i < j)
            {
                swap(a, i, j);

                if (a[i] == a[j])
                    i++;
            }
        }

        return i;
    }

    public static boolean isEqual(int[] a, int[] b)
    {
        if (a == null && b == null)
            return true;
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != b[i])
                return false;
        }

        return true;
    }

    public static void swap(int[] a, int i, int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void getACard(int n)
    {
        if (n < 1)
            System.exit(1);
        ;

        int[] a = new int[n];
        int size = n;

        for (int i = 0; i < n; i++)
        {
            a[i] = i;
        }

        printArray(a);

        StringBuilder sb = new StringBuilder();
        sb.append("cards delivered: ");

        Random rd = new Random();

        for (int i = 0; i < 10; i++)
        {
            int x = rd.nextInt(size);
            int tmp = a[x];
            sb.append(tmp + " ");
            a[x] = a[size - 1];
            a[size - 1] = tmp;

            size--;
        }

        printArray(a);
        System.out.println("Current size is: " + size);
        System.out.println(sb.toString());
    }

    public static void swap(int a, int b)
    {
        int tmp = a;
        a = b;
        b = tmp;
    }

    public static String inFixtoPostFix(String input)
    {
        String s = "";
        StringBuilder sb = new StringBuilder();
        Stack<String> ops = new Stack<String>();

        for (int i = 0; i < input.length(); i++)
        {
            char tmp = input.charAt(i);
            if (tmp == '(')
            {
                ops.push(String.valueOf(tmp));
            }
            else if (tmp == ')')
            {
                if (s.trim().length() > 0)
                {
                    sb.append(s.trim() + " ");
                    s = "";
                }

                while (!ops.peek().equalsIgnoreCase("("))
                {
                    sb.append(ops.pop() + " ");
                }
                ops.pop();

            }
            else if (isOperator(tmp))
            {
                if (s.trim().length() > 0)
                {
                    sb.append(s.trim() + " ");
                    s = "";
                }

                int p = priorityCal(String.valueOf(tmp));

                if (ops.isEmpty())
                    ops.push(String.valueOf(tmp));
                else if (p > priorityCal(ops.peek()))
                    ops.push(String.valueOf(tmp));
                else
                {
                    while (!ops.isEmpty() && p <= priorityCal(ops.peek()))
                    {
                        sb.append(ops.pop() + " ");
                    }
                    ops.push(String.valueOf(tmp));
                }

            }
            else
            {
                s = s + tmp;
            }

        }

        sb.append(s.trim());

        while (!ops.isEmpty())
        {
            sb.append(ops.pop());
        }

        return sb.toString().trim();
    }

    public static double evaluatePostFix(String input)
    { // 4 8 + 6 5 - * 3 2 - 2 2 + * /
        if (input == null || input.length() == 0)
            return Double.MIN_VALUE;

        Stack<Double> operands = new Stack<Double>();
        String[] tmp = input.split(" ");
        for (int i = 0; i < tmp.length; i++)
        {
            String s = tmp[i];
            if (!isOperator(s))
                operands.push(Double.parseDouble(s));
            else
            {
                Double val;

                if (s.equalsIgnoreCase("+"))
                {
                    val = operands.pop();
                    operands.push(operands.pop() + val);
                }
                else if (s.equalsIgnoreCase("-"))
                {
                    val = operands.pop();
                    operands.push(operands.pop() - val);
                }
                else if (s.equalsIgnoreCase("*"))
                {
                    val = operands.pop();
                    operands.push(operands.pop() * val);
                }
                else if (s.equalsIgnoreCase("/"))
                {
                    val = operands.pop();
                    operands.push(operands.pop() / val);
                }

            }

        }

        return operands.pop().doubleValue();
    }

    private static int priorityCal(String s)
    {
        if (s.equalsIgnoreCase("*") || s.equalsIgnoreCase("/"))
            return 1;
        else if (s.equalsIgnoreCase("+") || s.equalsIgnoreCase("-"))
            return 0;
        else
            return -1;
    }

    private static boolean isOperator(char c)
    {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    private static boolean isOperator(String s)
    {
        return (s.equalsIgnoreCase("+") || s.equalsIgnoreCase("-")
                || s.equalsIgnoreCase("*") || s.equalsIgnoreCase("/"));
    }

    public static String fullExpression(String input)
    {
        String s = "";
        Stack<String> nums = new Stack<String>();
        Stack<String> ops = new Stack<String>();
        for (int i = 0; i < input.length(); i++)
        {
            char tmp = input.charAt(i);

            switch (tmp)
            {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                {
                    s = s + tmp;
                    break;
                }

                case '+':
                case '-':
                case '*':
                case '/':
                {
                    ops.push(String.valueOf(tmp));
                    if (s.trim().length() > 0)
                    {
                        nums.push(s);
                        s = "";

                    }
                    break;
                }

                case ')':
                {
                    if (s.trim().length() > 0)
                    {
                        nums.push(s);
                        s = "";

                    }
                    String a = " " + ops.pop() + " " + nums.pop() + " )";
                    a = "( " + nums.pop() + a;
                    nums.push(a);
                    break;
                }

                default:
                    break;
            }

        }
        return nums.pop();
    }

    // sky is blue
    public static String reverseWord(String s)
    {
        String[] a = s.split(" ");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < a.length; i++)
        {
            stack.push(a[i]);
        }

        while (!stack.isEmpty())
        {
            sb.append(stack.pop() + " ");
        }

        return sb.toString();
    }

    private static void printBinary(int n)
    {
        Stack<Integer> stack = new Stack<Integer>();
        while (n > 0)
        {
            stack.push(n % 2);
            n = n / 2;
        }
        while (!stack.isEmpty())
        {
            System.out.print(stack.pop() + " ");
        }
    }

    public static int count(int key, int[] a, int low, int high)
    {
        if (a == null || a.length == 0)
            return 0;

        if (low > high)
            return 0;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (key > a[mid])
            {
                low = mid + 1;
            }
            else if (key < a[mid])
            {
                high = mid - 1;
            }
            else
            {
                return 1 + count(key, a, low, mid - 1) + count(key, a, mid + 1, high);
            }

        }

        return 0;

    }

    public static int rankLT(int key, int[] a)
    {
        if (key > a[a.length - 1])
            return a.length - 1;

        else if (key < a[0])
            return -1;

        int low = 0;
        int high = a.length - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (key == a[mid])
                high = mid - 1;
            else if (key > a[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return high;
    }

    public static int rankGT(int key, int[] a)
    {
        if (key < a[0])
            return 0;
        else if (key > a[a.length - 1])
            return -1;

        int low = 0;
        int high = a.length - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (key == a[mid])
            {
                low = mid + 1;
            }
            else if (key < a[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    public static int binarySearch(int key, int[] a)
    {
        if (a == null || a.length == 0)
            return -1;

        int low = 0;
        int high = a.length - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (key < a[mid])
            {
                high = mid - 1;
            }
            else if (key > a[mid])
            {
                low = mid + 1;
            }
            else
                return mid;
        }
        return -1;
    }

    public static int binarySearch(int key, int[] a, int low, int high)
    {
        if (a == null || a.length == 0)
            return -1;
        if (low > high)
            return -1;
        else
        {
            int mid = low + (high - low) / 2;
            if (key < a[mid])
                return binarySearch(key, a, 0, mid - 1);
            else if (key == a[mid])
            {
                return mid;
            }
            else
            {
                return binarySearch(key, a, mid + 1, high);
            }
        }

    }

    public static long lnPro(long n)
    {
        if (n < 2)
            return 0;
        else
            return (long) (Math.log(n) + lnPro(n - 1));
    }

    public static long f(long n)
    {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * f(n - 1);
    }

    public static long f1(long n)
    {
        long result = 1;
        long i = 1;
        while (i <= n)
        {
            result = result * i;
            i++;
        }
        return result;
    }

    public static long fib(int n)
    {
        if (n == 0 || n == 1)
            return n;
        else
        {
            long pre0 = 0;
            long pre1 = 1;
            long i = 2;
            while (i <= n)
            {
                long tmp = pre1;
                pre1 = pre0 + pre1;
                pre0 = tmp;
                i++;
            }
            return pre1;
        }
    }

    public static long[] fab(int n)
    {
        long[] a = null;
        if (n < 0)
            System.exit(1);
        else if (n == 0)
            a = new long[]
            { 0 };
        else if (n == 1)
            a = new long[]
            { 0, 1 };
        else
        {
            a = new long[n + 1];
            a[0] = 0;
            a[1] = 1;

            int i = 2;
            while (i <= n)
            {
                a[i] = a[i - 1] + a[i - 2];
                i++;
            }

        }
        return a;
    }

    public static long fibonacci(int n)
    {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int[] insertSort(int[] a)
    {

        if (a == null || a.length == 0)
            throw new IllegalArgumentException("Array is empty.");

        for (int i = 1; i < a.length; i++)
        {

            int key = a[i];
            int j = i - 1;
            for (; j >= 0; j--)
            {
                if (key < a[j])
                {
                    a[j + 1] = a[j];

                }

            }

            a[j + 1] = key;
        }

        return a;
    }

    public static int[] bubbleSort(int[] a)
    {

        if (a == null || a.length == 0)
            throw new IllegalArgumentException("Array is empty.");

        for (int i = 0; i < a.length; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] > a[j])
                {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }

        return a;
    }

    public static void printArray(int[] a)
    {
        if (a == null || a.length == 0 )
        {
            System.out.println("Empty Array");
            return;
        }
            

        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] a, int i, int j)
    {
        if (a.length == 0 || a == null)
            System.out.println("Empty Array");

        while (i <= j)
        {
            System.out.print(a[i] + " ");
            i++;
        }
        System.out.println();
    }

    
}
