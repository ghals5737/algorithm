import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class back14466 {
    static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int n;
    static int k;
    static int r;
    
    static HashSet<Integer>[] set;
    static boolean[] visited;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};

    static void dfs(int y,int x){
        int num=(y-1)*n+x;
        visited[num]=true;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=1&&nx<=n&&ny>=1&&ny<=n){
                int num1=(ny-1)*n+nx;
                if(!visited[num1]&&!set[num].contains(num1)){
                    dfs(ny,nx);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());

        set=new HashSet[n*n+1];
       
        for(int i=0;i<=n*n;i++){
            set[i]=new HashSet<>();
        }

        for(int i=0;i<r;i++){
            st=new StringTokenizer(bf.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            int rr=Integer.parseInt(st.nextToken());
            int cc=Integer.parseInt(st.nextToken());

            int num1=(r-1)*n+c;
            int num2=(rr-1)*n+cc;
            set[num1].add(num2);
            set[num2].add(num1);
        }

        ArrayList<Pair>list=new ArrayList<>();
        for(int i=0;i<k;i++){
            st=new StringTokenizer(bf.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            list.add(new Pair(c,r));
        }

        int ans=0;

        for(int i=0;i<k;i++){
            visited=new boolean[n*n+1];
            Pair p=list.get(i);
            int r=p.y;
            int c=p.x;
            dfs(r,c);
            for(int j=i+1;j<k;j++){
                Pair pp=list.get(j);
                int rr=pp.y;
                int cc=pp.x;
                int num=(rr-1)*n+cc;
                if(!visited[num])ans++;
            }
        }
        System.out.println(ans);
    }    
}
