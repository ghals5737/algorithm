import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class beak15659 {
    static int n;
    static long max=Long.MIN_VALUE;
    static long min=Long.MAX_VALUE;
    static long[] arr;
    static int[] mod;
    static int[] arr1;
    static Stack<Long>s1=new Stack<>();
    static Stack<Integer>s2=new Stack<>();
    static long cal(long a,long b,int mod){
        if(mod==0){
            return a+b;
        }else if(mod==1){
            return a-b;
        }else if(mod==2){
            return a*b;
        }else{
            return a/b;
        }
    }
    static void dfs(int idx){
        if(idx==n-1){
            s1.add(arr[0]);
            for(int i=0;i<n-1;i++){
                if(arr1[i]<=1){
                    s1.add(arr[i+1]);
                    s2.add(arr1[i]);
                }else{
                    s1.add(cal(s1.pop(),arr[i+1],arr1[i]));
                }
            }
            long result=0;
            while(!s2.isEmpty()){
                long a=s1.pop();
                long b=s2.pop();                
                if(b==1)a*=-1;
                result+=a;
            }            
            result+=s1.pop();
            max=Math.max(max,result);
            min=Math.min(min,result);
            return;
        }
        for(int i=0;i<4;i++){
            if(mod[i]>0){
                mod[i]--;
                arr1[idx]=i;
                dfs(idx+1);
                mod[i]++;
            }            
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        arr=new long[n];
        st=new StringTokenizer(bf.readLine()); 
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine()); 
        mod=new int[4];
        arr1=new int[n];
        for(int i=0;i<4;i++){
            mod[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max);
        System.out.println(min);
    }    
}
