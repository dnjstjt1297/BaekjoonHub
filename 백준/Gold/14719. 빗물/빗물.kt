import java.util.*

enum class BStauts(val c:Char){
    NONE(' '),FILL('B'),RAIN('R')
}

class Block(H: Int,W:Int) {
    private val H = H
    private val W = W
    private var block = Array(H,{Array<BStauts>(W,{BStauts.NONE})})

    fun makeBlock(heights: Array<Int>){
        for(i in 0..heights.size-1){
            for(j in 0.. heights[i]-1){
                block[j][i] = BStauts.FILL
            }
        }
    }

    fun makeRainArea(){
        var tmp = -1
        for(i in 0..H-1){
            for(j in 0..W-1){
                if(block[i][j]==BStauts.FILL){
                    if(tmp != -1) {
                        for(k in tmp+1..j-1) {
                            if(block[i][k] == BStauts.NONE)
                                block[i][k] = BStauts.RAIN
                        }
                    }
                    tmp = j;
                }
            }
            tmp = -1
        }
    }

    fun printBlock(){
        for(i in block){
            for (j in i){
                print(j.c)
            }
            println()
        }
    }

    fun findRainArea(): Int{
        var result = 0
        for(i in block){
            for (j in i){
                if(j==BStauts.RAIN)
                    result+=1
            }
        }
        return result
    }
}

fun main(arg: Array<String>)=with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())

    val H = st.nextToken().toInt()
    val W = st.nextToken().toInt()

    st = StringTokenizer(readLine())
    val heights: Array<Int> = Array(W,{0})
    for(i in 0..W-1){
        heights[i] = st.nextToken().toInt()
    }
    val block = Block(H,W)
    block.makeBlock(heights)
    block.makeRainArea()
    println(block.findRainArea())
}
