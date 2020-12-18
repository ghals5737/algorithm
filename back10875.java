import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back10875 {
    static class Info{
        int t;
        String dir;
        public Info(int t,String dir){
            this.t=t;
            this.dir=dir;
        }
    }
    static class  Line{
        int maxX;
        int maxY;
        int minX;
        int minY;
        int d;        
        public Line(int maxX,int maxY,int minX,int minY,int d){
            this.maxX=maxX;
            this.maxY=maxY;
            this.minX=minX;
            this.minY=minY;
            this.d=d;
        }
    }    
    static int L;
    static int N;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};    
    static ArrayList<Info>list=new ArrayList<>();
    static ArrayList<Line>lineList=new ArrayList<>();

    static int check(int sX,int sY,int eX,int eY,int d,int t){
        int result=t;
        for(Line el:lineList){ 
            //System.out.println("?? "+eX+" "+eY);
           switch(d){
               case 0:
                 if(((el.d==1||el.d==3)&&((sX>=el.minX&&sX<=el.maxX)&&(eY<=el.minY&&sY>=el.minY)))
                 ||((el.d==0||el.d==2)&&((sX==el.minX)&&(!(sY<el.minY||eY>el.maxY))))){
                     //System.out.println("@?");
                     result=Math.min(result,sY-el.maxY);
                 }
               break;
               case 1:
                if(((el.d==1||el.d==3)&&((sY==el.minY)&&(!(sX>el.maxX||eX<el.minX))))
                ||((el.d==0||el.d==2)&&((sY<=el.maxY&&sY>=el.minY)&&(sX<=el.minX&&eX>=el.minX)))){
                    result=Math.min(result,el.minX-sX);
                }
               break;
               case 2:
                if(((el.d==1||el.d==3)&&((sX>=el.minX&&sX<=el.maxX)&&(sY<=el.minY&&eY>=el.minY)))
                    ||((el.d==0||el.d==2)&&((sX==el.minX)&&(!(eY<el.minY||sY>el.maxY))))){
                        result=Math.min(result,el.minY-sY);
                }
               break;
               case 3:
                if(((el.d==1||el.d==3)&&((sY==el.minY)&&(!(eX>el.maxX||sX<el.minX))))
                ||((el.d==0||el.d==2)&&((sY<=el.maxY&&sY>=el.minY)&&(eX<=el.minX&&sX>=el.minX)))){
                    result=Math.min(result,sX-el.maxX);
                }
               break;
           }
        }
      
        return result;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    }   

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());        
       
        L=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());        
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            int t=Integer.parseInt(st.nextToken());
            String s=st.nextToken();
            list.add(new Info(t,s));
        }
        int nowX=0;
        int nowY=0;
        int nowD=1;
        long ans=0;
        int result=0;
        lineList.add(new Line(L,-L-1,-L,-L-1,1));
        lineList.add(new Line(L+1,L,L+1,-L,0));
        lineList.add(new Line(L,L+1,-L,L+1,1));
        lineList.add(new Line(-L-1,L,-L-1,-L,0));
        for(Info el:list){
            int t=el.t;
            String dir=el.dir;
            int sX=nowX;
            int sY=nowY;
            int eX=nowX+dx[nowD]*t;
            int eY=nowY+dy[nowD]*t;

            result=check(sX+dx[nowD],sY+dy[nowD],eX,eY,nowD,t);
            //System.out.println("result: "+result);
            ans+=result;
            if(result<t){                
                System.out.println(ans+1);
                return;
            }
                                      
            lineList.add(new Line(Math.max(sX, eX),Math.max(sY, eY) , Math.min(sX, eX),Math.min(sY, eY),nowD));
            nowX=eX;
            nowY=eY;            
            if(dir.equals("L")){
                switch(nowD){
                    case 0:
                     nowD=3;
                     break;
                    case 1:
                     nowD=0;
                     break;
                    case 2:
                     nowD=1;
                     break;
                    case 3:
                     nowD=2;
                     break;
                }                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
            }else{
                switch(nowD){
                    case 0:
                     nowD=1;
                     break;
                    case 1:
                     nowD=2;
                     break;
                    case 2:
                     nowD=3;
                     break;
                    case 3:
                     nowD=0;
                     break;
                }                
            }           
        }
        result=check(nowX+dx[nowD],nowY+dy[nowD],nowX+dx[nowD]*(1_000_000_000),nowY+dy[nowD]*(1_000_000_000),nowD,1_000_000_000);
        //System.out.println("result: "+result);
        ans+=result;
        System.out.println(ans+1);        
    }
}

