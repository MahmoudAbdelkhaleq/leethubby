class MyCalendar {
    List<Integer []> events;
    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(events.size() == 0){
            events.add(new Integer[]{start, end});
            return true;
        }
        int index = findIndex(start);
        if(index == -1 || (index>0 && events.get(index-1)[1]>start) || (index<events.size() && events.get(index)[0]<end)) 
            return false;
        insert(new Integer[]{start, end}, index);
        return true;
    }
    int findIndex(int val){
        int start = 0;
        int end = events.size()-1;
        while(start<=end){
            int mid = (end-start)/2 + start;
            int element = events.get(mid)[0];
            if(element == val) 
                return -1;
            if(element>val){
                if(mid == 0 || events.get(mid-1)[0]<val){
                    return mid;
                }
                else{
                    end = mid-1;
                }
            }
            else{
                if(mid == events.size()-1 || events.get(mid+1)[0]>val){
                    return mid+1;
                }
                else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
    void insert(Integer [] event, int index){
        events.add(index, event);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */