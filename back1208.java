import java.util.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back1208{
    static int n,s,half;
    static long ans;
    static HashMap<Integer,Integer>map=new HashMap<>();
    static int[] v;
    static void left(int idx,int sum){
        if(idx==half){
            if(map.containsKey(sum)){
                int num=map.get(sum)+1;
                map.put(sum,num);
            }else{
                map.put(sum,1);
            }
            return;
        }
        left(idx+1,sum);
        left(idx+1,sum+v[idx]);
    }
    static void right(int idx,int sum){
        if(idx==n){
            if(map.containsKey(s-sum)){
                ans+=map.get(s-sum);             
            }
            return;
        }
        right(idx+1, sum);
        right(idx+1, sum+v[idx]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        n=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());
        half=n/2;
        v=new int[n];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++)v[i]=Integer.parseInt(st.nextToken());
        left(0,0);
        right(half,0);
        if(s==0)ans--;
        System.out.println(ans);
    }
}