import java.util.*

val dx = listOf(0,0,-1,1)
val dy = listOf(-1,1,0,0)

class ClassRoom(val N : Int) {
    val classRoom: Array<Array<Int>> = Array(N,{Array(N,{0})})
    val likeMap:MutableMap<Int,Array<Int>> = mutableMapOf()


    fun fillLikeMap(key:Int, value: Array<Int>){
        likeMap.put(key,value)
    }

    fun fillStudent(num: Int, likes: Array<Int>) {
        val likeAdjs: Array<Array<Int>> = Array(N, { Array(N, { 0 }) })

        for (i in 0..N - 1) {
            for (j in 0..N - 1) {
                if(classRoom[i][j]!=0) continue
                for (k in 0..3) {
                    var nx = i + dx[k]
                    var ny = j + dy[k]
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(classRoom[nx][ny] in likes)
                        likeAdjs[i][j]++
                }
            }
        }

        var max = -1
        val maxLikeAdjs: MutableList<Array<Int>> = mutableListOf()
        for (i in 0..N - 1) {
            for (j in 0..N - 1) {
                if(classRoom[i][j]!=0) continue;
                if(max == likeAdjs[i][j]){
                    maxLikeAdjs.add(arrayOf(i,j))
                }
                else if(max<likeAdjs[i][j]){
                    maxLikeAdjs.clear()
                    maxLikeAdjs.add(arrayOf(i,j))
                    max = likeAdjs[i][j]
                }
            }
        }

        max = -1
        var adjAdjs = Array<Int>(maxLikeAdjs.size, {0})
        for(i in 0..maxLikeAdjs.size-1){
            var cnt = 0
            for(j in 0..3){
                val nx = maxLikeAdjs[i][0]+dx[j]
                val ny = maxLikeAdjs[i][1]+dy[j]
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(classRoom[nx][ny]==0) cnt++
            }
            adjAdjs[i] = cnt
            if(cnt>max){
                max = cnt
            }
        }


        maxLikeAdjs.sortWith(compareBy({it[0]},{it[1]}))

        for(i in 0..maxLikeAdjs.size-1){
            if(adjAdjs[i]==max) {
                classRoom[maxLikeAdjs[i][0]][maxLikeAdjs[i][1]] = num
                return
            }
        }

    }

    fun fillClass(){
        for((key,value) in likeMap){
            fillStudent(key,value)
        }
    }

    fun calcutateSatisfaction(): Int{
        var satisfaction = 0
        for((key,value) in likeMap){
            var cnt =0
            for(i in 0.. N-1){
                for(j in 0..N-1){
                    if(classRoom[i][j] == key) {
                        for(k in 0..3){
                            val nx = i+dx[k]
                            val ny = j+dy[k]
                            if(nx<0||ny<0||nx>=N||ny>=N) continue
                            if(classRoom[nx][ny] in value) cnt++
                        }
                    }
                }
            }
            if(cnt>=1)
                satisfaction+=(Math.pow(10.0, (cnt-1).toDouble())).toInt()
        }
        return satisfaction
    }
    fun print(){
        for(i in 0..N-1){
            for(j in 0..N-1){
                print(classRoom[i][j])
            }
            println()
        }
    }
}
fun main(arg: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val classRoom = ClassRoom(N)
    for(i in 1..N*N){
        val st = StringTokenizer(readLine())
        val num = st.nextToken().toInt()
        val likes = Array<Int>(4,{0})
        for(j in 0.. 3){
            likes[j] = st.nextToken().toInt()
        }
        classRoom.fillLikeMap(num,likes)
    }
    classRoom.fillClass()
    println(classRoom.calcutateSatisfaction())
}
