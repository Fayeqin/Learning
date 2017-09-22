import java.util.Scanner;
class Student
{
	private String name;
	private int  number;
	private int  age ; 
	public Student (String name ,  int number , int age)
	{
		this.name= name;
		this.age = age;
		this.number = number;
	}
	public String getInfo()
	{
		return "ѧ��������"+this.name+ "ѧ�� ��"+this.number+"���䣺"+this.age;
	}
	//��������ʱ�� һ��Ҫ����ȽϺ���;
	public boolean compare (Student student)
	{
		if(this == student)
		{
			return true;
		}
		if(student == null)
		{
			return false;
		}
		if(this.name.equals(student.name)&&this.number==student.number&&this.age==student.age)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
class Link
{
	private Node head;
	private Node tail;
	private Node temp;
	private int count = 0;
	private int foot  = 0;
	private Student []retArray ;//����һ����������
	//********************
	private class Node
	{
		private Student data;
		private Node next;
		private Node last;
		public Node(Student data)
		{
			this.data = data;
		}
		public void addNode(Node newNode , Node temp)
		{
			if( this.next == tail)
			{
				this.next = newNode;
				newNode.last = temp;
				newNode.next = tail;
				count ++;
			}
			else
			{
				temp=this.next;
			    this.next.addNode(newNode , temp);
			}
		}
		public void removeNode(Node temp , int flag)
		{
			int x = 1;
			while( x < flag)
			{
				temp = temp.next;
				x++;
			}
		    temp.last.next = temp.next;
		    temp.next.last = temp.last;
		    count--;
		}
		public void insetNode(Node newNode , Node temp , int flag)
		{
			int x = 1;
			while( x < flag)
			{
				temp = temp.next;
				x++;
			}
			newNode.next=temp;
			newNode.last=temp.last;
			temp.last.next = newNode;
			count++;
		}
		public void toArrayNode()
		{
			Link.this.retArray[Link.this.foot++] = this.data;
			if(this.next != tail)
			{
				this.next.toArrayNode();
			}
		}
	}
	//****************************************
	//����ͷβ���
	public void Create(Student data)
	{
		Node newNode1 = new Node (data);
		Node newNode0 = new Node (null);
		head = newNode1;
		tail = newNode0;
		newNode1.next = newNode0;
		newNode0.last = newNode1;
		newNode1.last = null;
		newNode0.next = null;
		newNode0.data = null;
		newNode1.data = data;
		this.count = 1;
	}
	//���ӽ��
	public void add(Student data)
	{
		Node newNode = new Node (data);
		if(this.head != null)
		{
			temp = head;
			this.head.addNode(newNode,temp);
		}
		else
		{
			System.out.println("���ȴ�������");
		}
	}
	//ɾ�����
	public void remove (int flag)
	{
		if(flag == 1)
		{
			head.next = head;
			head.next.last =null;
			count--;
		}
		temp = head;
		if( count >= flag  && flag !=1)
		{
			this.head.removeNode( temp , flag);
			System.out.println("ɾ���ɹ�");
		}
		else
		{
			System.out.println("ɾ������");
		}
	}
	//������
	public int inset(Student data,int flag)
	{
		Node newNode = new Node (data);
		if(flag == 1)
		{
			temp = head ;
			head = newNode;
			head.next = temp;
			head.last = null;
			temp.last = head;
			count++;
			System.out.println("����ɹ�");
			return 0;
		}
		if(flag == count)
		{
			this.head.addNode(newNode, head);
			return 0;
		}
		if( count > flag &&  flag !=1 )
		{
			temp = head;
			this.head.insetNode(newNode ,temp, flag);
			System.out.println("����ɹ�");
			return 0;
		}
		else if(flag >count)
		{
			System.out.println("����ʧ��flag >count");
			return 0;
		}
		else 
		{
			System.out.println("����ʧ��");
			return 0;
		}
	}
	//���������ݲ�ͬҪ�� (��ʱ����)
	//�������(ѧ��/����)
	public void soft()
	{
	}
	//�������
	//�������黯
	public Student [] toArray()
	{
		if(this.head  == null)
		{
		    System.out.println("NO Data");
			return null;
		}
		this.foot = 0;//���Ʊ�ʶ
		this.retArray = new Student [this.count];//��������
		this.head.toArrayNode();
		return this.retArray;
	}
	public void print()
	{
		temp = head;
		while(temp != tail)
		{
			System.out.println(temp.data.getInfo());
			temp = temp.next;
		}
	}
	public void link()//����Ϊ����
	{
	      head.last = tail;
	      tail.next = head;
	}
}
public class Test {
	public static void main(String args[])
	{   
	    boolean flag = true;
		Link all = new Link();
		System.out.println("������һ������");
		System.out.println("�����û�����");
		Scanner temp1 = new Scanner(System.in);
		String name = temp1.next();
		Scanner temp2 = new Scanner(System.in);
		System.out.println("�����û�ѧ��");
		int number = temp2.nextInt();
		System.out.println("�����û�����");
		int age = temp2.nextInt();
		all.Create(new Student(name,number,age));
		w:while(flag)
		{
			int x = 3 ;
			System.out.println("���������������������*,�����������");
			String temp  = temp1.next();
			if(temp.equals("*"))
			{
				break w;
			}
			System.out.println("����һ������");
			System.out.println("�����û�����");
			String name1 = temp1.next();
			System.out.println("�����û�ѧ��");
			int number2 = temp2.nextInt();
			System.out.println("�����û�����");
			int age2 = temp2.nextInt();
			all.add(new Student(name1,number2,age2));
		}
		System.out.println("���ȫ����Ϣ");
		all.print();
		System.out.println("ɾ���ڶ�������Ϣ");
		all.remove(2);
		System.out.println("�ڵ�һ��λ�ò�����ѧ������Ϣ");
		all.inset(new Student("��ѧ��",1600300834,20),1);
		System.out.println("�ڵ�����λ�ò�����ᾴ����Ϣ");
		all.inset(new Student("��ᾴ�",1600300831,20),3);
		all.print();
		System.out.println("�����λ�ü����ź������Ϣ");
 		all.inset(new Student("�ź���",1600300835,19),5);
		all.print();
	}
}
