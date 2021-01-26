import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back8982 {
    static class Pair{
        int now;
        int min;
        public Pair(int now,int min){
            this.now=now;
            this.min=min;
        }
    }
    static int n;
    static Pair[] arr=new Pair[40001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        int x,x2,y,y2;
        st=new StringTokenizer(bf.readLine());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());               
        for(int i=0;i<(n/2)-1;i++){
            st=new StringTokenizer(bf.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(bf.readLine());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());
            for(int j=x;j<x2;j++){
                if(arr[j]==null)arr[j]=new Pair(0,0);
                arr[j].now=y;
            }
        }       
        
        st=new StringTokenizer(bf.readLine());
        int row=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());
            int h=arr[x].now;
            arr[x].min=y;
            for(int j=x-1;j>=0;j--){
                h=Math.min(h,arr[j].now);
                arr[j].min=Math.max(arr[j].min,h);
            }
            h=arr[x].now;
            for(int j=x+1;j<row;j++){
                h=Math.min(h,arr[j].now);
                arr[j].min=Math.max(arr[j].min,h);
            }
        }
        int ans=0;
        for(int i=0;i<row;i++){
            ans+=(arr[i].now-arr[i].min);
        } 
        System.out.println(ans);       
    }        
}
