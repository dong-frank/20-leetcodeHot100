public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] maxHeap = new int[nums.length + 1]; //下标0不使用, 1为根
        int currentSize =0;
        //建堆
        for(int i=0; i<nums.length;i++){
            //自底向上
            currentSize++;
            maxHeap[currentSize] = nums[i];
            //上滤
            int node = currentSize;
            while (node > 1 && maxHeap[node/2] < maxHeap[node]){
                int tmp = maxHeap[node];
                maxHeap[node] = maxHeap[node/2];
                maxHeap[node/2] = tmp;
                node /=2;
            }
        }

        int ans = maxHeap[1];
        //返回第K个值
        for(int i=1; i<k; i++){
            int theLastElement = maxHeap[currentSize];
            int root=1;
            int node=2;
            maxHeap[root] = theLastElement; //把最后一个节点放到根节点
            currentSize--;
            while (node<=currentSize){
                if(node<currentSize && maxHeap[node] < maxHeap[node+1]){
                    node++;
                }
                if(maxHeap[node] > maxHeap[root]){
                    int tmp = maxHeap[node];
                    maxHeap[node] = maxHeap[root];
                    maxHeap[root] = tmp;
                    root = node;
                    node *=2;
                }else {
                    break;
                }
            }
            ans = maxHeap[1];
        }

        return ans;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.findKthLargest(new int[]{7,6,5,4,3,2,1}, 5);
    }
}
