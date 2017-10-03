public class TmyPost extends Post
{
	private final String head = "����Ӫ���ͣ�"; 
	
	public TmyPost()
	{
		super();
	}
	
	public TmyPost(String title, String content)
	{
		super(title, content);
	}
	
	public TmyPost(Long id, String title, String content)
	{
		super(id, title, content);
	}
	
	
    public void setId(Long id)
    {
    	super.id = id;
    }
    public Long getId()
    {
    	return super.id;
    }
    
    public void setTitle(String title)
    {
    	super.title = title;
    }
    public String getTitle()
    {
    	return super.title;
    }
    
    public void setContent(String content)
    {
    	super.content = content;
    }
    public String getContent()
    {
    	return super.content;
    }
    
    
    public void print()
    {
//    	System.out.println("����Ӫ����:");
    	System.out.println(head);
    	System.out.println(super.id);
    	System.out.println(super.title);
    	System.out.println(super.content);
    }
}
