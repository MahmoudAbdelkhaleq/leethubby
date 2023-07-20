class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] time = new int [26];
        int [] count = new int [26];
        char max = 'A';
        for(int i =0;i<tasks.length;i++){
            count[tasks[i]-'A']++;
            if(tasks[i]>'A') max = tasks[i];
        }
        int counter = 0;
        int size = max-'A'+1;
        while(!finish(count)){
            char c= findMax(count, time);
            if(c>='A'){
                count[c-'A']--;
                passTime(time);
                time[c-'A']=n;
            }
            else
                passTime(time);
            counter++;
        }
        return counter;
    }
    private static boolean finish(int [] count){
        for(int i =0;i<count.length;i++){
            if(count[i]>0)
                return false;
        }
        return true;
    }
    private static void passTime(int [] time){
        for(int i =0;i<time.length;i++){
            if(time[i]>0)
                time[i]--;
        }
    }
    private static char findMax(int [] count, int [] time){
        int max = 0;
        int index = -1;
        for(int i =0;i<count.length;i++){
            if(time[i]==0){
                if(max<count[i]){
                    max=count[i];
                    index = i;
                }
            }
        }
        return (char)('A'+index);
    }
}