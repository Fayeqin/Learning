import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorErrorTest
{
	public static void main(String[] args)
	{
		Collection books = new HashSet<>();
		books.add("������Javaee��ҵӦ��ʵս");
		books.add("���Java����");
		books.add("���Android����");
		
		books.forEach(obj -> System.out.println("��������Ԫ�أ�" + obj));
		
		System.out.println();
		
		Iterator iterator = books.iterator();
		iterator.forEachRemaining(obj -> System.out.println("��������Ԫ�أ�" + obj));
		
		System.out.println();
		
		Iterator it = books.iterator();
		while (it.hasNext())
		{
			String book = (String) it.next();
			System.out.println(book);
			if (book.equals("���Java����"))
			{
				it.remove();
			}
			book = "�����ַ���";
			
		}
		System.out.println();
		System.out.println(books);
	}
}
