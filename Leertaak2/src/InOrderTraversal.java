import java.util.Stack;


public class InOrderTraversal 
{
	static Node root;
	static Node current;
	static Stack<Node> stack = new Stack<Node>();
	
	public static void main(String[] args)
	{
		InOrderTraversal.addNode(50, "Harry");
		InOrderTraversal.addNode(20, "Pieter");
		InOrderTraversal.addNode(60, "Jan");
		InOrderTraversal.addNode(40, "Arnold");
		InOrderTraversal.addNode(90, "Hans");
		InOrderTraversal.addNode(10, "Nelleke");
		InOrderTraversal.addNode(55, "Jenny");
		
		System.out.println("\nIn-order traversal   : ");
		inOrderTraversal(root);
		
		System.out.println("\nPre-order traversal  : ");
		preOrderTraversal(root);
		
		System.out.println("\nPost-order traversal : ");
		postOrderTraversal(root);
	}
	
	private static void inOrderTraversal(Node current)
	{
		while(current != null || !stack.isEmpty()){
		  if(current != null){
		    stack.push(current);
		    current = current.leftChild;  
		  } 
		  else{ 
			 if(!stack.isEmpty()){
				 current = stack.pop();
				 System.out.println("Node with key "+current.key+" & Value "+current.value);
				 current =  current.rightChild;
			  }
		  } 
		}	
	}
	
	private static void preOrderTraversal(Node current)
	{
		while(current != null || !stack.isEmpty()){
		  if(current != null){
		    stack.push(current);
			System.out.println("Node with key "+current.key+" & Value "+current.value);
		    current = current.leftChild;  
		  } 
		  else {
			  if(!stack.isEmpty()){ 
			    current = stack.pop();
			    current = current.rightChild;
			  }
		  }
		}
	}
	
	static void postOrderTraversal(Node root)
	{
	    // Check for empty tree
	    if (root == null)
	        return;
	    do
	    {
	        // Move to leftmost node
	        while (root!=null)
	        {
	            // Push root's right child and then root to stack.
	            if (root.rightChild != null)
	               stack.push(root.rightChild);
	               stack.push(root);
	 
	            // Set root as root's left child 
	               root = root.leftChild;
	        }
	 
	        // Pop an item from stack and set it as root   
	        root = stack.pop();
	 
	        // If the popped item has a right child and the right child is not
	        // processed yet, then make sure right child is processed before root
	        if (root.rightChild!=null && !stack.isEmpty() &&stack.peek() == root.rightChild)
	        {
	            stack.pop();  // remove right child from stack
	            stack.push(root);  // push root back to stack
	            root = root.rightChild; // change root so that the right
	                                // child is processed next
	        }
	        else  // Else print root's data and set root as NULL
	        {
	        	System.out.println("Node with key "+root.key+" & Value "+root.value);
	            root = null;
	        }
	    } while (!stack.isEmpty());
	}
	

		 
	private static void addNode(int key, String value)
	{
		  Node newNode = new Node(key, value);
		  
		  if(root==null){
			  root = newNode;
		  }
		  else{
			  Node currentNode = root;
			  Node parent;
			  
			  while(true){
				  parent = currentNode;
				  
				  if(key < currentNode.key){
					  currentNode = currentNode.leftChild;
					 
					  if(currentNode == null){	
						  parent.leftChild = newNode;
						  parent.leftChild.parentkey = parent.key;
						  System.out.println("Child key : "+parent.leftChild.key+" has parent key "+ parent.leftChild.parentkey);
						  return;
					  }
				  }
				  else{
					  currentNode = currentNode.rightChild;
					  if(currentNode == null){
						  parent.rightChild = newNode;
						  parent.rightChild.parentkey = parent.key;
						  System.out.println("Child key : "+parent.rightChild.key+" has parent key "+ parent.rightChild.parentkey);
						  return;
					  }
				  }
			  }
		  }
	}
	
	private static class Node 
	{
	    int key;
	    String value;
	 
	    Node leftChild;
	    Node rightChild;
	    int parentkey;
	    boolean isVisited;
	    
	    Node(int key, String value){ 
		    this.key = key;
		    this.value = value;
		}
	}
}
