import javax.swing.*;

public class EuclidGCD extends JFrame{
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Euclid GCD");
		frame.setSize(350, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane = (JPanel) frame.getContentPane();
		JPanel math = new GUI();
		
		pane.add(math);
		
		frame.setVisible(true);
	}
}