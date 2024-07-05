import java.util.*

class StableStr(val str: String){
	val stack = Stack<Char>()
	
	fun minusStable(){	
		str.forEach{
			if(it=='{') stack.push(it)
			if(it=='}'){
				if(stack.isEmpty()) {
					stack.push(it)
				}
				else{
					val a = stack.pop()
					if(a == '}'){
						stack.push(a)
						stack.push(it)
					}
				}
			}
		}
	}
	
	fun run():Int{
		minusStable()
		var result = 0
		for(i in 0..stack.size-1 step 2){
			if(stack.pop()==stack.pop()) result++
			else result+=2
		}
		return result
	}
}

fun main(args: Array<String>){
	var i = 1
	while(true){
		val input = readLine()!!
		if('-' in input) break
		val stableStr = StableStr(input)
		
		println("${i++}. ${stableStr.run()}")
	}
}