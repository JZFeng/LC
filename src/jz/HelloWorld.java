package jz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import jz.BinarySearchTree.TreeNode;
import jz.DoubleLinkedList.ListNode;

public class HelloWorld {
	
	public static class Person implements Comparable<Object>{
		public String name;
		public int age;
		public int salary;
		
		Person(String name, int age, int salary){
			this.name = name;
			this.age = age;
			this.salary = salary;
		}

		public int getAge(){
			return this.age;
		}
		
		@Override
		public int compareTo(Object o) {
			if(o instanceof Person){
				return ((Person) o).salary - this.salary;
			}
			return -1;
		}
		
		public  String toString(){
			return "Name: " + this.name + " ; Age:" + this.age  +  " ; Salary: " + this.salary ;
			
		}
		
		
	}
    
	public static void main(String[] args) {
		TreeMap<Person, Integer> tm = new TreeMap<Person, Integer>();
		tm.put(new Person("jz",20,5000), 1);
		tm.put(new Person("lin", 18, 2000),2);
		tm.put(new Person("xiliang", 50,10000),3);
		tm.put(new Person("yongjun", 24, 8000),4);
		for(Map.Entry<Person, Integer> entry : tm.entrySet() ){
			System.out.println(entry.getKey().toString() +"  ;   " +entry.getValue());
		}
	}
	
    
}
