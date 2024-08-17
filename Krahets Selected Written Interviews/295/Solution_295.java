import java.util.PriorityQueue;
import java.util.Collections;

/**The median is the middle value in an ordered list of integers. 
 * If the size of the list is even, there is no median and the median is the average of the two middle values. 
 * - For example, the median of arr = [2,3,4] is 3.
 *  - For example, the median of arr = [2,3] is (2 + 3) / 2 = 2.5.  
 * Implement MedianFinder class: 
 * - MedianFinder() Initialize MedianFinder object.  
 * - void addNum(int num) Adds the integer num from the data stream to the data structure.  
 * - double findMedian() Returns the median of all elements so far. 
 * Answers within 10-5 of the actual answer will be accepted.   
 * Input:
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output:
 * [null, null, null, 1.5, null, 2.0] 
 * */
public class Solution_295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder{

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;


    public MedianFinder(){
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    public void addNum(int num){
        if(left.isEmpty() || num <= left.peek()){
            left.offer(num);
        }else{
            right.offer(num);
        }

        // 平衡两个堆的大小
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        } else if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian(){
        // if(left.size() == right.size()){
        //     return (left.peek() + right.peek()) / 2.0;
        // }
        if (left.size() > right.size()) {
            return left.peek();
        } else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }   
}