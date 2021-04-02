import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak1082 {
    static int n;    
    static int[] cost;
    static int money;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        cost=new int[n];
        st=new StringTokenizer(bf.readLine());
        int minCost=987654321;
        int minNum=0;
        for(int i=0;i<n;i++){
            cost[i]=Integer.parseInt(st.nextToken());
            if(cost[i]<minCost){
                minCost=cost[i];
                minNum=i;
            }
        }
        st=new StringTokenizer(bf.readLine());
        money=Integer.parseInt(st.nextToken());
        int spend=0;
        int maxLen=0;
        int maxNum=0;
        for(int i=1;i<n;i++){
            if(i<minNum)continue;
            int now=cost[i];
            if(money-now<0)continue;
            int len=(money-now)/minCost;
            if(maxLen<=len){
                maxLen=len;
                maxNum=i;
            }
        }
        int[] ans=new int[maxLen+1];
        spend=cost[maxNum]+maxLen*cost[0];
        int change=money-spend;        
        ans[0]=maxNum;
        for(int i=1;i<maxLen+1;i++)ans[i]=minNum;
        int idx=1;
        while(idx<maxLen+1){
            int nowChange=change+minCost;
            int max=minNum;
            for(int i=1;i<n;i++){
                if(i<minNum)continue;
                if(nowChange>=cost[i]){
                    max=Math.max(max,i);
                }
            }
            if(max==minNum)break;
            change-=(cost[max]-minCost);
            ans[idx++]=max;
        }  
        String res="";
        for(int i=0;i<maxLen+1;i++)res+=ans[i]+"";
        System.out.println(res);      
    }    
}
