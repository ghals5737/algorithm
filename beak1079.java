import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1079 {
    static int n,k,ans;
    static int[] g;
    static int[][] map;
    static boolean[] dead;
    // static boolean isSame(int num){
    //     for(int i=0;i<n;i++)if(!dead[i]&&g[i]==num)return false;
    //     return true;
    // }
    static void solve(boolean flag,int man,int night){
        if(man==n-1||dead[k]){
            ans=Math.max(night,ans);
            return;
        }
        if(flag){//낮
            int min=n;
            int maxG=0;
            for(int i=0;i<n;i++){
                if(maxG<g[i]&&!dead[i]){                    
                    maxG=g[i];
                    min=i;
                }
            }
          
            dead[min]=true;            
            solve(!flag, man+1,night);          
            dead[min]=false;
        }else{
            for(int i=0;i<n;i++){
                if(!dead[i]&&i!=k){
                    dead[i]=true;                  
                    for(int j=0;j<n;j++){
                        if(!dead[j])g[j]+=map[i][j];
                    }                               
                    solve(!flag, man+1,night+1);
                    for(int j=0;j<n;j++){
                        if(!dead[j])g[j]-=map[i][j];
                    }                    
                    dead[i]=false;
                }
            }
        }                 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        g=new int[n];
        dead=new boolean[n];
        ans=0;
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<n;i++){
            g[i]=Integer.parseInt(st.nextToken());
        }
        map=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(bf.readLine()); 
        k=Integer.parseInt(st.nextToken());
        if(n%2==0)solve(false,0,0);
        else solve(true,0,0);
        System.out.println(ans);
    }    
}
