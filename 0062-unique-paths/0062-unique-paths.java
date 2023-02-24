class Solution {
    public int uniquePaths(int m, int n) {
        int nominator = m+n-2;
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        int [] x1 = new int[nominator-max+1];
        int [] x2 = new int[min-1];
        for(int i = 0;i<x1.length;i++){
            x1[i]=max+i;
        }
        for(int i = 0;i<x2.length;i++){
            x2[i]=i+1;
        }
        for(int i =0;i<x1.length;i++){
            for(int j =x2.length-1;j>-1;j--){
                if(x1[i]%x2[j]==0 && x2[j]>1){
                    x1[i]=x1[i]/x2[j];
                    x2[j]=1;
                }
                if(x1[i]==1)break;
            }
        }
        for(int i =0;i<x1.length;i++){
            for(int j =x2.length-1;j>-1;j--){
                if(x2[j]>1){
                    int gcd = gcd(x1[i],x2[j]);
                    if(gcd>1){
                        x1[i]=x1[i]/gcd;
                        x2[j]=x2[j]/gcd;
                    }
                }
                if(x1[i]==1)break;
            }
        }
        int up = 1;
        int down = 1;
        for(int i =0;i<x1.length;i++){
            up = up*x1[i];
        }
        for(int i =0;i<x2.length;i++){
            down = down*x2[i];
        }
        return up/down;
    }
    public static int gcd(int x, int y){
        int gcd = 1;
        for(int i = 1; i <= x && i <= y; i++)  {    
            if(x%i==0 && y%i==0)  
                gcd = i;  
        }
        return gcd;
    }
}