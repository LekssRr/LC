package binaryThree;

import java.util.*;

public class HandelThree {

    public List<Integer> traversProcessed(Node root){
        List<Integer> res = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            res.add(poll.value);
            if(poll.left!=null){
                queue.offer(poll.left);
            }
            if(poll.right!=null){
                queue.offer(poll.right);
            }
        }
        return res;
    }
    public List<Integer> traversProcessedRight(Node root){
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            res.add(stack.pop().value);
            if (pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }
        }
        return res;
    }
    public List<Integer> traversProcessedLeft(Node root){
        List<Integer> res = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        Node current = root;
        while (current!=null || !stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.add(current.value);
            current=current.right;
        }
        return res;
    }
}
