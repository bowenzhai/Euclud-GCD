import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JPanel implements ActionListener
{
	public static int num1, num2;
	JTextField textField1, textField2;
	JTable table;
	DefaultTableModel dtm;
	JTextArea result;
	
	public GUI()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel label = new JLabel ("Calculate the GCD of two integers using EEA.");
		add(label);

		textField1 = new JTextField(10);
		add(textField1);
		
		textField2 = new JTextField(10);
		add(textField2);

		JButton button = new JButton("Calculate");
		add(button);

		button.addActionListener(this);
		
		table = new JTable();
		dtm = new DefaultTableModel(0, 0);
		String header[] = new String[]{"x", "y", "r", "q"};
		dtm.setColumnIdentifiers(header);
		table.setModel(dtm);
		table.setEnabled(false);
		add(table);


		result = new JTextArea();
		result.setEditable(false);
		add(result);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		try
		{
			num1 = Integer.parseInt(textField1.getText());
			num2 = Integer.parseInt(textField2.getText());
		} catch (Exception ex) {}
		
		int a,b;
		if (Math.abs(num1)>Math.abs(num2))
		{
			a = Math.abs(num1);
			b = Math.abs(num2);
		}
		else 
		{
			a = Math.abs(num2);
			b = Math.abs(num1);
		}
		
		int x1 = 1, y1 = 0, r1 = a, q1 = 0;
		int x2 = 0, y2 = 1, r2 = b, q2 = 0;
		int x3, y3, r3, q3;
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		dtm.addRow(new Object[]{"x", "y", "r", "q"});
		dtm.addRow(new Object[] {x1, y1, r1, q1});
		dtm.addRow(new Object[] {x2, y2, r2, q2});
		
		while (r2 != 0)
		{
			q3 = (int) Math.floor(r1/r2);
			r3 = r1%r2;
			x3 = x1 - q3 * x2;
			y3 = y1 - q3 * y2;
			dtm.addRow(new Object[] {x3, y3, r3, q3});
			x1 = x2;
			y1 = y2;
			r1 = r2;
			q1 = q2;
			x2 = x3;
			y2 = y3;
			r2 = r3;
			q2 = q3;
		}
		
		final int x, y;
		
		if (num1 == a)
		{
			x = x1;
		}		
		else if (num1 == -a)
		{
			x = -x1;
		}
		else if (num1 == b)
		{
			x = y1;
		}
		else
		{
			x = -y1;
		}
		
		if (num2 == b)
		{
			y = y1;
		}
		else if (num2 == -b)
		{
			y = -y1;
		}
		else if (num2 == a)
		{
			y = x1;
		}
		else
		{
			y = -x1;
		}

		result.setText("gcd(" + num1 + ", " + num2 + ") = " + r1 + "\n" +
				num1 + " × " + x + " + " + num2 + " × " + y + " = " + r1);
	}
}