
public class Main
{
	public static void main(String[] args)
	{
		int sum = 0;//����������
		int temp = 0;//���ӵĸ���
		
		for (int i = 101; i <= 200; i++)
		{
			for (int j = 1; j <= i; j++)
			{
				if ((i % j) == 0)
				{
					temp++;
				}
			}
			if (temp == 2)//ֻ���������ӵ���Ϊ����
			{
				sum++;
				System.out.println(i);
			}
			temp = 0;//ǧ�����������
//			sum = 0;
		}
		System.out.println("The total is " + sum);
	}
}
