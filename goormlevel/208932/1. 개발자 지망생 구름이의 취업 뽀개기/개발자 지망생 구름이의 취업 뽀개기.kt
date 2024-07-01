import java.util.*

val levels = Array<Int>(5,{0})
val map: MutableMap<Int,MutableList<Int>> = mutableMapOf()

fun calTime(): Int{
	var result = 0
	var preTime = 0
	for((level,value) in map){
		for(i in 0..levels[level]-1){
			val time = value[i]
			var wait = time-preTime
			if(i==0){
				if(level==0) wait = 0
				else wait = 60
			}
			result+=wait+time
			preTime = time
		}
	}
	return result
}

fun sortMap(){
	for((level,value) in map){
		value.sort()
	}
}

fun main(args: Array<String>)=with(System.`in`.bufferedReader()) {
	val N = readLine().toInt()
	var st = StringTokenizer(readLine())
	for(i in 0..4){
		levels[i] = st.nextToken().toInt()
	}
	
	for(i in 1..N){
		st = StringTokenizer(readLine())
		val level = st.nextToken().toInt()-1
		val time = st.nextToken().toInt()
		if(map.contains(level))
			map.getOrDefault(level,mutableListOf()).add(time)
		else
			map.put(level,mutableListOf(time))
	}
	sortMap()
	println(calTime())
}

