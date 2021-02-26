import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak6443 {
    static int n,t;
    static String s;    
    static boolean[] v;
    static int[] alpa;
    static StringBuilder sb=new StringBuilder();
    static void dfs(int idx,String str){
        if(idx==n){
            sb.append(str+"\n");
            return;
        }
        for(int i=0;i<26;i++){
            if(alpa[i]>0){
                alpa[i]--;
                dfs(idx+1,str+((char)('a'+i)+""));
                alpa[i]++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());       
        t=Integer.parseInt(st.nextToken());
        for(int tt=0;tt<t;tt++){
            st=new StringTokenizer(bf.readLine());       
            s=st.nextToken();            
            n=s.length();
            v=new boolean[n]; 
            alpa=new int[26];           
            PriorityQueue<Character>pq=new PriorityQueue<>();
            for(int i=0;i<n;i++)alpa[s.charAt(i)-'a']++;            
            dfs(0,"");
        }
        System.out.println(sb);
    }    
}
