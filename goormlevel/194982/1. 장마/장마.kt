import java.util.*

class RainySeason(val N: Int, val M:Int){
	
	val grounds = Array<Int>(N,{0})
	val dGrounds = mutableSetOf<Int>()
	
	fun fillGround(i: Int, height: Int){
		grounds[i] = height
	}
	
	fun rain(s: Int, e:Int){
		for(i in s-1..e-1){
			grounds[i]++
			dGrounds.add(i)
		}
	}
	
	fun drain(day: Int){
		if(day%3!=0) return
		for(g in dGrounds){
			grounds[g]--
		}
		dGrounds.clear()
	}
	
	fun print(){
		for(g in grounds) print("${g} ")
		println()
	}
}



fun main(args: Array<String>) = with(System.`in`.bufferedReader()){
	var st = StringTokenizer(readLine())
	val N = st.nextToken().toInt()
	val M = st.nextToken().toInt()
	val rainySeason = RainySeason(N,M)
	st = StringTokenizer(readLine())
	for(i in 0..N-1) rainySeason.fillGround(i,st.nextToken().toInt())
	
	for(day in 1..M){
		st = StringTokenizer(readLine())
		val start = st.nextToken().toInt()
		val end = st.nextToken().toInt()
		rainySeason.rain(start,end)
		rainySeason.drain(day)
	}
	rainySeason.print()
	
}