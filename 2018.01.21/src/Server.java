import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	public static void main(String[] args) 
	{
        // TODO Auto-generated method stub
        try 
        {
            //����һ��ServerSocket����8080�˿�
            ServerSocket server = new ServerSocket(8080);
            //�ȴ�����
            Socket socket = server.accept();
            //���������ʹ��Socket����ͨ�ţ�����BufferedReader���ڶ�ȡ����
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = is.readLine();
            System.out.println("received frome client:" + line);
            //����PrintWriter�����ڷ�������
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("this data is from server");
            pw.flush();
            //�ر���Դ
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
