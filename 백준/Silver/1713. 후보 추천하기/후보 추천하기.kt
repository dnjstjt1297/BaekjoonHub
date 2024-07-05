data class Photo(
	var num:Int,
	var count: Int,
	var time:Int
): Comparable<Photo>{
	override fun compareTo(o: Photo):Int{
		if(this.count==o.count){
			return o.time-this.time
		}
		return this.count-o.count
	}
}

class Recommended(val N:Int,val nums: List<Int>){
	var frames:MutableList<Photo>
	
	init{
		frames = MutableList(N,{ Photo(0,0,0)})
	}
	
	fun recommend(){
		nums.forEach{
			addPhoto(it)
			flowTime()
		}
		frames.sortBy{it.num}
	}
	
	fun addPhoto(num:Int){
		frames.forEach{
			if(it.num == num){
				it.count++
				return
			}
		}
		frames.forEach{
			if(it.num == 0){
				it.num = num
				it.count=1
				it.time=0
				return
			}
		}
		frames.sort()
		frames[0] = Photo(num,1,0)
	}
	
	fun flowTime(){
		frames.forEach{ if(it.num!=0) it.time++}
	}
	
	fun print(){
		frames.forEach{ if(it.num!=0) print("${it.num} ") }
		println()
	}
	
}

fun main(){
	val N = readLine()!!.toInt()
	val M = readLine()!!.toInt()
	
	val nums = readLine()!!.split(" ").map{it.toInt()}
	
	val recommended = Recommended(N,nums)
	recommended.recommend()
	recommended.print()
}