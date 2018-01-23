import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.w3c.dom.ls.LSException;

public class Client
{
	public static void main(String[] args) 
	{
        // TODO Auto-generated method stub
		
        Scanner scanner = new Scanner(System.in);
        
        
        
        
        try 
        {
            //����һ��Socket������������8080�˿�����
            Socket socket = new Socket("192.168.31.227",8080);
            
            
            
            //ʹ��PrintWriter��BufferedReader���ж�д����
            
            
            PrintWriter pw = null;
            BufferedReader is = null;
            
            
            System.out.println("Please input the message");
            String aString = scanner.nextLine();
            while (!aString.equals("exit"))
            {
            	pw = new PrintWriter(socket.getOutputStream());
                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            	System.out.println("received from server: \n" + is.readLine());
            	
            	pw.flush();
            	pw.println(aString);
            	
            	aString = scanner.nextLine();
            }
            pw.close();
            is.close();
            socket.close();
          
            

            
        } 
        catch (UnknownHostException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
