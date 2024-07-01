import java.util.Scanner

fun findHeight(N:Int):Int{
	val INF = 100001
	var dp = Array(INF,{0})
	dp[1] = 1
	
	for(i in 2..INF-1){
		dp[i] = dp[i-1]+2*i*i-2*i+1
		
	}
	
	for(i in 0..INF-1){
		if(N<dp[i]){
			return i-1
		}
	}
	return -1
}

fun main(args: Array<String>) = with(System.`in`.bufferedReader()){
	val N = readLine().toInt()
	println(findHeight(N))
}