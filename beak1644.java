import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1644 {
    static int max=4000000;
    static int n,cnt;
    static boolean[] isPrime=new boolean[max+1];
    static int[] prime=new int[max];
    static void setPrime(){
        int num=(int)Math.sqrt(max);
        for(int i=2;i<=num;i++){
            if(isPrime[i])continue;
            for(int j=i+i;j<=max;j+=i){                
                isPrime[j]=true;                
            }
        }
    }
    static void init(){
        for(int i=2;i<=max;i++){
            if(!isPrime[i])prime[cnt++]=i;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        cnt=0;
        int ans=0;
        n=Integer.parseInt(st.nextToken());
        int e=0;
        int s=0;
        int sum=0;
        setPrime();
        init();
        while(e<=cnt){
            if(sum<n){
                sum+=prime[e++];
                continue;
            }
            if(sum==n)ans++;
            sum-=prime[s++];
        }
        System.out.println(ans);
    }    
}
