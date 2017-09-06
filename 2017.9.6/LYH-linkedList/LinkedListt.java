

public class LinkedListt
{
	public Node first;
	
	public LinkedListt()
	{
		this.first = null;
	}
	
	//����ͷ���
	public void addFirstNode(int data)
	{
		Node node = new Node(data);
		node.next = first;
		first = node;
	}
	//ɾ��ͷ���
	public void deleteFirstNode()
	{
		Node tempNode = first;
		first = tempNode.next;
	}
	
	//������λ�ò�����
	public void addNode(int index, int data)
	{
		int location = 0;
		Node node = new Node(data);
		Node current = first;
		Node previous = first;
		
		while (location != index)
		{
			previous = current;
			current = current.next;
			location++;
		}
		node.next = current;
		previous.next = node;
	}
	
	//����dataɾ���ڵ㣨��ɾ����һ����
	public void deleteByData(int data)
	{
		Node current = first;
		Node previous = first;
		
		while (current.data != data)
		{
			if (current.next == null)
			{
				return;
			}
			else
			{
				previous = current;
				current = current.next;
			}
		}
		if (current == first)
		{
			first = first.next;
		}
		else
		{
			previous.next = current.next;
		}
	}
	
	//����indexɾ�����
	public void deleteByIndex(int index)
	{
		Node current = first;
		Node previous = first;
		int location = 0;
		
		while (location != index)
		{
			location++;
			previous = current;
			current = current.next;
		}
		if (current == first)
		{
			first = first.next;
		}
		else
		{
			location = 0;
			previous.next = current.next;
		}
	}
	
	//��ӡ����
	public void displayLinkedList()
	{
		Node current = first;
		
		while (current != null)
		{
			current.display();
			current = current.next;
		}
		System.out.println();
	}
	
	//����index����data
	public void findByLocation(int index)
	{
		Node current = first;
		int location = 0;
		
		if (location != index)
		{
			current = current.next;
			location++;
		}
		current.display();
	}
}
