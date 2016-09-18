package linkedlist;

public class create 
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
		public void add1(int d) //ADD NEW NODE AT THE HEAD
		{
		
			Node newnode=new Node(d);
			newnode.next=head;
			head=newnode;
			
		}
		
		public void add2(Node previousnode,int d) //ADD NODE AFTER A GIVEN NODE
		{
			if(previousnode==null)
			{
				System.out.println("Previous node is absent");
			    return;
			}
			
			Node newnode=new Node(d);
			newnode.next=previousnode.next;
			previousnode.next=newnode;
		}
		
		public void add3(int d)// ADD NODE AT THE LAST POSITION IN THE LIST
		{
			
		Node newnode=new Node(d);
		
		if(head==null)
		  		{ head=new Node(d);
		  		  return;
		  		}
			  
			newnode.next=null;
			
			Node last;
			last=head;
			while(last.next!=null)
			{
				last=last.next;
							
			}
		  
			last.next=newnode;
			return;
		}
		
		public void delete(int d)
		
		{
			boolean notfound=true;
			
			Node temp=head,prev=null;
			
			
			
			if(temp!=null && temp.item==d)//If item to be deleted is at the head
			{
				head=temp.next;
			    notfound=false;
			    return;
			    
			}
			
		   while(temp.next!=null)//Searching through the list for the item to be deleted
		   {
			   prev=temp;
			   temp=temp.next;
			   if(temp.item==d)
			   {
				   prev.next=temp.next;//skipping the node
				   notfound=false;
				   return;
			   }
		   }
		   if(notfound==true)// Item is not present in the list
		   {
			   System.out.println("Item not present in the list");
			   return;
		   }
		  
		}
		
		public void delete1(int position)//Delete node at a given position
		{
			Node temp=head,prev=null;
			int count=0;
			if(temp==null)
			{
				System.out.println("List is Empty");
				return;
			}
			Node temp1=head;
			while(temp1!=null)
			{
				temp1=temp1.next;
				count=count+1;
			}
			
			if(count<position||position<1)
			{
				System.out.println("invalid position");
				return;
			}
			if(position==1)
			{
				head=temp.next;
				return;
			}
			for(int i=1;i<=count;i++)
			{

				if(position==i)
				{
					prev.next=temp.next;
					return;
				}
				
				prev=temp;
				temp=temp.next;
			
			}	
		}
		int count=0;
		public int recursive_count(Node temp)
		{
			if(temp==null)
			{
				System.out.println("List is empty");//Test to check for empty list
				return(0);
			}
			
			if(temp.next==null)//Base case
				return 1;
			
			else 
				return(recursive_count(temp.next)+1);//Recursive case
		}
		
		
		public void swapNodes(int x, int y)// Function to swap nodes in a Linked List(Assumption each datum is unique)
		{ if(x==y)
			return;
		  
		  Node prevx=null,currx=head,prevy=null,curry=head;
		  while(currx!=null&&currx.item!=x)
		  {
			  prevx=currx;
			  currx=currx.next;
		  }
		  
		  while(curry!=null&&curry.item!=y)
		  {
			  prevy=curry;
			  curry=curry.next;
		  }
		  
		  if(currx==null||curry==null)
			  return;
		  if(prevx!=null)
			  prevx.next=curry;
		  else
			  head=curry;
		  if(prevy!=null)
			  prevy.next=currx;
		  else
			  head=currx;
		  
		  Node temp=currx.next;
		  currx.next=curry.next;
		  curry.next=temp;
		  
		}
		
		public Node reverse(Node node)//To reverse the linked list
		{
			Node prev=null;
			Node next=null;
			Node curr=node;
			
			while(curr!=null)
			{
				next=curr.next;
				curr.next=prev;
				prev=curr;
				curr=next;
			}
			
			node=prev;
			return node;
			
		}
		
		public void rec_rev(Node node)//Reversing the linked list recursively
		{
			Node current=node;
			
			if(current==null)
				return;
			
			if(current.next==null)
			{
				head=current;
				return;
			}
			
			rec_rev(current.next);
			current.next.next=current;
			current.next=null;
		}
	
		public void printvalues()
		{
			Node h=head;
			while(h!=null)
			{
				System.out.println("Value is :" +h.item);
				h=h.next;
			}
		}
		
		public void printvalues(Node rev)
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
			create obj=new create();
			
			obj.head=new Node(1);
			Node second=new Node(2);
			Node third=new Node(3);
			
			obj.head.next=second;
			second.next=third;
			
			obj.printvalues();
			System.out.println("Adding value at the head");
		    obj.add1(0);
		    
		    obj.printvalues();
		    
		    System.out.println("Adding node after a given node");
		    obj.add2(obj.head.next.next, 22);
		    obj.printvalues();
		    
		    System.out.println("Adding node at last position");
		    obj.add3(8);
		    obj.printvalues();
		    
		    		
		    System.out.println("Deleting item from the list");
		    obj.delete1(1);
		    obj.printvalues();
		   
		    		 
		    System.out.println("Swapping nodes in the list");
		    obj.swapNodes(1,1);
		    obj.printvalues();
		 
		    System.out.println("Reversing the list");
		    obj.rec_rev(obj.head);
		    obj.printvalues();
		    
		    int num= obj.recursive_count(obj.head);
		    System.out.println("Number of nodes in the list :" +num);
		  
		    System.out.println("Program Completed");
		}
		
}
