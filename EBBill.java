import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class HouseNumberException extends Exception
{
	int a;
	HouseNumberException(int b)
	{
		a=b;
	}
	public String toString()
	{
		return("House number must be from 1 to 4 only.");
	}
}

public class EBBill {
	
		int houseNo;
		String name;
		double first,last,amount;
		
		EBBill(int hn, String n, double ft, double lt)
		{
			houseNo  = hn;
			name = n;
			first = ft;
			last = lt;
		}

	public static void main(String[] args) {
		
		
		JFrame f = new JFrame("EBBill");
		
		JLabel l = new JLabel("House Number: ");
		l.setBounds(50,50,150,30);
		JTextField t = new JTextField();
		t.setBounds(230,50,100,30);
		
		JLabel l2 = new JLabel("Name: ");
		l2.setBounds(50,100,150,30);
		JTextField t2 = new JTextField();
		t2.setBounds(230,100,100,30);
		
		JLabel l3 = new JLabel("Starting Reading: ");
		l3.setBounds(50,150,150,30);
		JTextField t3 = new JTextField();
		t3.setBounds(280,150,100,30);
		
		JLabel l4 = new JLabel("Ending Reading: ");
		l4.setBounds(50,200,150,30);
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();  //because last one doesn't work
		t4.setBounds(280,200,100,30);
		t5.setBounds(280,200,100,30);
		
		JButton b2 = new JButton("Calculate Bill");
		b2.setBounds(350,300,150,30);
		
		JButton b = new JButton("Save Data");
		b.setBounds(150,250,100,30);
		
		JTextArea ta = new JTextArea();
		ta.setBounds(100,350,350,200);
		
		JLabel l5 = new JLabel("Enter House Number: ");
		l5.setBounds(100,300,150,30);
		
		JTextField t6 = new JTextField();
		t6.setBounds(280,300,50,30);
		
		f.add(l); f.add(t); f.add(l2); f.add(t2); f.add(l3); 
		f.add(t3); f.add(l4); f.add(b); f.add(b2); f.add(ta);  
		f.add(l5); f.add(t6); f.add(t4); f.add(t5); 
		f.setSize(600,600);
		f.setVisible(true);
		f.setLayout(null);
		
		EBBill bill[] = new EBBill[4];
		
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
				    int x = Integer.parseInt(t.getText());
				    if(x<1 || x>4)
				    {
				    	throw new HouseNumberException(x);
				    	//JOptionPane.showMessageDialog(this, "not found");
				    }
				    x = x-1;
				    bill[x] = new EBBill(x+1 , t2.getText() , Double.parseDouble(t3.getText()) ,  Double.parseDouble(t4.getText()));
				    t.setText(""); t2.setText(""); t3.setText(""); t4.setText("");
				}
				catch (HouseNumberException ex)
				{
					System.out.println(ex);
				}
			}
		});
		
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ee)
			{
				try
				{
					int y = Integer.parseInt(t6.getText());
					if(y<1 || y>4)
					{
						throw new HouseNumberException(y);
					}
					y = y-1;
					bill[y].amount = (bill[y].last - bill[y].first) * 10;
					String result = "Name: " + bill[y].name + "\n" +
									"House Number: " + bill[y].houseNo + "\n" +
									"Start Meter Reading: " + bill[y].first + "\n" +
									"End Meter Reading: " + bill[y].last + "\n" +
									"Total Amount: " + bill[y].amount;
					ta.setText(result);
				}
				catch(HouseNumberException exe)
				{
					System.out.println(exe);
				}
			}
		});
	}
}
