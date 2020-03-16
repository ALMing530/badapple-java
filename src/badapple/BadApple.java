package badapple;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.opencv.core.Core;

public class BadApple{
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) throws InterruptedException {
		BadApple start = new BadApple();
		start.start();
	}

	
	public void start(){
		// TODO Auto-generated method stub
		Font font =new Font("宋体", Font.PLAIN, 15);
		JFrame jframe = new JFrame();
		JTextArea textArea=new JTextArea();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea.setEditable(false);
		textArea.setFont(font);
		jframe.add(textArea);
		jframe.setSize(977,847);
		jframe.setVisible(true);
		jframe.setLocationRelativeTo(null);
		
		new Thread(new ASCII(textArea)).start();
		jframe.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				System.out.println("宽度："+jframe.getWidth());
				System.out.println("高度："+jframe.getHeight());
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
