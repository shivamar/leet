import java.util.Stack;

//push pop and peek of queue work as required
//soln-use 2 stacks!
public class ImplementQueueFromStacks {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    Integer top = null;
    // Push element x to the back of queue.
    public void push(int x) {
        st1.push(x);
        if(top==null) top=x;
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(st2.isEmpty() && !st1.isEmpty()){
           while(!st1.isEmpty())
            st2.push(st1.pop());
        }
        
        st2.pop();
        if(!st2.isEmpty())top = st2.peek();
        else if(!st1.isEmpty()){
             while(!st1.isEmpty())
                st2.push(st1.pop());
            
            top = st2.peek();
        }
        else{
          top = null;  
        } 
    }

    // Get the front element.
    public int peek() {
        if(top!=null)return top;
        else return -1;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}