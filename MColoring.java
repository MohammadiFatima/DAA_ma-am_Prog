import java.util.*;

public class MColoring{
    static int G[][]={
        {0, 1, 1, 1},
         {1, 0, 1, 0},
        {1, 1, 0, 1},
         {1, 0, 1, 0}
    };
    static int n=G.length;
    static int x[]= new int [n];
    static int m=3;
    public static void main(String[] args) {
        Arrays.fill(x,0);
        mcoloring(0);
    }
    static void mcoloring(int k){
        while(true){
            Nextvalue(k);
            if(x[k]==0){
            return;
            }
            if(k==n-1){
            printSolution();
            }
            else{
            mcoloring(k+1);
            }
        }

    }
    public static void Nextvalue(int k){
        while(true){
            x[k]= (x[k]+1)%(m+1);
            if(x[k]==0)
            return;
            int j;
            for(j=0;j<n;j++){
                if(G[k][j]!=0 && x[k]==x[j])
                break;
        
            }
            if(j==n){
                return;
            }
            
        }
    }
    public static void printSolution(){
        for(int i=0;i<n;i++){
            System.out.print(x[i]+" ");
        }
        System.out.println();
    }
}
