class Node 
{
	private String data; 
	private Node next;
	public Node (String data)
	{
		this.data = data;
	}
	void setNext(Node next)
	{
		this.next=next;
	}
	public Node getNext()
	{
		return this.next;
	}
	public String getData()
	{
		return this.data;
	}
	void addNode(Node newnode)//ʵ�ֵ�ַ������
	{
		if(this.next == null)//��ǰ��ַ����һ����ַΪ��
		{
			this.next = newnode; 
		}
		else//��ǰ��ַ����һ����ַ��Ϊ��
		{
			this.next.addNode(newnode);//��ǰ��ַ������һ��
		}
	}
	void printNode()
	{
		System.out.println(this.data);
		if(this.next != null)//�¸���ַ��Ϊ�� �����һ����ַ�
		{
			this.next.printNode();
		}
	}
	
}
//��Ҫ����Node�����Ĺ�ϵ����
class  Link//�������ݵ����ú�ȡ��
{
	private Node head;
	void add (String data)//��������
	{
		//Ϊ�˿����������ݵ��Ⱥ��ϵ�����Խ�data��װ��Node��
		Node newNode = new Node(data);
		if(this.head==null)
		{
			this.head=newNode;//����һ����ַ����Ϊͷ��ַ
		}
		else//ͷ��ַ�Ѿ�������
		{
			this.head.addNode(newNode);
		}
	}
	void print()//�������
	{
		if(this.head!=null)
		{
			this.head.printNode();
		}
	}
}
public class TestDome ��
{
	public static void main (String arg[])
	{
	Link link  =  new Link ();
	link.add("hellow");//�������
	link.add("hai");
	link.add("luck");
	link.print();
	}
}
