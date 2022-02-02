import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    var dx=arrayOf(0,1,0,-1)
    var dy=arrayOf(-1,0,1,0)

    val arr = readLine().split(' ').map { it.toInt() }
    var player= mutableListOf<Int>()
    var m=arr[0]
    var n=arr[1]
    var p=arr[2]

    var map= mutableMapOf<String,Int>()
    var board= Array(m){Array(n){'a'}}
    var check= Array(m){Array(n){false}}
    var bx=0
    var by=0
    var q=arrayListOf<Pair<Int,Int>>()

    for(i in 0..m-1){
        var str=readLine()
        for(j in 0 .. str.length-1 step(1)){
            board[i][j]=str[j]
            if(str[j]=='B'){
               bx=j
               by=i
            }
        }
    }

    for(i in 0..p-1){
        val str = readLine().split(' ').map { it.toString() }
        map.put(str[0],str[1].toInt())
    }

    var hp=readLine().toInt()
    var cnt=0
    q.add(Pair(bx,by))
    while(hp>0){
        var len=q.size

        for(a in 0..len-1){
            var pair=q.get(0)
            q.removeFirst()
            if(board[pair.second][pair.first]>='a'&&board[pair.second][pair.first]<='z'){
                player.add(map.get(board[pair.second][pair.first]+"")!!)
                cnt++
            }
            for(i in 0..3){
                var nx=pair.first+dx[i]
                var ny=pair.second+dy[i]
                if(nx>=0&&nx<n&&ny>=0&&ny<m&&!check[ny][nx]&&board[ny][nx]!='X'){
                    check[ny][nx]=true
                    q.add(Pair(nx,ny))
                }
            }
        }
        player.forEach { it -> hp -= it }
    }

    println(cnt)
}
