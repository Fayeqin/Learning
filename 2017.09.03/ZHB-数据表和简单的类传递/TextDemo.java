class Dept
{
	private int deptno ;
	private String dname;
	private String loc;
	private Emp emps [];
	public void setEmps(Emp [] emps)
	{
		this.emps=emps;
	}
	public Emp[] getEmp()
	{
		return this.emps;
	}
	public Dept (int deptno , String dname , String loc)
	{
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public String getInfo()
	{
		return "���ű�ţ�"+this.deptno+",���ƣ�"+this.dname+",λ�ã�"+this.loc;
	}
}
class Emp
{
	private int empno;
	private String ename ;
	private String job;
	private double sal;
	private double comm;
	private Dept dept;//��ʾ��Ӧ���ŵ���Ϣ
	private Emp mgr;//��ʾ��Ա��Ӧ���쵼
	public void setMgr(Emp mgr)
	{
		this.mgr =mgr;
	}
	public Emp getMgr()
	{
		return this.mgr;
	}
	void setDept(Dept dept)
	{
		this.dept =dept;
	}
	public Dept getDept()
	{
		return this.dept;
	}
	
	
	public Emp(int empno , String ename ,String job , double sal ,double comm )
	{
		this.empno=empno;
		this.ename=ename;
		this.job=job;
		this.sal=sal;
		this.comm=comm;
	}
	public String getInfo()
	{
		return "��Ա��� "+this.empno+"���� "+this.ename+"ְλ "+this.job+"нˮ "+this.sal+"Ӷ�� "+this.comm;
	}
}
public class TextDemo {
	public static void main(String args[])
	{
		//��������
		//1.�������ԵĶ�������
		Dept dept = new Dept (10,"ACCOUNTING","New York");//������Ϣ
		Emp ea = new Emp(0001,"lyh","Manger",800.0,0.0);
		Emp eb = new Emp(0002,"fly","Assistant",900.0,0.0);
		Emp ec = new Emp(0003,"zhb","Clean",500.0,0.0);
		Emp ed = new Emp(0004,"ssy","Clerk",800.0,0.0);
		//2.���ù�Ա���쵼�Ĺ�ϵ
		ea.setMgr(eb);
		eb.setMgr(ec);
		//3.���ù�Ա�Ͳ��ŵĹ�ϵ
		ea.setDept(dept) ;  // ��Ա�벿��
		eb.setDept(dept) ;
		ec.setDept(dept) ;
		ed.setDept(dept) ;
		dept.setEmps(new Emp[]{ea,eb,ec,ed});
		//�ڶ�����ȡ������
		//1.ͨ����Ա�ҵ��쵼��Ϣ�Ͳ�����Ϣ
		System.out.println("\t|-"+ea.getInfo());
		System.out.println("�쵼\t|-"+ea.getMgr().getInfo());
		System.out.println("\t|-"+ea.getDept().getInfo());
		//2.���ݲ����ҵ����й�Ա�����ҵ����й�Ա���쵼����Ϣ
		System.out.println("----------------------------");
		System.out.println(dept.getInfo());
		System.out.println("\n");
		for(int x = 0 ; x<dept.getEmp().length;x++)
		{    
			System.out.println(dept.getEmp()[x].getInfo());
		   if(dept.getEmp()[x].getMgr()!=null)
			{
			   System.out.println("�����쵼��");
			   System.out.println(dept.getEmp()[x].getMgr().getInfo());
			}
		   System.out.println("\n");
		}
		
	}
}
