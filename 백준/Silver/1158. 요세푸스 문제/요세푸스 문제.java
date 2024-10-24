import java.util.*;
import java.io.*;

class N<T>{
	T value;
	N<T> next;
	public N(T value) {
		this.value = value;
		next = null;
	}
}

class C<T>{
	N<T> front;
	
	public C() {
		front = null;
	}
	
	public boolean isEmpty() {
		if(front ==null) return true; 
		return false;
	}
	
	public void insert(T value) {
		N<T> node = new N<>(value);
		if(isEmpty()) {
			front=node;
			front.next = node;
		}
		else {
			N<T> cur = front;
			while(cur.next!=front) cur = cur.next;
			cur.next = node;
			node.next = front;
		}
	}
	
	public T delete() {
		if(isEmpty()) return null;
		else {
			T result = front.value;
			N<T> cur = front;
			while(cur.next!=front) cur = cur.next;
			
			if(cur.next==cur) front = null;
			else {
				N<T> old = front;
				cur.next = old.next;
				front = cur.next;
			}
			return result;
		}
		
	}
	
	public boolean move() {
		if(isEmpty()) return false;
		front = front.next;
		return true;
	}
	
}

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		int N = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(st.nextToken());
		
		C<Integer> c = new C<>();
		for(int i=1;i<=N;i++) c.insert(i);
		
		ArrayList<Integer> result = new ArrayList<>();

		int cnt = 0;
		while(!c.isEmpty()) {
			for(int i=0;i<K-1;i++) c.move();
			result.add(c.delete());
		}
		StringBuilder sb = new StringBuilder(result.toString());
		sb.setCharAt(0,'<');
		sb.setCharAt(sb.length()-1,'>');
		
		System.out.println(sb);
	}
}
