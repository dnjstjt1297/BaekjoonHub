import java.util.StringTokenizer

val INF = 10001
var minArea = INF

fun rocate(N:Int,M:Int,puzzle: Array<IntArray>): Array<IntArray>{
    val rocatePuzzle = Array(M){IntArray(N)}
    for(i in 0..N-1){
        for(j in 0..M-1) rocatePuzzle[M-1-j][i] = puzzle[i][j]
    }

    return rocatePuzzle
}

fun merge(puzzle1: Array<IntArray>, puzzle2: Array<IntArray>,
          N1:Int, M1:Int, N2:Int, M2:Int, sx:Int, sy:Int): Array<IntArray>{
    val mergePuzzle = Array(N1+N2){IntArray(M1+M2)}
    for(i in 0..N1-1){
        for(j in 0..M1-1) mergePuzzle[i][j]+=puzzle1[i][j]
    }
    for(i in 0..N2-1){
        for(j in 0..M2-1) mergePuzzle[sx+i][sy+j]+=puzzle2[i][j]

    }
    return mergePuzzle
}

fun findArea(puzzle: Array<IntArray>,N:Int,M:Int):Int{

    var row = 0
    var col = 0
    for(i in 0..N-1){
        for(j in 0..M-1){
            if(puzzle[i][j]==2) return INF

            if(puzzle[i][j]==1){
                row = Math.max(row,j+1)
                col = Math.max(col,i+1)
            }
        }
    }

    val area = row*col;
    return area
}

fun findMinArea(puzzle1: Array<IntArray>, puzzle2: Array<IntArray>,
                N1:Int,M1:Int,N2:Int,M2:Int,cnt:Int){
    if(cnt>=4) return
    for(i in 0..N1){
        for(j in 0..M1){
            val mergePuzzle = merge(puzzle1,puzzle2,N1,M1,N2,M2,i,j)
            minArea = Math.min(minArea,findArea(mergePuzzle,N1+N2,M1+M2))
        }
    }

    val rocatePuzzle1 = rocate(N1,M1,puzzle1)
    findMinArea(rocatePuzzle1,puzzle2,M1,N1,N2,M2,cnt+1)
}



fun main(args: Array<String>) = with(System.`in`.bufferedReader()){

    var st = StringTokenizer(readLine())
    val N1 = st.nextToken().toInt()
    val M1 = st.nextToken().toInt()
    val puzzle1 = Array(N1){IntArray(M1)}
    for(i in 0 .. N1-1){
        val input = readLine()
        for(j in 0..M1-1){
            puzzle1[i][j] = input[j].digitToInt()
        }
    }

    st = StringTokenizer(readLine())
    val N2 = st.nextToken().toInt()
    val M2 = st.nextToken().toInt()
    val puzzle2 = Array(N2){IntArray(M2)}
    for(i in 0 .. N2-1){
        val input = readLine()
        for(j in 0..M2-1){
            puzzle2[i][j] = input[j].digitToInt()
        }
    }

    findMinArea(puzzle1,puzzle2,N1,M1,N2,M2,0)
    println(minArea)
}