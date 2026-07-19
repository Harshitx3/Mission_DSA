class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Stack<Integer>s = new Stack<>();
        for(int i = 2*n-1;i>=0;i--){
            int newidx = i%n;
            int curr = nums[newidx];
        
        
        while(!s.isEmpty()  && s.peek()<= curr){
            s.pop();
        }

        if(i<n){
            if (s.isEmpty()) {
                    ans[newidx] = -1;
                } else {
                    ans[newidx] = s.peek();
                }
        }

        s.push(curr);
    }

    return ans;
}}