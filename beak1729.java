import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class beak1729 {
    static int n=6;
    static int ans=0;
    static int[][] map=new int[6][6];
    static void cal(int idx,int cnt){
        if(idx<6){
            for(int i=0;i<6;i++){
                map[idx][i]=(map[idx][i]+cnt)%10;                
            }
        }else if(idx>=6&&idx<=11){
            idx-=6;
            for(int i=0;i<6;i++){
                map[i][idx]=(map[i][idx]+cnt)%10;                
            }
        }
        else{  
            if(idx==12){
                for(int i=0;i<6;i++){
                    map[i][i]=(map[i][i]+cnt)%10;                
                }
            }else{
                for(int i=0;i<6;i++){
                    map[5-i][i]=(map[5-i][i]+cnt)%10;                
                }
            }            
        }
    }
    static void dfs(int idx){
        if(idx==14){
            int sum=0;
            for(int i=0;i<n;i++)for(int j=0;j<n;j++)sum+=map[i][j];
            ans=Math.max(ans,sum);
            return;
        }
        for(int i=0;i<10;i++){
            cal(idx,i);
            dfs(idx+1);
            cal(idx,-i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));        
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(bf.readLine()); 
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(ans);
    }    
}
