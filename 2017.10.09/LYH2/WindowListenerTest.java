import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerTest
{
	private Frame frame = new Frame("Test");
	private TextArea textArea = new TextArea(6, 40);
	
	class MyListener implements WindowListener
	{

		@Override
		public void windowActivated(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n���ڱ����");
			
		}

		@Override
		public void windowClosed(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n���ڱ��ɹ��رգ�");
		}

		@Override
		public void windowClosing(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n�û��رմ��ڣ�");
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n����ʧȥ���㣡");
		}

		@Override
		public void windowDeiconified(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n���ڱ��ָ���");
		}

		@Override
		public void windowIconified(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n���ڱ���С����");
		}

		@Override
		public void windowOpened(WindowEvent e)
		{
			// TODO Auto-generated method stub
			textArea.append("\n���ڱ����δ򿪣�");
		}
		
	}
	
	
	public void init()
	{
		frame.addWindowListener(new MyListener());
		
		frame.add(textArea);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new WindowListenerTest().init();
	}
}
