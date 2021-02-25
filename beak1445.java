import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class beak1445 {
    static class Node{
        int x;
        int y;
        int g;
        int b;
        public Node(int x,int y,int g,int b){
            this.x=x;
            this.y=y;
            this.g=g;
            this.b=b;
        }
    }
    static int n,m,sX,sY,eX,eY;
    static int[][] map;
    static boolean[][] v;    
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static boolean check(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;
    }
    static void bfs(int sX,int sY){
        PriorityQueue<Node>pq=new PriorityQueue<>((Node a,Node b)->{
            if(a.g==b.g)return a.b-b.b;
            else return a.g-b.g;
        });
        pq.add(new Node(sX,sY,0,0));
        v[sY][sX]=true;
        while(!pq.isEmpty()){
            Node el=pq.poll();
            int x=el.x;
            int y=el.y;
            int g=el.g;
            int b=el.b;
            if(x==eX&&y==eY){
                System.out.println(g+" "+b);
                return;
            }
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(check(nx,ny)&&!v[ny][nx]){
                    v[ny][nx]=true;
                    if(map[ny][nx]==5000){
                        pq.add(new Node(nx,ny,g+1,b));
                    }else if(map[ny][nx]==1){
                        pq.add(new Node(nx,ny,g,b+1));
                    }else{
                        pq.add(new Node(nx,ny,g,b));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        v=new boolean[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            String s=st.nextToken();
            for(int j=0;j<m;j++){
                char c=s.charAt(j);
                if(c=='F'){
                    eX=j;
                    eY=i;
                    map[i][j]=-1;
                }else if(c=='S'){
                    sX=j;
                    sY=i;
                    map[i][j]=-1;
                }else if(c=='g'){
                    map[i][j]=5000;
                    for(int k=0;k<4;k++){
                        int nx=j+dx[k];
                        int ny=i+dy[k];
                        if(check(nx, ny)&&map[ny][nx]==0)map[ny][nx]=1;
                    }
                }
            }            
        }
        map[sY][sX]=map[eY][eX]=0;                
        bfs(sX,sY);                       
    }    
}
