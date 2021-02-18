import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak2342 {
    static int[][][] dp=new int[100001][5][5];
    static int n;
    static int[] arr;
    static int dp(int idx,int l,int r){
        if(idx==n)return 0;
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str=st.nextToken();
        arr=new int[str.length()];
        n=str.length()-1;
        for(int i=0;i<100001;i++)for(int j=0;j<5;j++)for(int k=0;k<5;k++)dp[i][j][k]=-1;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            arr[i]=c-'0';
        }
    }    
}
