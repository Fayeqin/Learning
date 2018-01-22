import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		String aString = null;
		
        // TODO Auto-generated method stub
        try 
        {
            //����һ��ServerSocket����8080�˿�
            ServerSocket server = new ServerSocket(8080);
            //�ȴ�����
            Socket socket = server.accept();
            
            
            
            
            
            //���������ʹ��Socket����ͨ�ţ�����BufferedReader���ڶ�ȡ����
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            
            
            
            
           System.out.println("Please input the message");
           
            while (flag)
            {
            	aString = scanner.nextLine();
            	if (aString.equals("exit"))
            	{
            		flag = false;
            		System.out.println("received frome client:\n" + is.readLine());
            		pw.println("�Է��Ѿ��뿪");
                	pw.flush();
            		break;
            	}
            	else
            	{
            		
            		pw.println(aString);
                	pw.flush();
                	System.out.println("received frome client:\n" + is.readLine());
            	}

 
            }
            
            pw.close();
            is.close();
            socket.close();
            server.close();
            

        } 
        catch (IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
