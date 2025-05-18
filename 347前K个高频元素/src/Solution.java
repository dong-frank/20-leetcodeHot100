import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }

        //建堆
        int[][] maxHeap = new int[hashMap.size()+1][2];
        int currentSize = 0;
        for(int key : hashMap.keySet()){
            currentSize++;
            maxHeap[currentSize][0] = hashMap.get(key);
            maxHeap[currentSize][1] = key;
            int node = currentSize;
            while (node >1){
                if(maxHeap[node/2][0] < maxHeap[node][0]){
                    int tmp = maxHeap[node/2][0];
                    maxHeap[node/2][0] = maxHeap[node][0];
                    maxHeap[node][0] = tmp;
                    tmp = maxHeap[node/2][1];
                    maxHeap[node/2][1] = maxHeap[node][1];
                    maxHeap[node][1] = tmp;
                    node /=2;
                }else {
                    break;
                }
            }
        }

        //堆排序
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = maxHeap[1][1];
            int theLastElement = maxHeap[currentSize][0];
            int root = 1;
            int node = 2;
            maxHeap[root][0] = theLastElement;
            maxHeap[root][1] = maxHeap[currentSize][1];
            currentSize--;
            while (node <= currentSize){
                if(node < currentSize && maxHeap[node][0] < maxHeap[node+1][0]){
                    node++;
                }
                if(maxHeap[node][0] > maxHeap[root][0]){
                    int tmp = maxHeap[root][0];
                    maxHeap[root][0] = maxHeap[node][0];
                    maxHeap[node][0] = tmp;
                    tmp = maxHeap[root][1];
                    maxHeap[root][1] = maxHeap[node][1];
                    maxHeap[node][1] = tmp;
                    root=node;
                    node*=2;
                }else {
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.topKFrequent(new int[]{1,1,1,2,2,3}, 5);
    }
}
