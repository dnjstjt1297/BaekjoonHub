fun find(code: String):Boolean{
	var trues = Array<Boolean>(code.length,{false})
	trues = is100_1_(code,trues)
	trues = is01(code,trues)
	for(e in trues){
		if(e==false) return false
	}
	return true
}

fun is100_1_(code: String, trues:Array<Boolean>):Array<Boolean>{
	var result = trues
	
	for(i in 0..code.length-3){
		val tmp = code.substring(i,i+3)
		if(tmp!="100") continue
		if(result[i]||result[i+1]||result[i+2]) continue
		var idx = i+3
		while(true){
			if(idx>=code.length) break
			if(code[idx]=='1'){
				for(j in i..idx){
					result[j] = true
				}
				break
			}
			idx++
		}
	}
	for(i in 0..code.length-1){
		if(!result[i]){
			if(i==0) continue
			if(code[i]=='1'&& result[i-1]){
				result[i] = true
			}
		}
	}
	return result
}

fun is01(code: String, trues:Array<Boolean>):Array<Boolean>{
	var result = trues
	
	for(i in 0..code.length-2){
		val tmp = code.substring(i,i+2)
		if(result[i]||result[i+1]) continue
		if(tmp=="01"){
			result[i] = true
			result[i+1] = true
		}
	}
	return result
}

fun main(args:Array<String>)= with(System.`in`.bufferedReader()){
	val input = readLine()
	if(find(input)) println("SUBMARINE")
	else println("NOISE")
}