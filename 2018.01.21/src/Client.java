import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
	public static void main(String[] args) 
	{
        // TODO Auto-generated method stub
        String msg = "Client data";
        
        try 
        {
            //����һ��Socket������������8080�˿�����
            Socket socket = new Socket("172.0.0.1",8080);
            //ʹ��PrintWriter��BufferedReader���ж�д����
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //��������
            pw.println(msg);
            pw.flush();
            //��������
            String line = is.readLine();
            System.out.println("received from server" + line);
            //�ر���Դ
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
