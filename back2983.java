import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;
public class back2983 {
    static class Pair{        
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;            
        }
    }
    static int n,k;    
    static HashMap<Integer,TreeMap<Integer,Integer>>plus=new HashMap<>();
    static HashMap<Integer,TreeMap<Integer,Integer>>minus=new HashMap<>();
    static ArrayList<Pair>list=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        String s=st.nextToken();
        int nowX=0;
        int nowY=0;        
        for(int  kk=0;kk<n;kk++){
            st=new StringTokenizer(bf.readLine());
            if(kk==0){
                nowX=Integer.parseInt(st.nextToken());
                nowY=Integer.parseInt(st.nextToken());                
            }else{
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());                
                if(!plus.containsKey(x+y)){
                    plus.put(x+y,new TreeMap<Integer,Integer>());                    
                }
                if(!minus.containsKey(y-x)){
                    minus.put(y-x,new TreeMap<Integer,Integer>());                    
                }
                plus.get(x+y).put(x,kk-1);
                minus.get(y-x).put(x,kk-1);
                list.add(new Pair(x,y));
            }
        }
       
        for(int kk=0;kk<k;kk++){
            char c=s.charAt(kk);
            if(c=='A'){
                if(minus.containsKey(nowY-nowX)){
                    Entry<Integer,Integer>entry=minus.get(nowY-nowX).higherEntry(nowX);
                    if(entry!=null){
                        Pair p=list.get(entry.getValue());
                        nowX=p.x;
                        nowY=p.y;
                        plus.get(nowY+nowX).remove(entry.getKey());
                        minus.get(nowY-nowX).remove(entry.getKey());
                    }
                }
            }else if(c=='B'){
                if(plus.containsKey(nowY+nowX)){
                    Entry<Integer,Integer>entry=plus.get(nowY+nowX).higherEntry(nowX);
                    if(entry!=null){
                        Pair p=list.get(entry.getValue());
                        nowX=p.x;
                        nowY=p.y;
                        plus.get(nowY+nowX).remove(entry.getKey());
                        minus.get(nowY-nowX).remove(entry.getKey());
                    }
                }       
            }else if(c=='C'){
                if(plus.containsKey(nowY+nowX)){
                    Entry<Integer,Integer>entry=plus.get(nowY+nowX).lowerEntry(nowX);
                    if(entry!=null){
                        Pair p=list.get(entry.getValue());
                        nowX=p.x;
                        nowY=p.y;
                        plus.get(nowY+nowX).remove(entry.getKey());
                        minus.get(nowY-nowX).remove(entry.getKey());
                    }
                }    
            }else{
                if(minus.containsKey(nowY-nowX)){
                    Entry<Integer,Integer>entry=minus.get(nowY-nowX).lowerEntry(nowX);
                    if(entry!=null){
                        Pair p=list.get(entry.getValue());
                        nowX=p.x;
                        nowY=p.y;
                        plus.get(nowY+nowX).remove(entry.getKey());
                        minus.get(nowY-nowX).remove(entry.getKey());
                    }
                }               
            }            
        }
        System.out.println(nowX+" "+nowY);
    }    
}
