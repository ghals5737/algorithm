import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak20208 {    
    static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;            
        }
    }
    static int n,m,h,sX,sY,ans;        
    static ArrayList<Pair>list=new ArrayList<>();
    static boolean[] v=new boolean[11];
    static int[] arr=new int[11];

    static void perm(int idx){
        if(idx==list.size()){
            int x=sX;
            int y=sY;
            int hp=m;
            int mint=0;
            for(int i=0;i<list.size();i++){
                int num=arr[i];
                int dist=Math.abs(x-list.get(num).x)+Math.abs(y-list.get(num).y);
                int toHome=Math.abs(sX-list.get(num).x)+Math.abs(sY-list.get(num).y);
                if(hp>=dist){
                    hp-=dist;
                    hp+=h;
                    mint++;
                    if(hp>=toHome)ans=Math.max(ans,mint);
                }else{
                    return;
                }
                x=list.get(num).x;
                y=list.get(num).y;                
            }
            return;
        }          
        for(int i=0;i<list.size();i++){
            if(!v[i]){
                v[i]=true;
                arr[idx]=i;
                perm(idx+1);
                v[i]=false;
            }
        }      
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));             
        StringTokenizer st=new StringTokenizer(bf.readLine());         
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());
        int cnt=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());         
            for(int j=0;j<n;j++){
                int num=Integer.parseInt(st.nextToken());
                if(num==1){
                    sX=j;
                    sY=i;
                }else if(num==2){
                    list.add(new Pair(j,i));
                }
            }
        }         
        cnt=list.size(); 
        ans=0;   
        perm(0);        
        System.out.println(ans);
    }    
}
