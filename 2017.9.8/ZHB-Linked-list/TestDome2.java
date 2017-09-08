class Link
{
	private class Node //����ڵ���
	{
		private String data ;
		private Node next ;
		public Node (String data)
		{
			this.data = data ;
		}
		public void addNode (Node newNode)//����
		{
			if(this.next==null)
			{
				this.next = newNode;
			}
			else//����������
			{
				this.next.addNode(newNode);
			}
		}
	}
   //-----------------------------------------------����
	private Node head;
	private int count = 0 ;//����
	public void add (String data)
	{
		Node newNode = new Node (data);//Ҫ���������
		if(this.head == null)
		{
			this.head= newNode ;
		}
		else
		{
			this.head.addNode(newNode);
		}
		this.count++ ;//ÿ�α������count++��
	}
	//----------------------------------------------
	public int size ()//�������
	{
		return this.count;
	}
}
public class TestDome 
{
	public static void main (String arg[])
	{
		Link all = new Link();
		all.add("6+66");
		all.add("heiheihei");
		System.out.println(all.size());
	}
}
