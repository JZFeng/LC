package InnerClass;

class Outer2 {
    private int index = 10;

    class Inner {
	private int index = 20;

	void print() {
	    int index = 30;
	    System.out.println(this); // the object created from the Inner
	    System.out.println(Outer2.this); // the object created from the
					     // Outer
	    System.out.println(index); // output is 30
	    System.out.println(this.index); // output is 20
	    System.out.println(Outer2.this.index); // output is 10
	}
    }

    void print() {
	Inner inner = new Inner();// �õ��ڲ��������
	inner.print();
    }

    public static void outer2_f2() {
	Outer2 outer = new Outer2();
	Outer2.Inner in = outer.new Inner();
	/*
	 * Inner inner = outer.new Inner(); inner.print();
	 */

	Outer2 o2 = new Outer2();
	Inner in2 = o2.new Inner();

    }

    public static void main(String[] args) {
	Outer2 outer2 = new Outer2();
	outer2.print();

	Thread t = new Thread(new Runnable() {
	    public void run() {
		System.out.println("Hello");
	    }
	});
    }

}
