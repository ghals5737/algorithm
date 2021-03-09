import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class beak15961 {
    static int n,d,k,c;
    static int[] shushi;
    static int[] kind;
    static Deque<Integer>dq=new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        n=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        shushi=new int[3000001];
        kind=new int[4000];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());  
            shushi[i]=Integer.parseInt(st.nextToken());
        }
        int cnt=0;
        for(int i=0;i<k;i++){
            dq.add(shushi[i]);
            if(kind[shushi[i]]++==0)cnt++;
        }
        int max=cnt;
        for(int i=0;i<n-1;i++){
            int num=dq.pollFirst();
            if(--kind[num]==0)cnt--;
            dq.add(kind[shushi[(k+i)%n]]);
            if(kind[shushi[(k+i)%n]]++==0)cnt++;
            if(kind[c]==0){
                max=Math.max(cnt+1,max);
            }else{
                max=Math.max(cnt,max);
            }
        }
        System.out.println(max);
    }    
}
