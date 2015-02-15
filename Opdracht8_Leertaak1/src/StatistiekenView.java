import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class StatistiekenView extends JPanel implements ActionListener
{
	DobbelsteenModel d;
	int waarde;
	int worp = 0;
	JLabel een, twee, drie, vier, vijf, zes, worpen;
	
	public StatistiekenView()
	{
	    this.setLayout(new GridLayout(8,2));
	    
	    this.add(new JLabel("Nummer"));
	    this.add(new JLabel("Gegooid"));
	    
	    this.add(new JLabel("1 :"));
	    een = new JLabel("0");
	    this.add(een);
	   
	    this.add(new JLabel("2 :"));
	    twee = new JLabel("0");
	    this.add(twee);
	    
	    this.add(new JLabel("3 :"));
	    drie = new JLabel("0");
	    this.add(drie);
	    
	    this.add(new JLabel("4 :"));
	    vier = new JLabel("0");
	    this.add(vier);
	    
	    this.add(new JLabel("5 :"));
	    vijf = new JLabel("0");
	    this.add(vijf);
	    
	    this.add(new JLabel("6 :"));
	    zes = new JLabel("0");
	    this.add(zes);
	    
	    this.add(new JLabel("Worpen :"));
	    worpen = new JLabel("0");
	    this.add(worpen);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		worp++;
		worpen.setText(Integer.toString(worp));
		
		int amount;
		d = (DobbelsteenModel) e.getSource();
		waarde = d.getWaarde();
	
		switch(waarde)
		{
			case 1: 
				amount = Integer.parseInt(een.getText());
				amount++;
				een.setText(Integer.toString(amount));
			break;
			case 2: 
				amount = Integer.parseInt(twee.getText());
				amount++;
				twee.setText(Integer.toString(amount));
			break;
			case 3: 
				amount = Integer.parseInt(drie.getText());
				amount++;
				drie.setText(Integer.toString(amount));
			break;
			case 4:  
				amount = Integer.parseInt(vier.getText());
				amount++;
				vier.setText(Integer.toString(amount));
			break;
			case 5: 
				amount = Integer.parseInt(vijf.getText());
				amount++;
				vijf.setText(Integer.toString(amount));
			break;
			case 6:  
				amount = Integer.parseInt(zes.getText());
				amount++;
				zes.setText(Integer.toString(amount));
			break;
		}		
	}
	
	public Dimension getPreferredSize()
	{
	    return new Dimension(150,100);
	} 
}
