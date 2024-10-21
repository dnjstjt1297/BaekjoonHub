import java.util.*;
import java.io.*;

class Node<T>{
	T value;
	Node<T> next;
	
	public Node(T value) {
		this.value = value;
		next = null;
	}
}

class _Queue<T>{
	Node<T> front, back;
	int size = 0;
	
	public _Queue(){
		front = null;
		back = null;
	}
	
	public boolean isEmpty() {
		if(front ==null && back == null) return true;
		else return false;
	}
	
	public T poll() {
		if(isEmpty()) return null;
		
		Node<T> node = back;
		T result = node.value;
		back = back.next;
		if(back==null) front = null;
		
		size--;
		return result;
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

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		System.out.println(findLastNum(N));
		
	}
	public static int findLastNum(int N) {
		_Queue<Integer> q = new _Queue<>();
		
		for(int i=1;i<=N;i++) q.add(i);
		
		int cnt = 0;
		while(q.size>1) {
			int cur = q.poll();
			if(cnt%2==1) q.add(cur);
			cnt++;
		}
		
		int result = -1;
		if(!q.isEmpty()) result = q.poll();
		return result;
	}
}
