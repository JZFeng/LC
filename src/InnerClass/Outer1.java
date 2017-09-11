package InnerClass;
public class Outer1
{
    private static int i = 1;

    private int j = 10;

    public static void outer_f1()
    {
    }

    public void outer_f2()
    {
    }

    // 静态内部类可以用public,protected,private修饰
    // 静态内部类中可以定义静态或者非静态的成员
    private static class Inner
    {
        static int inner_i = 100;

        int inner_j = 200;

        static void inner_f1()
        {
            // 静态内部类只能访问外部类的静态成员(包括静态变量和静态方法)
            System.out.println("Outer.i" + i);
            outer_f1();
        }

        void inner_f2()
        {
            // 静态内部类不能访问外部类的非静态成员(包括非静态变量和非静态方法)
            // System.out.println("Outer.i"+j);
            // outer_f2();
        }
    }

    public void outer_f3()
    {
        // 外部类访问内部类的静态成员：内部类.静态成员
        System.out.println(Inner.inner_i);
        Inner.inner_f1();
        // 外部类访问内部类的非静态成员:实例化内部类即可
        Inner inner = new Inner();
        inner.inner_f2();
    }

    public static void main(String[] args)
    {
        new Outer1().outer_f3();
    }
}

/*
 * 生成一个静态内部类不需要外部类成员：这是静态内部类和成员内部类的区别。静态内部类的对象可以直接生成： Outer.Inner in = new Outer.Inner();而不需要通过生成外部类对象来生成。
 * 这样实际上使静态内部类成为了一个顶级类 (正常情况下，你不能在接口内部放置任何代码，但嵌套类可以作为接口的一部分，因为它是static 的。 只是将嵌套类置于接口的命名空间内，这并不违反接口的规则）
 */