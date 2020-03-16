package badapple;

import javax.swing.JTextArea;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

public class ASCII implements Runnable {
	JTextArea text;

	public ASCII(JTextArea text) {
		// TODO Auto-generated constructor stub
		this.text = text;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		char[] charArray = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\\\"^`'. ".toCharArray();

		VideoCapture videoCapture = new VideoCapture();
		videoCapture.open("F:/Media/Videos/badapple.flv");
		System.out.println(videoCapture.isOpened());
		Mat img = new Mat();
		for (int i = 0; i < 60; i++) {
			videoCapture.read(img);
		}
		int count = 0;
		while (videoCapture.read(img)) {
			Mat gray = new Mat();
			Imgproc.cvtColor(img, gray, Imgproc.COLOR_BGR2GRAY);
			Mat resize_gray = new Mat();
			Imgproc.resize(gray, resize_gray, new Size(120, 45));
			int rows = resize_gray.rows();
			int cols = resize_gray.cols();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					double d = resize_gray.get(i, j)[0];
					int index = (int) (d / 256 * charArray.length);

					sb.append(charArray[index]);
				}
				sb.append("\n");
			}
			text.setText("");
			text.append(sb.toString());
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
		}
		System.out.println(count);

	}
}
