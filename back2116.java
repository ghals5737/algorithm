import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back2116 {
    static int n,ans;
    static int[][] dice;
    static void solve(int now,int val,int sum){
        if(now==n){
            ans=Math.max(ans,sum);
            return;
        }
        for(int i=0;i<6;i++){
            if(dice[now][i]==val){
                int max=0;
                for(int j=0;j<3;j++){
                    if(j==i||j+3==i)continue;
                    max=Math.max(dice[now][j],max);
                    max=Math.max(dice[now][j+3],max);
                }
                solve(now+1,dice[now][(i+3)%6],sum+max);                
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());    
        n=Integer.parseInt(st.nextToken());
        dice=new int[n][6];
        ans=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            dice[i][0]=Integer.parseInt(st.nextToken());
            dice[i][1]=Integer.parseInt(st.nextToken());
            dice[i][2]=Integer.parseInt(st.nextToken());
            dice[i][4]=Integer.parseInt(st.nextToken());
            dice[i][5]=Integer.parseInt(st.nextToken());
            dice[i][3]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<6;i++)solve(0,dice[0][i],0);
        System.out.println(ans);
    }    
}
