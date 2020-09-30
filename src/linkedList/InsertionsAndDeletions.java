package linkedList;

import java.util.Stack;

public class InsertionsAndDeletions {

	public static void main(String[] args) {
		
		DCLL dcll = new DCLL();
		
		dcll.insertAtEnding(1);
		dcll.insertAtEnding(2);
		dcll.insertAtEnding(3);
		dcll.insertAtEnding(4);
		dcll.insertAtBeginning(0);
		dcll.deleteAtBeginning();
		dcll.deleteAtEnding();
		dcll.insertAtEnding(4);
		dcll.insertAtBeginning(0);
		dcll.deleteAtBeginning();
		dcll.deleteAtEnding();
		
		dcll.traverseForward();
	}
}
class SLL
{
	Node head;
	Node tail;
	int listSize;
	
	public SLL() {
		
	}
	
	public int size() {
		return listSize;
	}
	
	public void insertAtEnd(int data) {
		
		Node node = new Node(data);
		
		if(head==null)
		{
			head = node;
			tail = node;
			listSize++;
		}
		else
		{
			Node temp = head;
			
			while (temp.next!=null) {
				temp = temp.next;
			}
			temp.next = node;
			tail = temp.next;
			listSize++;
		}
	}
	
	public void insertAtBeginning(int data) {
		
		Node node = new Node(data);
		
		if(head==null)
		{
			head = node;
			tail = node;
			listSize++;
		}
		else
		{
			node.next = head;
			head = node;
			listSize++;
		}
	}
	
	public void insertAt(int data, int index) {
		
		Node node = new Node(data);
		
		if(head==null)
		{
			head = node;
			tail = node;
			listSize++;
		}
		else
		{
			if(index==0)
				insertAtBeginning(data);
			
			else if(index>=listSize)
				insertAtEnd(data);
			
			else
			{
				Node temp = head;
				int count = 0;
				
				while (temp!=null) {
					
					temp = temp.next; count++;
					if(count==index-1)
					{
						Node t = temp;
						node.next = temp.next;
						temp.next = node;
						listSize++;
						break;
					}
				}
			}
		}
	}
	
	public void deleteAtBeginning() {
		
		if(head==null)
			return;
		else
		{
			head = head.next;
			listSize--;
		}
	}
	
	public void deleteAtEnding() {
		
		if(head==null)
			return;
		else
		{
			Node temp = head;
			while (temp.next!=null) {
				temp = temp.next;
				
				if(temp.next.next==null)
				{
					tail.next = temp.next;
					tail = temp;
					listSize--;
					break;
				}
			}
		}
	}
	
	public void deleteAt(int index) {
		
		if(head==null)
			return;
		else
		{
			if(index==0)
				deleteAtBeginning();
			
			else if(index>=listSize)
				deleteAtEnding();
			
			else
			{
				Node temp = head;
				int count = 0;
				
				while (temp!=null) {
					temp = temp.next; count++;
					if(count==index-1)
					{
						temp.next = temp.next.next;
						listSize--;
						break;
					}
				}
			}
		}
	}
	
	public void traverseList() {
		
		if(head==null)
			return;
		else
		{
			Node temp = head;
			System.out.println();
			while (temp!=null) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
			System.out.println();
		}
	}
	
	public void reverseList() {
		
		
		  if(head==null) 
			  return; 
		  else 
		  { 
			  Node temp = head; 
			  Node next = null;
			  Node previous = null;
		 
			  while (temp!=null) {
				 
				  next = temp.next; 
				  temp.next = previous; 
				  previous = temp; 
				  temp = next; 
			  } 
		  	head = previous;
		 }
	}
	
	public boolean doesValueExist(int value) {
		
		if(head==null)
			return false;
		else
		{
			Node temp = head;
			while (temp!=null) 
			{
				if(temp.data==value)
					return true;
				temp = temp.next;
			}
			return false;
		}
	}
	
	public void getElementAt(int index) {
		
		if(head==null)
			return;
		else
		{
			if(index==0)
				System.out.println(head.data);
			
			else if(index>=listSize)
			{
				Node temp = head;
				
				while (temp.next!=null) {
					temp = temp.next;
				}
				System.out.println(temp.data);
			}
			else
			{
				Node temp = head;
				int count = 0;
				
				while (temp!=null) {
					temp = temp.next;
					count++;
					
					if(count==index-1)
						System.out.println(temp.data);
				}
			}
		}
	}
}
class DLL
{
	Node head;
	Node tail;
	int listSize;
	
	public int size() {
		return listSize;
	}
	
	public void insertAtEnd(int data) {
		
		Node node = new Node(data);
		
		if(head==null)
		{
			head = node;
			tail = node;
			listSize++;
		}
		else
		{
			Node temp = head;
			
			while (temp.next!=null) {
				temp = temp.next;
			}
			temp.next = node;
			tail = temp.next;
			listSize++;
		}
	}
	
	public void insertAtBeginning(int data) {
		
		Node node = new Node(data);
		
		if(head==null)
		{
			head = node;
			tail = node;
			listSize++;
		}
		else
		{
			node.next = head;
			head = node;
			listSize++;
		}
	}
	
	public void insertAt(int data, int index) {
		
		Node node = new Node(data);
		
		if(head==null)
		{
			head = node;
			tail = node;
			listSize++;
		}
		else
		{
			if(index==0)
				insertAtBeginning(data);
			
			else if(index>=listSize)
				insertAtEnd(data);
			
			else
			{
				Node temp = head;
				int count = 0;
				
				while (temp!=null) {
					
					temp = temp.next; count++;
					if(count==index-1)
					{
						Node t = temp;
						node.next = temp.next;
						temp.next = node;
						listSize++;
						break;
					}
				}
			}
		}
	}
	
	public void deleteAtBeginning() {
		
		if(head==null)
			return;
		else
		{
			head = head.next;
			listSize--;
		}
	}
	
	public void deleteAtEnding() {
		
		if(head==null)
			return;
		else
		{
			Node temp = head;
			while (temp.next!=null) {
				temp = temp.next;
				
				if(temp.next.next==null)
				{
					tail.next = temp.next;
					tail = temp;
					listSize--;
					break;
				}
			}
		}
	}
	
	public void deleteAt(int index) {
		
		if(head==null)
			return;
		else
		{
			if(index==0)
				deleteAtBeginning();
			
			else if(index>=listSize)
				deleteAtEnding();
			
			else
			{
				Node temp = head;
				int count = 0;
				
				while (temp!=null) {
					temp = temp.next; count++;
					if(count==index-1)
					{
						temp.next = temp.next.next;
						listSize--;
						break;
					}
				}
			}
		}
	}
	
	public void traverseList() {
		
		if(head==null)
			return;
		else
		{
			Node temp = head;
			System.out.println();
			while (temp!=tail) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
			System.out.println(temp.data);
			System.out.println();
		}
	}
	
	public void reverseList() {
		
		  if(head==null) 
			  return; 
		  else 
		  { 
			  Node temp = null; 
			  Node current = head;
		  
			  while (current.previous!=null) {
		  
				  temp = current.previous;
				  current.previous = current.next; 
				  current.next = temp;
				  current = current.previous;
			}   
			  head = current;
			  
			  Node t = head;
			  while (t!=null) {
				System.out.print(t.data+" ");
				  t = t.previous;
			}
			  System.out.println("\n");
	}
		 
		
		if(head==null)
			return;
		
		Stack<Integer> stack = new Stack<>();
		
		Node temp = head;
		while (temp!=tail) {
			stack.push(temp.data);
			temp = temp.next;
		}
		stack.push(temp.data);
		
		while (!stack.isEmpty())
			System.out.print(stack.pop()+" ");
	}
	
	public boolean doesValueExist(int value) {
		
		if(head==null)
			return false;
		else
		{
			Node temp = head;
			while (temp!=null) 
			{
				if(temp.data==value)
					return true;
				temp = temp.next;
			}
			return false;
		}
	}
	
	public void getElementAt(int index) {
		
		if(head==null)
			return;
		else
		{
			if(index==0)
				System.out.println(head.data);
			
			else if(index>=listSize)
			{
				Node temp = head;
				
				while (temp.next!=null) {
					temp = temp.next;
				}
				System.out.println(temp.data);
			}
			else
			{
				Node temp = head;
				int count = 0;
				
				while (temp!=null) {
					temp = temp.next;
					count++;
					
					if(count==index-1)
						System.out.println(temp.data);
				}
			}
		}
	}
}
class SCLL
{
	Node head;
	Node tail;
	int listSize;
	
	public SCLL() {
		
	}
	
	public int size() {
		return listSize;
	}
	
