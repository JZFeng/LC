package InnerClass;

/*3�������ڲ���
 �����ڲ�����Ϊһ��������ڲ��࣬���˾�����ͨ�ڲ�����ص㣬�����Լ���һЩ�������ԣ�
 �����ڲ��������չһ�������ʵ��һ���ӿڣ����ǲ�������ʽ��extends��implements�Ӿ䣻
 �����ڲ������ʵ�ָ����Լ��ӿ��е����г��󷽷���
 �����ڲ�������ʹ�ø�����޲ι��췽��������ʵ���������ʵ����һ���ӿڣ����乹�췽����Object()��
 �����ڲ������������Ϊ��OuterClass$n.class������n��һ����1��ʼ�������������һ�����ж����˶�������ڲ��࣬
 �������ǵĳ���˳���1��ʼ�źš�
 */
abstract class A {
    abstract public void sayHello();
}

class Outer3 {
    public static void main(String[] args) {
	new Outer3().callInner(new A() {
	    public void sayHello() {
		System.out.println(this); // the object created from the
					  // anonymous Inner
		System.out.println("Hello!");
	    }
	});
    }

    public void callInner(A a) {
	a.sayHello();
    }
}