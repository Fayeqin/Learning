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
public class TestDome 
{
     public static void main (String args[])
     {
    	 Array arr = new SortArray(4);
    	 arr.add(4);
    	 arr.add(2);
    	 arr.add(1);
    	 arr.add(3); 
    	 int [] temp = arr.getData() ;
    	 for (int x = 0 ;  x < temp.length;x++)
    	 {
    		 System.out.println(temp[x]);
    	 }
     }
}
