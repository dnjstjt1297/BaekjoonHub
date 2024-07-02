import java.util.*


fun makeToken(S:String, P:String):String{
	var result = ""
	
	while(result.length<=S.length){
		result+=P
	}
	
	result = result.substring(0,S.length)
	return result
}

fun encode(S:String, token:String, type:Char):String{
	val result = StringBuilder(S)
	for(i in 0..S.length-1){
		var next: Int = S[i].toInt()
		if(S[i]>='a' && S[i]<='z'){
			next -='a'.toInt()
			if(type == 'E') next = (next + token[i].toInt())%('Z'-'A'+1)
			else if( type == 'D') next = (next - token[i].toInt())%('Z'-'A'+1)
			if(next<0) next = ('Z'-'A'+1)+next
			next +='a'.toInt()
		}
		else if(S[i]>='A' && S[i]<='Z'){
			next -='A'.toInt()
			if(type == 'E') next = (next + token[i].toInt())%('Z'-'A'+1)
			else if( type == 'D') next = (next - token[i].toInt())%('Z'-'A'+1)
			if(next<0) next = ('Z'-'A'+1)+next
			next +='A'.toInt()
		}
		
		result.setCharAt(i,next.toChar())
	}
	
	return result.toString()
}


fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
	val T = readLine().toInt()
	for(i in 1..T){
		val S = readLine()
		val st = StringTokenizer(readLine())

		val type = st.nextToken()[0]
		val P = st.nextToken()
		println(encode(S,makeToken(S,P),type))
	}
	
}