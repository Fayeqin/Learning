class Array
{
	private int data[];
	private int foot;
	public Array (int length)
	{
		if(length > 0 )
		{
			this.data = new int [length];
		}
		else
		{
			this.data = new int [1];
		}
	}
	public boolean add(int number) 
	{
		if(this.foot < this.data.length)
		{
			this.data[this.foot ++] = number;
			return true;
		}
		return false;
	}
	public int []  getData ()
	{
		return this.data; 
	}
}
class SortArray extends Array
{
    //Array ������������û���޲ι��췽��
	public SortArray(int length) {
		super(length);
		//��ȷ�ĵ��ø�����вι��죺Ŀ���Ǹ����е�Data ����Ϳ��Գ�ʼ��
	}
	public int []getData()//��Ϊ�����е�getData()������������������ʹ�ø�д�ķ�ʽ������
	{
	   java.util.Arrays.sort(super.getData());
	   return super.getData();
	}	
}
class ReverseArray extends Array
{
	public ReverseArray(int length)
	{
		super(length);
	}
	public int [] getData()
	{
		int center = super.getData().length/2;
		int head = 0;
		int tail = super.getData().length-1;
		for (int x = 0 ;x<center; x++)
		{
			int temp ;
			temp= super.getData()[head];
			super.getData()[head]=super.getData()[tail];
			super.getData()[tail] = temp;
			head++;
			tail--;
		}
		return super.getData();
	}
}
public class TestDome 
{
     public static void main (String args[])
     {
    	 Array arr = new Array(4);
    	 arr.add(4);
    	 arr.add(2);
    	 arr.add(1);
    	 arr.add(3); 
    	 int [] temp = arr.getData() ;
    	 for (int x = 0 ;  x < temp.length;x++)
    	 {
    		 System.out.println(temp[x]);
    	 }
    	 System.out.println("------------------------");
    	 SortArray abc = new SortArray(4);
    	 abc.add(4);
    	 abc.add(2);
    	 abc.add(1);
    	 abc.add(3); 
    	 int [] temp1 = abc.getData() ;
    	 for (int x = 0 ;  x < temp1.length;x++)
    	 {
    		 System.out.println(temp1[x]);
    	 }
    	 System.out.println("------------------------");
    	 ReverseArray abcd = new ReverseArray(4);
    	 abcd.add(4);
    	 abcd.add(2);
    	 abcd.add(1);
    	 abcd.add(3); 
    	 int [] temp2 = abcd.getData() ;
    	 for (int x = 0 ;  x < temp2.length;x++)
    	 {
    		 System.out.println(temp2[x]);
    	 }
     }
}