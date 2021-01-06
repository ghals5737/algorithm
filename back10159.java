import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back10159 {
    static int n,m;    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());
        int[][] map=new int[n+1][n+1];       
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            map[start][end]=1;        
        }  
        for(int k=1;k<=n;k++){              
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){                
                    if(map[i][k]==1&&map[k][j]==1){
                        map[i][j]=1;
                    }
                }
            }
        }
        for(int i=1;i<=n;i++){            
            int cnt=0;
            for(int j=1;j<=n;j++){
                if(map[i][j]==0&&map[j][i]==0)cnt++;
            }
            System.out.println(cnt-1);
        }
    }    
}
