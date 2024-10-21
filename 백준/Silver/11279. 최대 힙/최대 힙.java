import java.util.*;
import java.io.*;

class Node<T> {
	T value;
	Node<T> next;
	public Node(T value) {
		this.value = value;
		this.next = null;
	}
	
}

class _Queue<T>{
	Node<T> front;
	Node<T> back;
	int size;
	
	public _Queue(){
		front = null;
		back = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return ((front == null && back == null) ? true:false);
	}
	
	public T poll() {
		if(isEmpty()) return null;
		
		Node<T> node = back;
		back = node.next;
		if(back==null) front = null;
		
		size--;
		return node.value;
	}
	
	public void add(T value) {
		Node<T> node = new Node<>(value);
		if(isEmpty()) {
			front = node;
			back = node;
		}
		else {
			front.next = node;
			front = node;
		}
		size++;
	}
	
}

class _Stack<T> {
	Node<T> head;
	int size;
	
	public _Stack(){
		head = null;
		size = 0;
	}
	
	
	public boolean isEmpty() {
		return (head==null?true:false);
	}
	
	public T pop() {
		if(isEmpty()) return null;
		
		Node<T> node = head;
		head = head.next;
		
		size--;
		
		return node.value;
	}
	
	public void push(T value) {
		Node<T> node = new Node<>(value);
		if(isEmpty()) head = node;
		else {
			node.next = head;
			head = node;
			
		}
		
		size++;
	}
}

class MaxHeap{
	int[] heap;
	int size;
	
	public MaxHeap(int len) {
		this.heap = new int[len+1];
		size = 0;
	}
	
	public void add(int value) {
		if(size>heap.length) return;

		size++;
		heap[size] = value;
		
		int pos = size;
		while(pos/2>0) {
			int child = heap[pos];
			int parent = heap[pos/2];
			
			if(child<=parent) break;
			heap[pos] = parent;
			heap[pos/2] = child;
			pos /=2;
		}
		
	}
	
	public int remove() {
		if(size==0) return 0;
		
		int result = heap[1];
		
		heap[1] = heap[size];
		size--;
		
		int pos = 1;
		while(pos*2<=size) {
			int parent = heap[pos];
			int child = heap[pos*2];
			int nextPos = pos*2;
			
			if(pos*2+1<=size) {
				if(child<heap[pos*2+1]) {
					child = heap[pos*2+1];
					nextPos = pos*2+1;
				}
			}
			
			
			if(child<=parent) break;
			heap[pos] = child;
			heap[nextPos] = parent;
			
			pos = nextPos;
		}
		
		return result;
	}
	
	
	
}


public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		MaxHeap mh = new MaxHeap(100000);
		for(int i=0;i<n;i++) {
			int m = Integer.parseInt(br.readLine());
			if(m==0) {
				System.out.println(mh.remove());
			}
			else mh.add(m);
		}
		

	}
}