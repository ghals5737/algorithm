import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back2660 {
    static int n;
    static int[][] map;
    static int INF=987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());   
        map=new int[n+1][n+1];
        for(int i=0;i<=n;i++)for(int j=0;j<=n;j++)if(i!=j)map[i][j]=INF;
        while(true){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(a==-1&&b==-1)break;
            map[a][b]=1;
            map[b][a]=1;                        
        }
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(map[i][j]>map[i][k]+map[k][j]){
                        map[i][j]=map[i][k]+map[k][j]; 
                    }
                }
            }
        }
        int[] arr=new int[n+1];
        int mmax=987654321;
        for(int i=1;i<=n;i++){
            int max=0;
            for(int j=1;j<=n;j++){
                if(map[i][j]!=INF)max=Math.max(map[i][j],max);
            }
            arr[i]=max;
            mmax=Math.min(mmax,max);
        }
        int cnt=0;
        for(int i=1;i<=n;i++)if(mmax==arr[i])cnt++;
        StringBuilder sb=new StringBuilder();
        sb.append(mmax+" "+cnt+"\n");
        for(int i=1;i<=n;i++)if(mmax==arr[i])sb.append(i+" ");
        System.out.println(sb);        
    }    
}
