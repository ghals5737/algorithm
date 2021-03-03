import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1342 {
    static int[] alpa=new int[30];
    static String s;
    static int n;
    static int ans;
    static void dfs(int cnt,int prev){
        if(cnt==n){
            ans++;
        }
        for(int i=0;i<26;i++){
            if(alpa[i]>0&&prev!=i){
                alpa[i]--;
                dfs(cnt+1,i);
                alpa[i]++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        s=st.nextToken();
        n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            alpa[c-'a']++;
        }
        ans=0;
        dfs(0,-1);
        System.out.println(ans);
    }    
}
