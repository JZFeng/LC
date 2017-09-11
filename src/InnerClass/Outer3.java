package InnerClass;

/*3、匿名内部类
 匿名内部类作为一种特殊的内部类，除了具有普通内部类的特点，还有自己的一些独有特性：
 匿名内部类必须扩展一个基类或实现一个接口，但是不能有显式的extends和implements子句；
 匿名内部类必须实现父类以及接口中的所有抽象方法；
 匿名内部类总是使用父类的无参构造方法来创建实例。如果是实现了一个接口，则其构造方法是Object()；
 匿名内部类编译后的命名为：OuterClass$n.class，其中n是一个从1开始的整数，如果在一个类中定义了多个匿名内部类，
 则按照他们的出现顺序从1开始排号。
 */
abstract class A
{
    abstract public void sayHello();
}

class Outer3
{
    public static void main(String[] args)
    {
        new Outer3().callInner(new A()
        {
            public void sayHello()
            {
                System.out.println(this); // the object created from the anonymous Inner
                System.out.println("Hello!");
            }
        });
    }

    public void callInner(A a)
    {
        a.sayHello();
    }
}