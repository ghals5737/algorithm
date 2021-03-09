import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak16472 {
    static int k,n;
    static String str;
    static int[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        k=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine()); 
        str=st.nextToken();
        n=str.length();
        int s,e;
        int ans=0;
        s=0;
        e=0;
        v=new int[27];
        if(n<=k){
            System.out.println(n);
            return;
        }
        int cnt=0;
        while(s<=e&&e<n){
            if(cnt<=k){
                if(s<=e&&e<n){
                    int idx=str.charAt(e)-'a';
                    if(v[idx]==0){
                        v[idx]++;
                        cnt++;
                    }else{
                        v[idx]++;
                    }
                    e++;
                    if(e==n-1&&cnt>=k){
                        ans=Math.max(e-s+1,ans);
                    }
                }
            }else{
                if(s<=e&&e<n){
                    int idx=str.charAt(e)-'a';
                    v[idx]--;
                    if(v[idx]==0)cnt--;
                    s++;
                }
            }
            if(cnt==k){
                ans=Math.max(e-s,ans);
            }
        }
        System.out.println(ans);
    }    
}
