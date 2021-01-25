import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back2513 {   
    static int n,k,s;    
    static int[] arr=new int[100005];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());
        int sApt=-1;
        int eApt=0;
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            int idx=Integer.parseInt(st.nextToken());
            int cnt=Integer.parseInt(st.nextToken());
            arr[idx]=cnt;
            if(sApt==-1||sApt>idx){
                sApt=idx;
            }
            if(eApt<idx){
                eApt=idx;
            }
        }     
        int ans=0;   

        while(sApt<s){
            int start=sApt;
            int tmp=k;
            int end=sApt;
            if(arr[sApt]>0){                
                while(true){
                    if(tmp==0||end==s){
                        sApt=end;
                        ans+=(s-start)*2;
                        break;
                    }
                    if(arr[end]>tmp){
                        arr[end]-=tmp;
                        tmp=0;                        
                    }else{
                        tmp-=arr[end];
                        arr[end]=0;
                        end++;
                    }                    
                }
            }else{
                sApt++;
            }
        }
        while(eApt>s){
            int start=eApt;
            int tmp=k;
            int end=eApt;
            if(arr[eApt]>0){                
                while(true){
                    if(tmp==0||end==s){
                        eApt=end;
                        ans+=(start-s)*2;
                        break;
                    }
                    if(arr[end]>tmp){
                        arr[end]-=tmp;
                        tmp=0;                        
                    }else{
                        tmp-=arr[end];
                        arr[end]=0;
                        end--;
                    }                    
                }
            }else{
                eApt--;
            }
        }
        System.out.println(ans);
    }    
}
