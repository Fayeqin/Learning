class Book
{
	private String name;
	private double price;
	static String pub = "�廪��ѧ������";
	public Book(String name , double price)
	{
		this.name  = name;
		this.price = price;
 	}
	public String getInfo()
	{
		return "������"+this.name+"���۸�"+this.price+"�������磺"+ pub;
	}
	 static void setPub(String p)
	{
		pub = p;
	}
	
}
public class TextDome {
	public static void main(String arge[])
	{
		Book.setPub("������ѧ������");
		Book ba = new Book ("java����",10.5);
		Book bb = new Book ("Android����",11.5);
		Book bc = new Book ("Ios����",12.5);
		System.out.println(Book.pub);
		System.out.println(bb.getInfo());
		Book.pub = "���ӿƼ���ѧ������";
		System.out.println(Book.pub);
		System.out.println(ba.getInfo());
	}
}
