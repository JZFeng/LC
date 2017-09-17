package InnerClass;

public class Outer1 {
    private static int i = 1;

    private int j = 10;

    public static void outer_f1() {
    }

    public void outer_f2() {
    }

    // ��̬�ڲ��������public,protected,private����
    // ��̬�ڲ����п��Զ��徲̬���߷Ǿ�̬�ĳ�Ա
    private static class Inner {
	static int inner_i = 100;

	int inner_j = 200;

	static void inner_f1() {
	    // ��̬�ڲ���ֻ�ܷ����ⲿ��ľ�̬��Ա(������̬�����;�̬����)
	    System.out.println("Outer.i" + i);
	    outer_f1();
	}

	void inner_f2() {
	    // ��̬�ڲ��಻�ܷ����ⲿ��ķǾ�̬��Ա(�����Ǿ�̬�����ͷǾ�̬����)
	    // System.out.println("Outer.i"+j);
	    // outer_f2();
	}
    }

    public void outer_f3() {
	// �ⲿ������ڲ���ľ�̬��Ա���ڲ���.��̬��Ա
	System.out.println(Inner.inner_i);
	Inner.inner_f1();
	// �ⲿ������ڲ���ķǾ�̬��Ա:ʵ�����ڲ��༴��
	Inner inner = new Inner();
	inner.inner_f2();
    }

    public static void main(String[] args) {
	new Outer1().outer_f3();
    }
}

/*
 * ����һ����̬�ڲ��಻��Ҫ�ⲿ���Ա�����Ǿ�̬�ڲ���ͳ�Ա�ڲ�������𡣾�̬�ڲ���Ķ������ֱ�����ɣ�
 * Outer.Inner in = new Outer.Inner();������Ҫͨ�������ⲿ����������ɡ�
 * ����ʵ����ʹ��̬�ڲ����Ϊ��һ��������
 * (��������£��㲻���ڽӿ��ڲ������κδ��룬��Ƕ���������Ϊ�ӿڵ�һ���֣���Ϊ����static �ġ�
 * ֻ�ǽ�Ƕ�������ڽӿڵ������ռ��ڣ��Ⲣ��Υ���ӿڵĹ���
 */