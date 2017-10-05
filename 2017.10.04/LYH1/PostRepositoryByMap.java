import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PostRepositoryByMap implements PostRepository 
{

    // your code here���������������б�Ҫ�ĳ�ʼ��
    private Map<Long, Post> postMap = new HashMap<Long, Post>();

    @Override
    public void add(Post post) 
    {
        // your code here
    	postMap.put(post.getId(), post);
    }

    @Override
    public Post getPostById(long id) 
    {
        // your code here
    	return postMap.get(id);
    }

    @Override
    public void remove(long id) 
    {
        // your code here
    	postMap.remove(id);
    }

    @Override
    public List<Post> getAll() 
    {
    	List<Post> posts = new ArrayList<>();
    	
    	for (Post p : postMap.values())
    	{
    		posts.add(p);
    	}
        return posts;
    }


    // �����������������������ʵ��

    @Override
    public void loadData() {
        // leave empty
    }

    @Override
    public void saveData() {
        // leave empty
    }
}