class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> overlapBookings;

    // Return true if the booking [start1, end1) & [start2, end2) overlaps.
    private boolean doesOverlap(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

    // Return overlapping booking between [start1, end1) & [start2, end2).
    private int[] getOverlapped(int start1, int end1, int start2, int end2) {
        return new int[] { Math.max(start1, start2), Math.min(end1, end2) };
    }

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlapBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Returns false if the new booking has an overlap
        // with the existing double-booked bookings.
        for (int[] booking : overlapBookings) {
            if (doesOverlap(booking[0], booking[1], start, end)) {
                return false;
            }
        }

        // Add the double overlapping bookings if any with the new booking.
        for (int[] booking : bookings) {
            if (doesOverlap(booking[0], booking[1], start, end)) {
                overlapBookings.add(
                    getOverlapped(booking[0], booking[1], start, end)
                );
            }
        }

        // Add the new booking to the list of bookings.
        bookings.add(new int[] { start, end });
        return true;
    }
//     List<int []> events;
//     List<List<int []>> intersections;
//     List<int []> tmpForward;
//     List<int []> tmpBackward;
//     public MyCalendarTwo() {
//         events = new ArrayList<>();
//         intersections = new ArrayList<>();
//     }

//     public boolean book(int start, int end) {
//         if(events.size() == 0){
//             events.add(new int []{start, end});
//             intersections.add(new ArrayList<>());
//         }
//         else{
//             tmpForward = new ArrayList<>();
//             tmpBackward = new ArrayList<>();
//             int [] newEvent = new int[]{start, end};
//             int index = findIndex(newEvent);
//             for(int i = index; i<events.size();i++){
//                 int [] currentEvent = events.get(i);
//                 if(checkIntersection(newEvent, intersections.get(i))){
//                     return false;
//                 }
//                 if(checkIntersection(newEvent, events.get(i))){
//                     int [] intersection = new int [] {Math.max(newEvent[0], currentEvent[0]), Math.min(newEvent[1], currentEvent[1])};
//                     tmpForward.add(intersection);
//                 }
//                 else{
//                     break;
//                 }
//             }
//             for(int i = index-1; i>=0;i--){
//                 int [] currentEvent = events.get(i);
//                 if(checkIntersection(newEvent, intersections.get(i))){
//                     return false;
//                 }
//                 if(checkIntersection(newEvent, events.get(i))){
//                     int [] intersection = new int [] {Math.max(newEvent[0], currentEvent[0]), Math.min(newEvent[1], currentEvent[1])};
//                     tmpBackward.add(intersection);
//                 }
//                 else{
//                     break;
//                 }
//             }
//             for(int i = index;i<index+tmpForward.size();i++){
//                 intersections.get(i).add(tmpForward.get(i-index));
//             }
//             for(int i = 0;i<tmpBackward.size();i++){
//                 intersections.get(index-1-i).add(tmpBackward.get(i));
//             }
//             events.add(index, newEvent);
//             tmpBackward.addAll(tmpForward);
//             intersections.add(index, tmpBackward);
//         }
//         return true;
//     }
//     public boolean checkIntersection(int [] newEvent, List<int []> eventIntersections){
//         for(int i = 0;i<eventIntersections.size();i++){
//             if(checkIntersection(newEvent, eventIntersections.get(i))){
//                 return true;
//             }
//         }
//         return false;
//     }
//     public boolean checkIntersection(int [] newEvent, int [] event){
//         if(newEvent[0]>=event[1] || newEvent[1]<=event[0])
//             return false;
//         return true;
//     }
//     public int findIndex(int [] event){
//         int start = 0;
//         int end = events.size();
//         while(start<end){
//             int mid = (end-start)/2 + start;
//             int [] element = events.get(mid);
//             if(element[0] < event[0]){
//                 start = mid + 1;
//             }
//             else if(element[0] > event[0]){
//                 end = mid;
//             }
//             else{
//                 if (element[1] < event[1]) {
//                     start = mid + 1;
//                 } else {
//                     end = mid;
//                 }
//             }
//         }
//         return start;
//     }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */