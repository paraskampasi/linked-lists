package linkedlist;

import linkedlist.create.Node;

public class merge
{
	Node head;
    

	static class Node 
					{

					int item;
					Node next;
					Node(int data)
						{
							item=data;	
							next=null;
						}
					}
	
	public static Node merger(Node head1,Node head2,Node head3)// Function to merge two sorted Linked lists
	               {
		              Node temp1=head1, temp2=head2, temp3=head3;
		              
	                  while(temp1!=null||temp2!=null)
	                  {
	                	  if(temp1!=null&&temp2!=null)
	                	  {
	                		  if(temp1.item<temp2.item)
	                	  
	                		  {
	                			  temp3.next=temp1;
	                			  temp1=temp1.next;  
	                		  }
	                		  else               		  
	                		  {   
	                			  temp3.next=temp2;
	                			  temp2=temp2.next;
	                		  }
	                		    temp3=temp3.next;     
	                	  }
	                  else if(temp2==null)
	                		  {
	                		  temp3.next=temp1;
	                		  temp3=temp3.next;
	                		  temp1=temp1.next;
	                		  } 
	                		
	                	  else if(temp1==null)
	                		  {
	                			  temp3.next=temp2;
		                		  temp3=temp3.next;
		                		  temp2=temp2.next;
	                		  }
	                		 
	                	  }
	                        return head3.next;
	               } 
	                

	              
	
	public static void printvalues(Node rev)// Function to print value of the linked list
	{
		Node h=rev;
		while(h!=null)
		{
			System.out.println("Value is :" +h.item);
			h=h.next;
		}
	}
	
	public static void main(String args[])
	{ 
		merge list1=new merge();
		merge list2=new merge();
		merge list3=new merge();
		

		list1.head=new Node(5);
		list1.head.next=new Node(10);
		list1.head.next.next=new Node(20);
		list2.head=new Node(2);
		list2.head.next=new Node(3);
		list2.head.next.next=new Node(20);
		list2.head.next.next.next=new Node(50);


        list3.head=new Node(Integer.MIN_VALUE);
        
		System.out.println("List1");
        printvalues(list1.head);
        
		System.out.println("List2");
        printvalues(list2.head);
        
		System.out.println("Merged List");
        Node prnt=merger(list1.head,list2.head,list3.head);
       printvalues(prnt);

	}
	
}
