import java.util.*


fun rotate(seq: Array<Int>, N:Int, M:Int): Array<Int>{
	var total = 0L
	var start = 0
	for(i in 1..M){
		total+=seq[start]
		start = (start+seq[start])%N
	}
	
	var result = Array(N,{0})
	for(i in 0..N-1){
		var next = (i-total)%N
		if(next<0) next = N+next
		result[next.toInt()] = seq[i]
	}
	
	return result
}


fun main(args: Array<String>) = with(System.`in`.bufferedReader()){
	var st = StringTokenizer(readLine())
	
	val N = st.nextToken().toInt()
	val M = st.nextToken().toInt()
	
	val seq = Array(N,{0})
	
	st = StringTokenizer(readLine())
	for(i in 0..N-1){
		seq[i] = st.nextToken().toInt()
	}
	
	println(rotate(seq,N,M)[0])
	
}