import java.util.Scanner;

public class Main
{
	public static void main(String args[]) {
        double a = 17d * 2d + 135d / 6d - 234d % 4d;
        double b = 9d * 11d + 33d / 4d - 25d % 3d;
        // your code here: a��b�ֱ�Ϊֱ�������εı߳��������System.out.println�������б�߱߳�
        System.out.println((Math.sqrt(a * a + b * b)));
        
        String[] sentences = new String[]{"hello", "thank you", "thank u", "thank you very much"};
        
        for (String sentence : sentences)
        {
        	System.out.println(sentence);
        }
    }

}

