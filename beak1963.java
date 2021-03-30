import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak1963 {
    static int n,ans;
    static boolean[] prime=new boolean[10000];
    static boolean[] v=new boolean[10000];
    static void getPrime(){
        for(int i=2;i<=100;i++){
            if(prime[i])continue;
            for(int j=i+i;j<10000;j+=i){
                prime[j]=true;
            }
        }
    }
    static int makeNum(int a,int b,int c,int d){
        return a*1000+b*100+c*10+d;
    }
    static int solve(int a,int b){
        Queue<Integer>q=new LinkedList<>();
        v[a]=true;
        q.add(a);
        int cnt=0;
        while(!q.isEmpty()){
            int qSize=q.size();
            for(int i=0;i<qSize;i++){
                int now=q.poll();
                int num=now;
                if(num==b)return cnt;                
                int aa=num/1000;
                num%=1000;
                int bb=num/100;
                num%=100;
                int cc=num/10;
                num%=10;
                int dd=num;
                for(int j=1;j<=9;j++){
                    int next=makeNum(j, bb, cc, dd);
                    if(!v[next]&&!prime[next]){
                        v[next]=true;
                        q.add(next);
                    }
                }
                for(int j=0;j<=9;j++){
                    int next=makeNum(aa, j, cc, dd);
                    if(!v[next]&&!prime[next]){
                        v[next]=true;
                        q.add(next);
                    }
                }
                for(int j=0;j<=9;j++){
                    int next=makeNum(aa, bb, j, dd);
                    if(!v[next]&&!prime[next]){
                        v[next]=true;
                        q.add(next);
                    }
                }
                for(int j=0;j<=9;j++){
                    int next=makeNum(aa, bb, cc, j);
                    if(!v[next]&&!prime[next]){
                        v[next]=true;
                        q.add(next);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        StringBuilder sb=new StringBuilder();
        n=Integer.parseInt(st.nextToken());
        getPrime();         
        for(int i=0;i<n;i++){
            v=new boolean[10000];
            st=new StringTokenizer(bf.readLine());            
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            ans=solve(a, b);
            if(ans==-1)sb.append("Impossible\n");
            else sb.append(ans+"\n");
        }
        System.out.print(sb);
    }    
}
