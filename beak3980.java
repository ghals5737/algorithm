import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak3980 {
    static int n,t,ans;
    static int[][] arr;
    static boolean[] v;

    static void dfs(int now,int sum){
        if(now==11){
            ans=Math.max(sum,ans);
            return;
        }
        for(int i=0;i<11;i++){
            if(v[i]||arr[now][i]==0)continue;                
            v[i]=true;
            dfs(now+1,sum+arr[now][i]);
            v[i]=false;            
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());       
        t=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        arr=new int[12][12];
        v=new boolean[12];
        
        for(int tt=0;tt<t;tt++){                        
            for(int i=0;i<11;i++){
                st=new StringTokenizer(bf.readLine());       
                v[i]=false;
                for(int j=0;j<11;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());                    
                }
            }
            ans=0;
            for(int i=0;i<11;i++){
                if(arr[0][i]!=0){
                    v[i]=true;
                    dfs(1,arr[0][i]); 
                    v[i]=false;               
                }                
            }                        
            sb.append(ans+"\n");
        }        
        System.out.println(ans);
    }    
}
