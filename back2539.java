import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back2539 {
    static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int n,m;
    static int maxP;
    static ArrayList<Pair>list=new ArrayList<>();
    static boolean check(int mid){
        int cnt=0;
        int prev=-1;
        for(Pair p:list){
             if(prev==-1){
                 prev=p.x;
                 cnt++;
             }else if(prev+mid<=p.x){
                 prev=p.x;
                 cnt++;                 
             }
        }
        if(cnt<=maxP)return true;     
        else return false;
    }
    static int binary(int left,int right){
        int result=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(check(mid)){
                result=mid;
                right=mid-1;                
            }else{
                left=mid+1;
            }
        }
        return result;        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        maxP=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        int t=Integer.parseInt(st.nextToken());
        int maxh=0;
        for(int i=0;i<t;i++){
            st=new StringTokenizer(bf.readLine());
            int y=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            maxh=Math.max(maxh,y);
            list.add(new Pair(x,y));            
        }
        list.sort((Pair a,Pair b)->{
            return a.x-b.x;
        });
        System.out.println(binary(maxh,n));
    }    
}
