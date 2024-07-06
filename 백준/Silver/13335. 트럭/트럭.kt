import java.util.*

class Bridge(val N:Int, val W:Int, val L:Int, val trucks:List<Int>){
	val bridge:MutableList<Int>
	var next = 0
	
	init{
		bridge = MutableList(W,{0})
	}
	
	fun run():Int{
		var time = 0
		
		while(next<N){
			var maxWeight = findMaxWeight()
			var nextTruck = findNextTruck(maxWeight)
			moveTruck(nextTruck)
			
			time++
		}
		
		var remain = W
		run loop@{
			bridge.reversed().forEach{
				if(it==0)	remain--
				else if(it!=0) return@loop
			}
		}
		
		time+=remain
		
		return time
	}
	
	fun moveTruck(truck:Int){
		bridge.removeAt(0)
		bridge.add(0)
		addTruck(truck)
	}
	
	fun addTruck(truck:Int){
		if(truck==0) return
		bridge[W-1] = truck
	}
	
	fun findMaxWeight():Int{
		var result = L
		for(i in 1..W-1){
			result -= bridge[i]
		}
	
		return result
	}
	
	fun findNextTruck(maxWeight:Int): Int{
		if(trucks[next]<=maxWeight){
			next++
			return trucks[next-1]
		}
		return 0
	}
	
}

fun main(){
	val (N,W,L) = readLine()!!.split(" ").map{it.toInt()}
	val trucks = readLine()!!.split(" ").map{it.toInt()}
	val bridge = Bridge(N,W,L,trucks)
	println(bridge.run())
}