class Member
{
	private int mid ;
	private String name;
	//car��ʵ���������ʾ�г�
	//carΪnull��ʾû�г�
	private Car car;//��ʾ�����˵ĳ�
    public Member(int mid ,String name)
	{
		this.mid = mid;
		this.name = name ;
	}

	public String getInfo()
	{
       return "��Ա��ţ�"+ this.mid +"������ ��"+ this.name ;
	}
	public Car getCar()
	{
		return this.car;
	}
	public void setCar(Car car)
	{
		this.car = car ;
	}
}
class Car
{
	private Member member; //������һ����
	private String pname;
	Car(String pname)
	{
	  this.pname = pname;
	}
	public String getInfo()
	{
		return "�������֣�" + this.pname;
	}
	public void setMember (Member member)
	{
		this.member = member;
	}
	public Member getMember()
	{
		return this.member;
	}
}//member��car���Ƕ�������Ȼ���ٲ�����ϵ
public class Lyhhlj
{
	public static void main (String args[])
	{
		//��һ�� ��������
		Member m = new Member (1 , "����޿");//��������
		Car c = new Car("����z4");//��������
		m.setCar (c);//һ������һ����
		c.setMember(m);//һ��������һ����
		//�ڶ��� ȡ����ϵ
		//ͨ�����ҵ����Ĺ�ϵ
		System.out.println(m.getCar().getInfo());
		System.out.println(c.getMember().getInfo());
	}
}