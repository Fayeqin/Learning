class Link
{
	//****************************************
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
		//---------------------------------------------��ѯ
		public boolean containsNode (String data)
		{
			if(data.equals(this.data))
			{
				return true;
			}
			else
			{
				if(this.next != null)
				{
					return this.next.containsNode(data);
				}
				else
				{
					return false;
				}
			}
		}
		//-----------------------------------------
		public String getNode(int index)
		{
			//ʹ�õ�ǰ��foot���ݺ�Ҫ����ѯ���������бȽϣ�Ȼ��foot������������
			if( Link.this.foot ++ == index)
			{
				return this.data;
			}
			else
			{
				return this.next.getNode(index);
			}
		}
		
	}
   //****************************************
   //-----------------------------------------------����
	private Node head;
	private int count = 0 ;//����
	private int foot  = 0;
	private int index;
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
	//------------------------------������� ---
	public int size ()
	{
		return this.count;
	}
	//----------------------�ж��Ƿ�Ϊ������
	public boolean isEmpty()
	{
		return this.count == 0 ;
	}
	//----------
	public String get(int index)
	{
		if(this.index > this.count)
		{
			return null;
		}
		this.foot = 0;
		return this.head.getNode(index);
	}
	//-----------------------���ݲ�ѯ
	public boolean contains (String data)
	{
		//���û��Ҫ��ѯ�����ݣ����ڵ�Ҳ��������
		if(data == null || this.head == null)
		{
			return false;
		}
		return this.head.containsNode(data);
	}
	
	
}
public class TestDome 
{
	public static void main (String arg[])
	{
		Link all = new Link();
		System.out.println(all.isEmpty());//�ж��Ƿ�Ϊ������ ���boolean��
		all.add("6+66");
		all.add("heiheihei");
		all.add("spider-man~");
		System.out.println(all.size());
		System.out.println("��ѯ�Ƿ����������");
		System.out.println(all.contains("hellow"));
		System.out.println("��ѯ�Ƿ����������");
		System.out.println(all.contains("6+66"));
		System.out.println("��ѯ��Ӧ��ŵ�����");
		System.out.println(all.get(0));
		System.out.println(all.get(2));
		System.out.println(all.get(10));//�������ѯ���� ������������������������� �Ҿ���������88-92�е��ж������⡣��
	}
}
/*
���н�� ��
true
3
��ѯ�Ƿ����������
false
��ѯ�Ƿ����������
true
��ѯ��Ӧ��ŵ�����
6+66
spider-man~
Exception in thread "main" java.lang.NullPointerException
	at Link$Node.getNode(TestDome.java:52)
	at Link$Node.getNode(TestDome.java:52)
	at Link$Node.getNode(TestDome.java:52)
	at Link.get(TestDome.java:94)
	at TestDome.main(TestDome.java:126)*/
