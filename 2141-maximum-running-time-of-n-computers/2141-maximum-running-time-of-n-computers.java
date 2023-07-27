class Solution {
    public long maxRunTime(int n, int[] batteries){
        // Arrays.sort(batteries);
        // long extra = 0;
        // for(int i = 0;i<batteries.length-n;i++){
        //     extra+=batteries[i];
        // }
        // long remain = 0;
        // int index = batteries.length-1;
        // int max = batteries[index];
        // for(int i = batteries.length-2;i>=batteries.length-n;i--){
        //     remain+=(max-batteries[i]);
        // }
        // while(remain>extra){
        //     index--;
        //     remain = remain + (batteries[index]-max)*(n-1);
        //     max = batteries[index];
        //     n--;
        // }
        // if(index == batteries.length-1) return batteries[index] + (extra-remain)/n;
        // if(remain == 0) return batteries[index] + extra;
        // return batteries[index];
         Arrays.sort(batteries);
        long extra = 0;
        for (int i = 0; i < batteries.length - n; i++) {
            extra += batteries[i];
        }

        // live stands for the n largest batteries we chose for n computers.

        int[] live = Arrays.copyOfRange(batteries, batteries.length - n, batteries.length);

        // We increase the total running time using 'extra' by increasing 
        // the running time of the computer with the smallest battery.
        for (int i = 0; i < n - 1; i++) {
            // If the target running time is between live[i] and live[i + 1].
            if (extra < (long)(i + 1) * (live[i + 1] - live[i])) {
                return live[i] + extra / (long)(i + 1);
            }

            // Reduce 'extra' by the total power used.
            extra -= (long)(i + 1) * (live[i + 1] - live[i]);
        }

        // If there is power left, we can increase the running time 
        // of all computers.
        return live[n - 1] + extra / n;
    }
}