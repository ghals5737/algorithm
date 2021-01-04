import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back18808 {
    static int n,m,k;
    static int nn,mm;
    static int[][] map;
    static int[][] arr;

    static int[][] rotate(int[][] arr, int degree) {
        int[][] rotate;
        nn = arr.length;
        mm = arr[0].length;
        rotate=new int[nn][mm];
        if(degree==0)return arr;
        switch (degree) {
            case 90:
            case 270:
                rotate = new int[mm][nn];
                break;
            case 180:
                rotate = new int[nn][mm];
                break;           
        }

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                switch (degree) {
                    case 90:
                        rotate[i][j] = arr[nn-1-j][i];
                        break;
                    case 180:
                        rotate[i][j] = arr[nn-1-i][mm-1-j];
                        break;
                    case 270:
                        rotate[i][j] = arr[j][mm-1-i];
                        break;
                }
            }
        }

        return rotate;
    }

    static boolean check(int x,int y,int[][] rotate){
        nn=rotate.length;
        mm=rotate[0].length;
        for(int i=0;i<nn;i++){
            for(int j=0;j<mm;j++){              
                if(x+j>=0&&x+j<m&&y+i>=0&&y+i<n){
                    if(rotate[i][j]==1&&map[y+i][x+j]==1){
                        return false;
                    }
                }else{
                    return false;
                }              
            }
        }
        return true;
    }

    static void fill(int x,int y,int[][] rotate){
        nn=rotate.length;
        mm=rotate[0].length;
        for(int i=0;i<nn;i++){
            for(int j=0;j<mm;j++){
                if(rotate[i][j]==1)map[y+i][x+j]=rotate[i][j];                
            }
        }        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        
        for(int kk=0;kk<k;kk++){
             st=new StringTokenizer(bf.readLine());
             nn=Integer.parseInt(st.nextToken());
             mm=Integer.parseInt(st.nextToken());
             arr=new int[nn][mm];
             for(int i=0;i<nn;i++){
                 st=new StringTokenizer(bf.readLine());
                 for(int j=0;j<mm;j++){
                     arr[i][j]=Integer.parseInt(st.nextToken());
                 }
             }
             boolean flag=false;
             for(int i=0;i<n;i++){
                 if(flag)break;
                 for(int j=0;j<m;j++){
                    if(flag)break;                     
                    for(int d=0;d<4;d++){
                        int[][] arr1=rotate(arr,90*d);
                        if(check(j,i,arr1)){
                            fill(j, i, arr1);
                            flag=true;
                            break;
                        }
                    }                     
                 }
             }            
        }
        int cnt=0;     
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){                
                if(map[i][j]==1)cnt++;
            }            
        }        
        System.out.println(cnt);
    }
}
