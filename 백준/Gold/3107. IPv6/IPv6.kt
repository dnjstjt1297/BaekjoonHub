

class Restore(val str:String){
	val oldIPv6 : MutableList<String>
	val IPv6 : MutableList<String>
	
	init{
		IPv6 = MutableList(8,{"0000"})
		oldIPv6 = mutableListOf()
		str.split(":").forEach{oldIPv6.add(it)}
	}
	
	fun fill(){
		run breaker@{
			oldIPv6.forEachIndexed{i,it->
				if(it!="") IPv6[i] = makeIp(it)
				else return@breaker
			}
		}
		run breaker@{
			oldIPv6.reversed().forEachIndexed{i,it->
				if(it!="") IPv6[7-i] = makeIp(it)
				else return@breaker
			}
		}
	}
	
	fun makeIp(ip: String):String{
		var result = ("0000"+ip)
		result = result.substring(result.length-4,result.length)
		return result
	}
	
	fun print(){
		println(IPv6.joinToString(":"))
	}
}

fun main(){
	val input = readLine()!!
	val restore = Restore(input)
	restore.fill()
	restore.print()
}