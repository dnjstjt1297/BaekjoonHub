import java.util.*

class LadderGame(val k: Int,val n: Int, val gameResult: String){

    private val ladder = Array(n,{Array(k-1,{'-'})})
    private var anonymousLadderIdx = 0
    private var result = StringBuilder("x".repeat(k-1))


    fun fill(col:Int,row :Int, entry : Char){
        ladder[col][row] = entry
        if(ladder[col][row] == '?') anonymousLadderIdx = col
    }

    fun move(person: Int):Boolean{
        var level = 0
        var loc: Int = person
        while(level<n){
            when(loc){
                0-> {
                    if(ladder[level][loc]=='-') loc++
                }
                k-1-> {
                    if(ladder[level][loc-1]=='-') loc--
                }
                else -> {
                    if(ladder[level][loc]=='-') loc++
                    else if(ladder[level][loc-1]=='-') loc--
                }
            }
            level++
        }
        if(person != gameResult[loc]-'A')
            return false
        return true;
    }


    fun play(idx:Int){
        if(idx>=k-1){
            for(i in 0..k-1){
                if(!move(i)) return
            }
            for(i in 0..k-2)
                result[i] = ladder[anonymousLadderIdx][i]
            return
        }
        if(idx==0||ladder[anonymousLadderIdx][idx-1] != '-') {
            ladder[anonymousLadderIdx][idx] = '-'
            play(idx + 1)
        }
        ladder[anonymousLadderIdx][idx] = '*'
        play(idx+1)
    }

    fun printAnonumousLadder() {
        println(result.toString())
    }
}

fun main(arg: Array<String>) = with(System.`in`.bufferedReader()) {
    val k = readLine().toInt()
    val n = readLine().toInt()
    val ladderGame = LadderGame(k,n,readLine())

    for(i in 0..n-1){
        val ladder = readLine()
        for(j in 0..k-2){
            ladderGame.fill(i,j,ladder[j])
        }
    }
    ladderGame.play(0)
    ladderGame.printAnonumousLadder()
}



