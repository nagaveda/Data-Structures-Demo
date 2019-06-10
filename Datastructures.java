//Java program to demonstrate major data structures in java.
//importing necessary packages
import java.util.*;
import java.io.*;
// class for Array
 class Array{
    int arr[];
    int i;
    //constuctor for the class Array
    Array(int n){
        arr=new int[n];
        i=0;
    }
    //function for inserting elements to the array
    public void insert(int value){
        
        arr[i]=value;
        i++;
    }
    //function for returning the max value of the array
    public int max(int a[]){
        int i,j,t,n=a.length;
        for(i=0;i<n-1;i++){
            for(j=0;j<n-i-1;j++){
                if(a[j]<a[j+1]){
                    t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
        return a[0];
    }
    //function for returning the min value of the array
    public int min(int a[]){
        int i,j,t,n=a.length;
        for(i=0;i<n-1;i++){
            for(j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
        return a[0];
    }
    //function for printing the array
    public void printArray(){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
}
// class for node of the linkedlist
class Node{
    int value;
    Node next;
     //constructor for the class Node
      Node(int value){
      this.value=value;
      this.next=null;
    }
}

//class for Linked list
class Linkedlist{
       
    Node start;
    //Function for inserting nodes to the linked list
    public void insert(int value){
        Node current=start;
        while(current.next!=null){
            current=current.next;
        }
        Node newNode=new Node(value);
        current.next=newNode;
    }
    public void insertNode(int value,int value1){
        Node current=start;
        while(current.value!=value1){
            
            current=current.next;
        }
        Node newNode=new Node(value);
        newNode.next=current.next;
        current.next=newNode;
        
    }
    //Function for printing the Linkedlist
    public void printLinkedlist(){
        Node current=start;
        while(current!=null){
            System.out.println(current.value);
            current=current.next;
        }
    }
    //Function for deleting a node from the linkedlist
    public void delete(int value){
        if(start.value==value){
            start=start.next;
        }
        Node current=start;
        while(current.next.value!=value){
            
            current=current.next;
        }
        current.next=current.next.next;
    }
    //Function for searching for an element/node in a Linkedlist
    public void search(int value){
        Node current=start;
        while(current!=null){
            if(current.value==value){
                System.out.println("The element has been found in the Linked list");
                return;
            }
            current=current.next;
        }
        System.out.println("The element is not found in the Linked list");
    }
}
//class for Stack
class Stack{
    int stack[];
    int top;
    //constructor for the class Stack
    Stack(){
        stack=new int[100];
        top=-1;
    }
    //function for inserting elements to the stack i.e push
    public void push(int value){
        stack[++top]=value;
    }
    //function for removing an elemnts from the stack i.e., pop
    public void pop(){
        if(top==-1){
            System.out.println("The stack is empty..!");
            return;
        }
        top--;
    }
    //function for printing the stack
    public void printStack(){
        if(top==-1){
            System.out.println("The stack is empty..!");
            return;
        }
        for(int i=0;i<=top;i++){
            System.out.println(stack[i]);
        }
    }
    //function for searching for an element in the stack
    public void search(int value){
        for(int i=0;i<stack[top];i++){
            if(stack[i]== value){
                System.out.println("The element is found in the stack..");
                return;
            }
        }
        System.out.println("The element is not found in the stack..!");
    }
}

//class for Queue Data structure
class Queue{
    int queue[];
    int first;
    int last;
    //constructor for the class Queue to initialise it's members
    Queue(){
        queue=new int[100];
        first= -1;
        last= -1;
    }
    //function for inserting elements to the queue.
    public void enqueue(int value){
        if(first==-1){
            first++;
        }
        queue[++last]=value;

    }
    //function for deleting elements from the queue
    public void dequeue(){
        first++;
    }
    //function for printing the Queue.
    public void printQueue(){
        for(int i=first;i<=last;i++){
            System.out.println(queue[i]);
        }
    }
    //function for finding the position of an element in the queue
    public void search(int value){
        for(int i=first;i<=last;i++){
            if(queue[i] == value){
                if(first==0){
                    System.out.println("The element is found in  the position"+(i+1)+" in the queue.");  
                    return;
                }
                 if(i%first==0){
                    System.out.println("The element is found in  the position"+ (i/first)+" in the queue.");  
                    return;
                }
                else if(i%first!=0){
                    System.out.println("The element is found in the  position "+((i%first)+1)+" in the queue.");
                    return;
                }
            }

        }
        System.out.println("The element is not found in the queue..!");
    }
} 
//class for Binary search tree
class Binarytree{
    class Node{
        int value;
        Node left;
        Node right;
        //constructor for the class Node
        Node(int value){
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }
    //creating a Node
    Node root;
    //constructor for the class BinaryTree to initialise the node
    Binarytree(){
        root=null;
    }
    //function for inserting nodes to the tree
    public void insert(int value){
        root=insertValue(root, value);
    }
    //recursive function for traversing though the tree and get the position of te node to insert in the tree
    public Node insertValue(Node root,int value){
        if(root ==null){
            return new Node(value);
        }
        if(value > root.value){
            root.right=insertValue(root.right, value);
        }
        else if(value < root.value){
            root.left=insertValue(root.left, value);
        }
        return root;
    }
    //recursive function for printing the tree in preorder
    public void printPreorder(Node root){
        if(root ==null){
            return;
        }
        System.out.println(root.value);
        printPreorder(root.left);
        printPreorder(root.right);
    }
    //recursive function for printing the tree in inorder
    public void printInorder(Node root){
        if(root == null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.value);
        printInorder(root.right);
    }

    //recursive function for priniting the tree in post order
    public void printPostorder(Node root){
        if(root ==null){
            return;
        }
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.println(root.value);

    }
    //recursive function for searching for a node in the tree.
    public boolean search(Node root,int value){
        while(root!=null){
            if(value>root.value){
                root=root.right;
            }
            else if(value < root.value){
                root=root.left;
            }
            else{
                return true;
            }
        }
        return false;
    }
    //recursive function for getting the minimume value node of the tree
    public Node minValueNode(Node root){
        if(root.left == null){
            return root;
        }
        root.left=minValueNode(root.left);
        return root;

    }
    //recursive function for deleting node from the Binary tree
    public Node deleteNode(Node root,int value){
        if(root == null){
            return root;
        }
        if(value > root.value){
            root.right=deleteNode(root.right, value);
        }
        else if(value < root.value){
            root.left=deleteNode(root.left, value);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            Node temp=minValueNode(root.right);
            root.value = temp.value;
            root.right=deleteNode(root.right, temp.value);
        }
        return root;
    }
}

//class with main function.
public class Datastructures{
    
    //main function
    public static void main(String[] args) {
        //initialising the Scanner method
    Scanner in=new Scanner(System.in);
    System.out.println("Welcome..");
    System.out.println("This program is developed to demonstrate the major data structures "); 
    int choice;
    char r,r1,r2,r3,r4,r5;
    do{
        System.out.println("choose the data structure to be demonstarted:");
    System.out.println("1 for Array:");
    System.out.println("2 for Linked list:");
    System.out.println("3 for Stack:");
    System.out.println("4 for Queue:");
    System.out.println("5 for Binary search tree:");
    choice=in.nextInt();
    switch(choice){
        case 1:
        int n;
        System.out.println("You have choosen array, Let's create an array first. Enter the no of elements  ");
        n=in.nextInt();
        //creating an object for the class Array
        Array array=new Array(n);
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            array.insert(in.nextInt());
        }
        System.out.println("The array has been created, choose:");
        do{
        System.out.println("1 for finding max element of the array:");
        System.out.println("2 for minimum element of the array:");
        System.out.println("3 for printng the elements of the array:");
        int choice1=in.nextInt();
       
        switch(choice1){
            case 1:
            int max=array.max(array.arr);
            System.out.println("The highest element of the array is: "+max);
            break;
            case 2:
            int min=array.min(array.arr);
            System.out.println("The least element of the array is: "+min);
            break;
            case 3:
            array.printArray();
            break;
            default:
            System.out.println("Invalid Input...!!");
            break;
            
        }
        System.out.println("Do you want to repeat the array part:(y/n)");
        r1=in.next().charAt(0);
        }while(r1=='Y'||r1=='y');
        break;
        case 2:
        //creating an object for the class Linkedlist.
        Linkedlist linkedlist=new Linkedlist();
        System.out.println("You have choosen Linkedlist, First,let us create a Linked list. Enter no of elements u wanna enter into the linked list:");
        int n1=in.nextInt();
        System.out.println("Enter the starting node value:");
        linkedlist.start=new Node(in.nextInt());
        System.out.println("Enter the remaining elements:");
        for(int i=1;i<n1;i++){
            linkedlist.insert(in.nextInt());
        }
        System.out.println("The linkedlist has been created, choose:");
        do{
        System.out.println("1 for printing the Linkedlist:");
        System.out.println("2 for inserting nodes to the Linkedlist: ");
        System.out.println("3 for deleting nodes from the linkedlist:");
        System.out.println("4 for searching for an element in the linkedlist:");
        int choice2=in.nextInt();
        switch(choice2){
            case 1:
            System.out.println("The linkedlist is:");
            linkedlist.printLinkedlist();
            break;
            case 2:
            System.out.println("Enter the element u wanna enter to the linked list:");
            int ni=in.nextInt();
            System.out.println("Enter the element after which u wanna enter the node to the linked list:");
            int ni1=in.nextInt();
            linkedlist.insertNode(ni,ni1);
            System.out.println("The element has been added , new linkedlist is:");
            linkedlist.printLinkedlist();
            break;
            case 3:
            System.out.println("Enter the node to delete from the linkedlist:");
            linkedlist.delete(in.nextInt());
            System.out.println("The element has been deleted , new linkedlist is:");
            linkedlist.printLinkedlist();
            break;
            case 4:
            System.out.println("Enter the element/Node to search the linkedlist:");
            linkedlist.search(in.nextInt());
            break;
            default:
            System.out.println("Invalid Input..!!");
            break;
        }
        System.out.println("Do you want to repeat the Linkedlist part:(y/n)");
        r2=in.next().charAt(0);
    }while(r2=='Y'||r2=='y');
    break;
    case 3:
    //creating an object for the class Stack
    Stack stack=new Stack();
    System.out.println("You chose Stack, It's a Data structure that follows the principle Last in first out(LIFO) or first in last out(FILO)");
    System.out.println("First, let's create a Stack:");
    System.out.println("Enter the no of elements u wanna enter into the stack:");
    int n2=in.nextInt();
    System.out.println("Enter the elemnts:");
    for(int i=1;i<=n2;i++){
        stack.push(in.nextInt());
    }
    System.out.println("The stack has been created.choose:");
    do{
    System.out.println("1 for adding elements to the stack:");
    System.out.println("2 for removing elements to the stack:");
    System.out.println("3 for searching for an element in the stack:");
    System.out.println("4 for printing the stack:");
    int choice3=in.nextInt();
    switch(choice3){
        case 1:
        System.out.println("Enter the no of elements u wanna enter into the stack:");
        int s1=in.nextInt();
        System.out.println("Enter the elements:");
        for(int i=1;i<=s1;i++){
            stack.push(in.nextInt());
        }
        System.out.println("The elements have been added to the stack, the new stack is:");
        stack.printStack();
        break;
        case 2:
        System.out.println("Enter the no of elements u wanna delete from the stack:");
        int s2=in.nextInt();
        for(int i=1;i<=s2;i++){
            stack.pop();
        }
        System.out.println("The elements have been deleted from the stack, the new stack is:");
        stack.printStack();
        break;
        case 3:
        System.out.println("Enter the element u wanna search in the stack:");
        stack.search(in.nextInt());
        break;
        case 4:
        System.out.println("The stack is :");
        stack.printStack();
        break;
        default:
        System.out.println("Invalid input..!");
        break;
    }
    System.out.println("Do u want to repeat the stack part:(Y/N)");
    r3=in.next().charAt(0);
    }while(r3=='Y'||r3=='y');
    break;
    case 4:
    //creating the object for the class Queue
    Queue queue=new Queue(); 
    System.out.println("You have choosen Queue,Its a linear data structure that follows the principle last in last out (or) first in first out.");
    System.out.println("First, let's create a Queue:");
    System.out.println("Enter the no of elements u wanna enter into the queue:");
    int n3=in.nextInt();
    System.out.println("Enter the elements :");
    for(int i=1;i<=n3;i++){
        queue.enqueue(in.nextInt());
    }
    System.out.println("The Queue has been created.choose:");
    do{
    System.out.println("1 for adding elements to the queue:");
    System.out.println("2 for removing elements from the queue:");
    System.out.println("3 for searching for an element in the queue:");
    System.out.println("4 for printing the queue:");
    int choice4=in.nextInt();
    switch(choice4){
        case 1:
        System.out.println("Enter the no of elements u wanna add to the queue:");
        int q1=in.nextInt();
        System.out.println("Enter the elements:");
        for(int i=1;i<=q1;i++){
            queue.enqueue(in.nextInt());
        }
        System.out.println("The elements have been added to the queue, new queue is:");
        queue.printQueue();
        break;
        case 2:
        System.out.println("Enter the no of elements u wanna remove from the queue:");
        int q2=in.nextInt();
        for(int i=1;i<=q2;i++){
            queue.dequeue();
        }
        System.out.println("The elements have been removed from the queue, new queue is:");
        queue.printQueue();
        break;
        case 3:
        System.out.println("Enter the element to search in the queue:");
        queue.search(in.nextInt());
        break;
        case 4:
        System.out.println("The Queue is:");
        queue.printQueue();
        break;
        default:
        System.out.println("Invalid input..!");
        break;
        
    }
    System.out.println("Do u want to repeat the Queue part:(Y/N)");
    r4=in.next().charAt(0);
    }while(r4=='Y'||r4=='y');
    break;
    case 5:
    //creating an object for the class BinaryTree
    Binarytree tree=new Binarytree();
    System.out.println("You have chosen Binary search tree.It's a Non-Linear data structure.");
    System.out.println("First let us create a Binary tree.Enter no of nodes u wanna enter into the tree:");
    int n4=in.nextInt();
    System.out.println("Enter the node elements to the tree:");
    for(int i=1;i<=n4;i++){
        tree.insert(in.nextInt());
    }
    System.out.println("The Tree has been created. choose:");
    do{
    System.out.println("1 for inserting nodes to the tree:");
    System.out.println("2 for deleting nodes from the tree:");
    System.out.println("3 for printing the tree in preorder:");
    System.out.println("4 for printing the tree in inorder:");
    System.out.println("5 for priniting the tree in postorder:");
    System.out.println("6 for searching for a node in the binary tree:");
    int choice5=in.nextInt();
    switch(choice5){
        case 1:
        System.out.println("Enter the node:");
        tree.insert(in.nextInt());
        System.out.println("The node has been inserted to the tree. new tree in preorder is:");
        tree.printPreorder(tree.root);
        break;
        case 2:
        System.out.println("Enter the node to delete from the tree:");
        tree.deleteNode(tree.root, in.nextInt());
        System.out.println("The node has been deleted from the tree. The updated tree in preorder is as follows:");
        tree.printPreorder(tree.root);
        break;
        case 3:
        System.out.println("The tree in preorder is:");
        tree.printPreorder(tree.root);
        break;
        case 4:
        System.out.println("The tree in inorder is:");
        tree.printInorder(tree.root);
        break;
        case 5:
        System.out.println("The tree in postorder is:");
        tree.printPostorder(tree.root);
        break;
        case 6:
        System.out.println("Enter the node u wanna search in the binary tree:");
        int s3=in.nextInt();
        if(tree.search(tree.root, s3)){
            System.out.println("The node is found in the tree..");
        }
        else{
            System.out.println("The nodes/eleemnt is not found in the tree..!");
        }
        break;
        default:
        System.out.println("Invalid input..!");
        break;

    }
    System.out.println("Do u wanna repeat the Tree part:(Y/N)");
    r5=in.next().charAt(0);
    }while(r5=='Y'||r5=='y');

    }
    System.out.println("Press Y to go to Datastructures panel , any other key to Exit..!");
     r=in.next().charAt(0);
    }while(r=='Y'||r=='y');
    System.out.println("Thanks for trying this program:-)");
    System.out.println("This program is develped by Nagaveda for demonstrating the major datastructures in Java..");
       
    }
}   