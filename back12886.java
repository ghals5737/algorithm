import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back12886 {
    static int[] arr;
    static class Stone{
        int a;
        int b;
        int c;
        public Stone(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        arr=new int[3];
        for(int i=0;i<3;i++)arr[i]=Integer.parseInt(st.nextToken());
        Queue<Stone>q=new LinkedList<>();       
        q.add(new Stone(arr[0],arr[1],arr[2]));
        if((arr[0]+arr[1]+arr[2])%3!=0){
            System.out.println(0);
            return;
        }
        int cnt=0;
        while(!q.isEmpty()){
            Stone s=q.poll();
            int a=s.a;
            int b=s.b;
            int c=s.c;
            if(cnt>10000)break;
            if((a+b+c)%3!=0)continue;
            if(a==b&&b==c){
                System.out.println(1);
                return;
            }
            //a,b
            if(a!=b){
                if(a>b){
                    if(a-b>=0){
                        q.add(new Stone(a-b, b*2, c));
                    }
                }else{
                    if(b-a>=0){
                        q.add(new Stone(a*2,b-a,c));
                    }                    
                }
            }
            //a,c
            if(a!=c){
                if(a>c){
                    if(a-c>=0){
                        q.add(new Stone(a-c, b, c*2));
                    }
                }else{
                    if(c-a>=0){
                        q.add(new Stone(a*2, b, c-a));
                    }
                }
            }
            //b,c
            if(b!=c){
                if(b>c){
                    if(b-c>=0){
                        q.add(new Stone(a, b-c, c*2));
                    }
                }else{
                    if(c-b>=0){
                        q.add(new Stone(a, b*2, c-b));
                    }
                }
            }
            cnt++;
        }
        System.out.println(0);
    }    
}
