import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak1400 {
    static class Pair{
        int x;
        int y;
        int a;
        int b;
        boolean flag;
        public Pair(int x,int y,int a,int b,boolean flag){
            this.x=x;
            this.y=y;
            this.a=a;
            this.b=b;
            this.flag=flag;
        }
    }    
    static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int n,m,sX,sY,eX,eY;    
    static int[][] map;    
    static boolean[][][] v;
    static Pair[] arr;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static boolean check(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;
    }
    static void bfs(){
        v[sY][sX][0]=true;
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(sX,sY));
        while(!q.isEmpty()){
            Node el=q.poll();
            int x=el.x;
            int y=el.y;
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(check(nx, ny)&&map[ny][nx]!=0){
                    
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st=new StringTokenizer(bf.readLine()); 
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            if(n+m==0)break;
            map=new int[n][m];
            v=new boolean[n][m][402];
            arr=new Pair[10];
            for(int i=0;i<10;i++)arr[i]=new Pair(0,0,0,0,false);
            int cnt=0;
            for(int i=0;i<n;i++){
                st=new StringTokenizer(bf.readLine()); 
                String s=st.nextToken();
                for(int j=0;j<m;j++){
                    char c=s.charAt(j);
                    if(c=='A'){
                        sX=j;
                        sY=i;                        
                    }else if(c=='B'){
                        sX=j;
                        sY=i;
                    }else if(c=='#'){
                        map[i][j]=1;
                    }else if(c>='0'&&c<='9'){
                        arr[c-'0'].x=j;
                        arr[c-'0'].y=i;  
                        cnt++;                      
                    }
                }                
            }
            for(int i=0;i<cnt;i++){
                st=new StringTokenizer(bf.readLine()); 
                int num=Integer.parseInt(st.nextToken());
                String state=st.nextToken();
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                if(state.equals("|")){
                    arr[num].a=a;
                    arr[num].b=b;
                    arr[num].flag=true;
                }else{
                    arr[num].a=a;
                    arr[num].b=b;
                    arr[num].flag=false;
                }
            }
            st=new StringTokenizer(bf.readLine()); 
        }        
    }    
}
