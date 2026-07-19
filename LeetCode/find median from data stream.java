import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> left;  // Max-Heap (stores smaller half)
    private PriorityQueue<Integer> right; // Min-Heap (stores larger half)

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
      
        if (left.size() == right.size()) {
            if (left.size() == 0 && right.size() == 0) {
                left.offer(num);
                return;
            }
            left.offer(num);
           
            while (!right.isEmpty() && !(left.peek() <= right.peek())) {
                swap();
            }
        } 
       
        else if (left.size() - right.size() == 1) {
            right.offer(num);
            
            while (!(left.peek() <= right.peek())) {
                swap();
            }
        }
    }
    
    public double findMedian() {
        int n = left.size() + right.size();
     
        if (n % 2 == 1) {
            return left.peek();
        } 
     
        else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }

   
    private void swap() {
        int leftTop = left.poll();
        int rightTop = right.poll();
        left.offer(rightTop);
        right.offer(leftTop);
    }
}