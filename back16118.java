import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back16118 {
    static class Node{
        int to;
        int cost;
        public Node(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
    }
    static class Node2{
        int to;
        int cost;
        int flag;
        public Node2(int to,int cost,int flag){
            this.to=to;
            this.cost=cost;
            this.flag=flag;
        }
    }
    private static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public int readInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
    static int n,m;
    static long[] dist;
    static long[][] dist2;
    static ArrayList<Node>[] node;
    
    static void fox(int start){       
        PriorityQueue<Node>pq=new PriorityQueue<>((Node a,Node b)->{return a.cost-b.cost;});
        pq.add(new Node(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            Node n=pq.poll();
            int now=n.to;
            int cost=n.cost;                                 
            for(Node el:node[now]){
                int next=el.to;
                int nextCost=cost+el.cost;
                if(dist[next]>nextCost){
                    dist[next]=nextCost;
                    pq.add(new Node(next,nextCost));
                }
            }            
        }
    }
    static void wolf(int start){        
        PriorityQueue<Node2>pq=new PriorityQueue<>((Node2 a,Node2 b)->{return a.cost-b.cost;});
        pq.add(new Node2(start,0,0));
        dist2[0][start]=0;           
        while(!pq.isEmpty()){            
            Node2 n=pq.poll();
            int now=n.to;
            int cost=n.cost;
            int flag=n.flag;      
            if(dist2[flag][now]<cost)continue;      
            for(Node el:node[now]){
                int next=el.to;
                int nextCost=cost;
                if(flag==1) {
                    nextCost+=el.cost*2;
                }else{
                    nextCost+=el.cost/2;
                }
                if(dist2[1-flag][next]>nextCost){
                    dist2[1-flag][next]=nextCost;
                    pq.add(new Node2(next,nextCost,1-flag));
                }
            }    
                          
        }
    }
    public static void main(String[] args) throws IOException {        
        InputReader in = new InputReader(System.in);
        n=in.readInt();
        m=in.readInt();
        node=new ArrayList[n+1];
        dist=new long[n+1];
        dist2=new long[2][n+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        Arrays.fill(dist2[0],Long.MAX_VALUE);
        Arrays.fill(dist2[1],Long.MAX_VALUE);
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        for(int i=0;i<m;i++){           
            int from=in.readInt();
            int to=in.readInt();
            int cost=in.readInt();
            node[from].add(new Node(to, cost*2));
            node[to].add(new Node(from, cost*2));
        }
        fox(1);
        wolf(1);
        int cnt=0;
        for(int i=1;i<=n;i++){
            long foxD=dist[i];
            long wolfD=dist2[0][i]<dist2[1][i]?dist2[0][i]:dist2[1][i];            
            if(foxD<wolfD)cnt++;
        }
        System.out.println(cnt);
    }    
}
