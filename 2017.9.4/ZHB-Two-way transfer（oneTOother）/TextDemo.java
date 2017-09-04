class Item
{
	private int iid;
	private String name;
	private String note;
	private Subitem suibitems[];
	private Product products[];
	Item(int iid, String name , String note)
	{
		this.iid=iid;
		this.name=name;
		this.note=note;
	}
	public String getInfo()
	{
		return "��Ŀ��ţ�"+this.iid+" ���ƣ�"+this.name+" ��ע��"+this.note;
	}
	void setSubitems(Subitem subitems[])
	{
		this.suibitems = subitems;
	}
	public Subitem[] getSubitems()
	{
		return this.suibitems;
	}
	void setProduct(Product products[])
	{
		this.products=products;
	}
	public Product[] getProducts()
	{
		return this.products;
	}
	
}
class Subitem
{
	private int sid;
	private String name;
	private String note;
	private Item item;
	private Product products[];
	Subitem(int sid, String name, String note)
	{
		this.name= name ;
		this.note= note ;
		this.sid = sid;
	}
	public String getInfo()
	{
		return "����Ŀ���"+this.sid+"���ƣ�"+this.name+" ��ע��"+this.note;
	}
	void setItem(Item item)
	{
		this.item=item;
	}
	public Item getItem()
	{
		return this.item;
	}
	void setProduct(Product products[])
	{
		this.products=products;
	}
	public Product[] getProduct()
	{
		return this.products;
	}
}
class Product
{
	private int pid ;
	private String name;
	private double price;
	private Item item;
	private Subitem subitem;
	Product(int pid , String name ,int i)
	{
		this.name = name;
		this.pid  = pid;
		this.price =i;
	}
	public String getInfo()
	{
		return "��Ʒ���"+this.pid+ " ���ƣ�"+this.name+" �۸�"+this.price;
	}
	void setItem (Item item)
	{
		this.item =item;
	}
	public Item getItem()
	{
		return this.item;
	}
	void setSubitem (Subitem subitem)
	{
		this.subitem =subitem;
	}
	public Subitem getSubitem()
	{
		return this.subitem;
	}
}
public class TextDemo {
	public static void main (String args[])
	{
		 Item item = new Item (1,"�����þ�","-");
		 Subitem suba = new Subitem (1001,"����","-");
		 Subitem subb = new Subitem (1002,"�;�","-");
		 Subitem subc = new Subitem (1003,"����","-");
		 Product proa = new Product(90001,"����",500);
		 Product prob = new Product(90002,"����",60);
		 Product proc = new Product(90003,"�˵�",200);
		 Product prod = new Product(90004,"С��",70);
		 Product proe = new Product(90005,"��",20);
		 Product prof = new Product(90006,"��",10);
		 suba.setItem(item);
		 subb.setItem(item);
		 subc.setItem(item);
		 item.setSubitems(new Subitem []{suba,subb,subc});
		 proa.setSubitem(subc);
		 proa.setItem(item);
		 prob.setSubitem(subc);
		 prob.setItem(item);
		 proc.setSubitem(suba);
		 proc.setItem(item);
		 prod.setSubitem(suba);
		 prod.setItem(item);
		 proe.setSubitem(subb);
		 proe.setItem(item);
		 prof.setSubitem(subb);
		 prof.setItem(item);
		 suba.setProduct(new Product[]{proc,prod});
		 subb.setProduct(new Product[]{proe,prof});
		 subc.setProduct(new Product[]{proa,prob});
		 item.setProduct(new Product[]{proa,prob,proc,prod,proe,prof});
		 System.out.println(item.getInfo());
		 for(int x = 0 ; x<item.getSubitems().length ;x++)
		 { 
			 System.out.println(item.getSubitems()[x].getInfo());
		 }
		 System.out.println(item.getInfo());
		 for(int x = 0 ; x<item.getProducts().length;x++)
		 {
			 System.out.println(item.getProducts()[x].getInfo());
		 } 
	}
}
