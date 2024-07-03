import java.util.*


fun run(words:List<String>, puzzles:List<String>){
	for(puzzle in puzzles){
		find(getWords(words,puzzle),puzzle)
	}
}

fun find(words: List<String>, puzzle:String){
	
	
	
	val cnts = Array(9,{0})
	
	var max = 0
	var min = 200000
	for(i in 0..8){
		for(word in words){
			for(w in word){
				if(puzzle[i] == w){
					cnts[i]++
					break
				}	
			}
		}
	}
	for(i in cnts){
		max = Math.max(i,max)
		min = Math.min(i,min)
	}
	
	var fool = mutableSetOf<Char>()
	var smart = mutableSetOf<Char>()
	
	for(i in 0..8){
		if(cnts[i] == max){
			fool.add(puzzle[i])
		}
		if(cnts[i] == min){
			smart.add(puzzle[i])
		}
	}
	val nfool = fool.sorted()
	val nsmart = smart.sorted()
	
	
	print(nsmart,min,nfool,max)
}

fun print(smart:List<Char>, n:Int, fool:List<Char>, m:Int){
	var s = ""
	for(e in smart){
		s+=e
	}
	
	var f = ""
	for(e in fool){
		f+=e
	}
	
	println("${s} ${n} ${f} ${m}")
}

fun getWords(words: List<String>,puzzle:String):List<String>{
	val result = mutableListOf<String>()
	
	for(word in words){
		val visited = Array(9,{false})
		var isAdd = true
		for(w in word){
			var isP = false
			for(i in 0..8){
				if(visited[i]) continue
				if(puzzle[i]==w){
					visited[i] = true
					isP = true
					break
				}
			}
			if(!isP) {
				isAdd = false
				break
			}
		}	
		if(isAdd) result.add(word)
	}
	
	return result
}

fun main(args: Array<String>)=with(System.`in`.bufferedReader()) {
	val words = mutableListOf<String>()
	val puzzles = mutableListOf<String>()
	
	while(true){
		val word = readLine()
		if(word == "-") break
		words.add(word)
	}
	
	while(true){
		val puzzle = readLine()
		if(puzzle == "#") break
		puzzles.add(puzzle)
	}
	run(words,puzzles)
}
