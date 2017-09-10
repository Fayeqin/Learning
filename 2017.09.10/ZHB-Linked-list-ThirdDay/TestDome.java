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
	//****************************************
	private class Node //����ڵ���
	{
		private Student data ;
		private Node next ;
		public Node (Student data)
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
		public boolean containsNode (Student data)
		{
			if(data.compare(this.data))
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
		public Student getNode(int index)
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
		//------------------------�޸�
		public void setNode(int index , Student data)
		{
			if(Link.this.foot ++ == index)
			{
				this.data =data;
			}
			else
			{
				this.next.setNode(index,data);
			}
		}
		//-----------------------ɾ�����ڵ�
		public void removeNode(Node previous , Student data)
		{
			if(data.compare(this.data))//��Ҫɾ��������
			{
				previous.next = this.next;
			}
			else
			{
				this.next.removeNode(this, data);
			}
		}
		//--------------------------�Դ����õķ�������������ݴ���
		public void toArrayNode()
		{
			Link.this.retArray[Link.this.foot++] = this.data;
			if(this.next != null)
			{
				this.next.toArrayNode();
			}
		}
	}
   //****************************************
   //-----------------------------------------------����
	private Node head;
	private int count = 0 ;//����
	private int foot  = 0;
	private Student [] retArray;//����һ���������顢������link��Ϊ����link ��node�ж��ܷ���
	public void add (Student data)
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
	public Student get(int index)
	{
		if(index > this.count)
		{
			return null;
		}
		this.foot = 0;
		return this.head.getNode(index);
	}
	//-----------------------���ݲ�ѯ
	public boolean contains (Student data)
	{
		//���û��Ҫ��ѯ�����ݣ����ڵ�Ҳ��������
		if(data == null || this.head == null)
		{
			return false;
		}
		return this.head.containsNode(data);
	}
	//--------------------�޸�
	public void set(int index , Student data)
	{
		if(index > this.count)
		{
			return ;//������������
		}
		this.foot = 0 ;
		this.head.setNode(index,data);
	}
	//-------------------ɾ��
	public void remove (Student data)
	{
		if(this.contains(data))
		{
			if(data.compare(this.head.data))//���Ҫɾ��ͷ���
			{
				this.head =this.head.next;
			}
			else
			{
				this.head.next.removeNode(this.head, data);
			}
			this.count -- ;
		}
	}
	//----------------------��������
	public Student [] toArray()
	{
		if(this.head == null)
		{
			return null;
		}
		this.foot = 0;//���Ʊ�ʶ
		this.retArray = new Student [this.count];//��������
		this.head.toArrayNode();//����node�������������
		return this.retArray;
	}
}
public class TestDome 
{
	public static void main (String arg[])
	{
		Link all = new Link();
		all.add(new Student("�ź���",1600300835,19));
		all.add(new Student("����޿",1600300822,19));
		all.add(new Student("����",1600300812,20));
		System.out.println("һ���ж���ѧ��: "+all.size());	
		System.out.println("��ѯ�ź������ѧ����Ϣ�Ƿ�������"+all.contains(new Student("�ź���",1600300835,19)));
		System.out.println("��ѯ��һ��ͬѧ����Ϣ");
		System.out.println(all.get(0).getInfo());
		System.out.println("ɾ���ź������Ϣ");
		all.remove(new Student("�ź���",1600300835,19));
		System.out.println("���ȫ����Ϣ");
		Student [] data = all.toArray();//������ķ������鴫�ݳ���
		for(int x = 0 ; x<data.length ; x ++)//ѭ�����
		{
			System.out.println(data[x].getInfo());
		}
		//System.out.println(all.isEmpty());//�ж��Ƿ�Ϊ������ ���boolean��
	}
}
