import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back11967 {
    static int n;
    static ArrayList<Integer>[] arr;
    static boolean[][] visited;
    static boolean[] check;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static int ans=0;
    static boolean flag=false;

    static void dfs(int x,int y){        
        visited[y][x]=true;
        int num=n*(y-1)+x;       
        
        for(int el:arr[num]){
            if(!check[el]){
                flag=true;
            }
            check[el]=true;
        }    
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            num=n*(ny-1)+nx;
            if(nx>0&&nx<=n&&ny>0&&ny<=n&&!visited[ny][nx]&&check[num]){
                dfs(nx,ny);
            }
        }   
       
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        arr=new ArrayList[n*n+1];
        check=new boolean[n*n+1];
        visited=new boolean[n+1][n+1];
        for(int i=0;i<=n*n;i++)arr[i]=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            int num1=(n*(y1-1)+x1);
            int num2=(n*(y2-1)+x2);
            arr[num1].add(num2);
        }
        check[1]=true;
        while(true){
            visited=new boolean[n+1][n+1];
            flag=false;
            dfs(1,1);
            if(!flag)break;
        }       
        for(boolean el:check)if(el)ans++;
        System.out.println(ans);
    }
}
