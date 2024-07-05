import java.util.*

class Carculator(val input:String){
	val nums:MutableList<Int>
	
	init{
		nums = mutableListOf()
		
		input.split("-").forEach{ 
			var tmp = 0
			it.split("+").forEach{tmp+=it.toInt()}
			nums.add(tmp)
		}
	}
	
	fun carculate(): Int{
		var result = nums[0]
		for(i in 1..nums.size-1){
			result-=nums[i]
		}
		return result
	}
	
}

fun main(args: Array<String>){
	val input = readLine()
	val carcul = Carculator(input!!)
	println(carcul.carculate())
	
}