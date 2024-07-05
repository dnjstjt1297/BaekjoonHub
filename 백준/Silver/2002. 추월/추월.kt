import java.util.*

class Tunnel(private val N: Int){
	private val ins: Map<Int,String>
	private val outs: Map<Int,String>
	
	init{
		ins = mutableMapOf()
		for(i in 0..N-1){
			val car = readLine()!!
			ins.put(i,car)
		}
		
		outs = mutableMapOf()
		for(i in 0..N-1){
			val car = readLine()!!
			outs.put(i,car)
		}
	}
	
	fun find():Int{
		var i = 0
		val overTaking = mutableListOf<String>()
		
		outs.forEach{
			while(true) {
				if(ins[it.key-i] in overTaking)
					i--
				else break
			}
			if(it.value != ins[it.key-i]){
				i++
				overTaking.add(it.value)
			}
		}
		
		return overTaking.size
	}
}

fun main(args: Array<String>){
	val N = readLine()!!.toInt()
	val tunnel = Tunnel(N)
	println(tunnel.find())
	
	
}

