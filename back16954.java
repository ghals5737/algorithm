import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back16954 {
    static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;            
        }
    }
    static int n=8;
    static int[][] map=new int[8][8];
    static boolean[][][] visited=new boolean[8][8][64*8];
    static int[] dx={0,0,1,1,1,0,-1,-1,-1};
    static int[] dy={0,-1,-1,0,1,1,1,0,-1};

    static int bfs(){
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(0,7));
        visited[7][0][0]=true;
        int cnt=0;
        while(!q.isEmpty()){
            int size=q.size();
            cnt++;
            for(int k=0;k<size;k++){
                Pair p=q.poll();
                int x=p.x;
                int y=p.y;                
                if(map[y][x]==1)continue;
                if(y==0&&x==7)return 1;
                for(int i=0;i<9;i++){
                    int nx=x+dx[i];
                    int ny=y+dy[i];
                    if(nx>=0&&nx<n&&ny>=0&&ny<n&&!visited[ny][nx][cnt]&&map[ny][nx]==0){
                        visited[ny][nx][cnt]=true;
                        q.add(new Pair(nx,ny));
                    }
                }
            }
            for(int i=n-2;i>=0;i--){
                for(int j=0;j<n;j++){
                    map[i+1][j]=map[i][j];
                }
            }
            for(int i=0;i<n;i++)map[0][i]=0;            
        }
        return 0;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));       
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(bf.readLine());
            String s=st.nextToken();
            for(int j=0;j<n;j++){
                char c=s.charAt(j);
                if(c=='.'){
                    map[i][j]=0;
                }else{
                    map[i][j]=1;
                }
            }
        }        
        System.out.println(bfs());       
    }    
}
