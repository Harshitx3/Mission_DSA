class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(st.isEmpty()){
            st.push((long)x);
            min = x;
        }
        else{
            if(x<min){
                long enc = 2L*x -min;
                min = x;
                st.push(enc);
            }else st.push((long)x);
        }
    }
    
    public void pop() {
        if(st.peek()<min){
            min = 2*min - st.pop();
        }
        else st.pop();
    }
    
    public int top() {
        return (st.peek()<min)?(int)min:st.peek().intValue();
    }
    
    public int getMin() {
        return (int)min;
    }
}