	public void insertAtEnding(int data) {
		
		Node node = new Node(data);
		
		if(head==null)
		{
			head = node;
			node.next = head;
			tail = node;
			listSize++;
		}
		else
		{
			if(tail!=null)
			{
				node.next = head;
				tail.next = node;
				tail = node;
				listSize++;
			}
		}
	}
	
	public void insertAtBeginning(int data) {
		
		Node node = new Node(data);
		
		if(head==null)
		{
			head = node;
			node.next = head;
			tail = node;
			listSize++;
		}
		else
		{
			if(tail!=null)
			{
				tail.next = node;
				node.next = head;
				head = node;
				listSize++;
			}
		}
	}
	
	public void deleteBeginning() {
		
		if(head==null)
			return;
		else
		{
			if(tail!=null)
			{
				head = head.next;
				tail.next = head;
				listSize--;
			}
		}
	}
	
	public void deleteEnding() {
		
		if(head==null)
			return;
		
		else if(head.next==head)
		{
			head = null;
			listSize--;
		}
		
		else if(head.next.next==head)
		{
			head = head.next;
			listSize--;
		}
		else
		{
			Node temp = head;
			
			while (temp!=tail) {
				
				if(temp.next==tail)
				{
					temp.next = head;
					tail = temp;
					listSize--;
					break;
				}
				temp = temp.next;
			}
		}
	}
	
	public void traversal() {
		
		if(head==null)
			return;
		
		else if(head.next==head)
			System.out.print(head.data+" ");
		else
		{
			Node temp = head;
		
			while (temp!=tail) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
			System.out.println(temp.data+" ");
			System.out.println();
		}
	}
	
	public void reverseList() {
		
		if(head==null)
			return;
		
		else if(head.next==head)
			System.out.println(head.data);
		else
		{
			Node current = head;
			Node next = null;
			Node previous = tail;
			System.out.print(previous.data+" ");
			
			while (current!=tail) {
				
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
			head = previous;
			current.next = head;
			tail = current;
			
			Node t = head; 
			
			while (t!=tail) {
				System.out.print(t.data+" ");
				t = t.next;
			}
			System.out.println("\n");
		}
	}
}
class DCLL
{
	Node head;
	Node tail;
	int listSize;
	
	public int size() {
		return listSize;
	}
	
	public void insertAtEnding(int data) {
		
		Node node = new Node(data);
		
		if(head==null)
		{
			head = node;
			node.next = head;
			tail = node;
			head.previous = tail;
			listSize++;
		}
		else
		{
			if(tail!=null)
			{
				tail.next = node;
				node.next = head;
				head.previous = node;
				tail = node;
				listSize++;
			}
		}
	}
	
	public void insertAtBeginning(int data) {
		
		Node node = new Node(data);
		
		if(head==null)
		{
			head = node;
			node.next = head;
			tail = node;
			head.previous = tail;
			listSize++;
		}
		else
		{
			if(tail!=null)
			{
				tail.next = node;
				node.next = head;
				node.previous = tail;
				head = node;
				listSize++;
			}
		}
	}
	
	public void deleteAtBeginning() {
		
		if(head==null)
			return;
		
		else if(head.next==head || head.previous==head)
			head = null;
		
		else
		{
			head = head.next;
			tail.next = head;
			head.previous = tail;
			listSize--;
		}
	}
	
	public void deleteAtEnding() {
		
		if(head==null && tail==null)
			return;
		
		else if(head.next==head || head.previous==head)
			head=null;
		
		else
		{
			Node temp = head;
			
			while (temp!=tail) {
				temp = temp.next;
				if(temp.next==tail)
				{
					tail = temp;
					tail.next = head;
					head.previous = tail;
					listSize--;
					break;
				}
			}
		}
	}
	
	public void traverseForward() {
		
		if(head==null)
			return;
		
		else if(head.next==head || head.previous==head)
			System.out.print(head.data+" ");
		
		else
		{
			Node temp = head;
			
			while (temp!=tail) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
			System.out.println(temp.data);
			System.out.println();
		}
	}
	
	public void traverseBackward() {
		
		if(head==null && tail==null)
			return;
		
		else if(head.next==head || head.previous==head)
			System.out.println(head.data);
		
		else
		{
			Node temp = null;
			Node current = head;
			
			while (current!=tail) {
				
				temp = current.next;
				current.next = current.previous;
				current.previous = temp;
				current = current.previous;
			}
			temp = head;
			head = tail;
			tail = temp;
		
			traverseForward();
		}
	}
}