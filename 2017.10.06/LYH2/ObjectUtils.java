import java.lang.reflect.Field;

public class ObjectUtils {
    
    /**
     * ��source�����Կ�����target��
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) throws Exception
    {
        // your code here
    	
    	
    	for (Field f : source.getClass().getDeclaredFields())
    	{
    		Field field = target.getClass().getDeclaredField(f.getName());
    		
    		field.setAccessible(true);
    		f.setAccessible(true);
    		
    		if (f.getName().equals("id"))
    		{
    			continue;
    		}
    		else
    		{
    			field.set(target, f.get(source));
    		}
    		
//    		f.setAccessible(true);
    		
    	}
    	
    }
    
    public static void main(String[] args) throws Exception
    {
        User source = new User(1);
        source.setName("tianmaying");
        User target = new User(2);
        System.out.println("sourse is: " + source);
        System.out.println("target is: " + target);
        copyProperties(source, target);
        System.out.println("target is: " + target);
    }

}
