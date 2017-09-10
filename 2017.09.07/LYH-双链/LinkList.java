

public class LinkList
{
//	public static Node beginning;
//	public static Node ending;
	Node beginning = new Node(0, null);
	Node ending = new Node(0, null);
	
	public LinkList()
	{
//		beginning.number = 0;
//		beginning.name = "0";
//		ending.number = 0;
//		ending.name = "0";
//		beginning = null;
//		ending = null;
		this.beginning.last = null;
		this.ending.next = null;
		this.beginning.next = this.ending;
		this.ending.last = this.beginning;
	}
	
	//������
	public void insertNode(int index, int number, String name)
	{
		int location = 0;
		Node node = new Node(number, name);
		Node current = beginning;
		
		while (location != index)
		{
			current = current.next;
			location++;
		}
		current.last.next = node;
		node.last = current.last;
		current.last = node;
		node.next = current;
	}
	
	//����indexɾ�����
	public void deleteByIndex(int index)
	{
		int location = 0;
		Node current = beginning.next;
		
		while (location != index)
		{
			current = current.next;
			location++;
		}
		current.last.next = current.next;
		current.next.last = current.last;
//		current.last = null;
//		current.next = null;
	}
	
	//����numberɾ�����
	public void deleteByNumber(int number)
	{
		Node current = beginning.next;
		
		while (number != current.number)
		{
			current = current.next;
		}
		current.last.next = current.next;
		current.next.last = current.last;
//		current.last = null;
//		current.next = null;
	}
	
	//����index����number��name
	public void searchByIndex(int index)
	{
		int location = 0;
		Node current = beginning.next;
		
		while (location != index)
		{
			current = current.next;
			location++;
		}
		current.display();
	}
	
	//����nameɾ�����
	public void deleteByName(String name)
	{
		Node current = beginning.next;
		
		while (!(current.name.equals(name)))
		{
			current = current.next;
		}
		current.last.next = current.next;
		current.next.last = current.last;
//		current.last = null;
//		current.next = null;
	}
	
	
	//��ӡ����
	public void printLinkedList()
	{
		Node current = beginning.next;
		
		while (current.next != null)
		{
			current.display();
			current = current.next;
		}
		System.out.println();
	}
}
