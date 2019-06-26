import java.util.*;
import java.awt.*;
import java.awt.event.*;
class ColorMixer implements AdjustmentListener,TextListener 
{
	private Frame f;
	private Panel p11;	
	private Panel p5,p6,p7,p8,p9,p10;
	private Label l1,l2,l3;
	private Scrollbar sc1,sc2,sc3;
	private TextField cb1,cb2,cb3;
	private Label a1,a2,a3;
	private int a=0,b=0,c=0;
	private String s1="0",s2="0",s3="0";
	private Object o;
	ColorMixer()
	{
		
		f=new Frame();
		f.setBounds(450,250,1000,750);
		p5=new Panel(new BorderLayout());
		p6=new Panel(new BorderLayout());
		p7=new Panel();
	//	ta=new TextArea();
		p8=new Panel(new GridLayout(0,3));
		l1=new Label("R");
		l2=new Label("G");
		l3=new Label("B");			
		p7.add(l1);
		p7.add(l2);
		p7.add(l3);
		p11=new Panel(new BorderLayout());
	//	p11.add(ta);
		p6.add(p7,"North");
		sc1=new Scrollbar(Scrollbar.VERTICAL,0,0,0,256);
		sc2=new Scrollbar(Scrollbar.VERTICAL,0,0,0,256);
		sc3=new Scrollbar(Scrollbar.VERTICAL,0,0,0,256);
		sc1.setBackground(Color.RED);	
		sc2.setBackground(Color.GREEN);	
		sc3.setBackground(Color.BLUE);	
		p8.add(sc1);
		p8.add(sc2);
		p8.add(sc3);
	//	p6.add(p7,"North");
		p6.add(p8);
		p9=new Panel();
		cb1=new TextField((""+0),3);		
		cb2=new TextField((""+0),3);		
		cb3=new TextField((""+0),3);		
		a1=new Label("RED");
		a2=new Label("GREEN");
		a3=new Label("BLUE");
		p9.add(a1);
		p9.add(cb1);
		p9.add(a2);
		p9.add(cb2);
		p9.add(a3);
		p9.add(cb3);
		p10=new Panel(new BorderLayout());
		p10.add(p9,"South");
		p10.add(p6,"East");
		p10.add(p11);
		f.add(p10);
		sc1.addAdjustmentListener(this);
		sc2.addAdjustmentListener(this);
		sc3.addAdjustmentListener(this);
		cb1.addTextListener(this);
		cb2.addTextListener(this);
		cb3.addTextListener(this);
		f.setVisible(true);
			
	}
	public void textValueChanged(TextEvent e)
	{
			o=e.getSource();
			if(o==cb1)
			{	
				s1=cb1.getText();
					if(s1!=null&&s1.length()!=0)
						sc1.setValue(Integer.parseInt(s1));
					else
					{		
						sc1.setValue(0);
						s1="0";
						//cb1.setText(""+0);
					}		
				p11.setBackground(new Color(Integer.parseInt(s1),Integer.parseInt(s2),Integer.parseInt(s3)));
			}	
			
			else if(o==cb2)
			{
				s2=cb2.getText();
				if(s2!=null&&s2.length()!=0)
					sc2.setValue(Integer.parseInt(s2));
				else
				{
					sc2.setValue(0);
					s2="0";
					//cb2.setText(""+0);
				}
				p11.setBackground(new Color(Integer.parseInt(s1),Integer.parseInt(s2),Integer.parseInt(s3)));
		
			}
			else if(o==cb3)
			{
				s3=cb3.getText();
				if(s3!=null&&s3.length()!=0)
					sc3.setValue(Integer.parseInt(s3));
				else
				{
					sc3.setValue(0);
					s3="0";
					//cb3.setText(""+0);
				}
				p11.setBackground(new Color(Integer.parseInt(s1),Integer.parseInt(s2),Integer.parseInt(s3)));
		
			}
	}
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		o=e.getSource();
		if(o==sc1)
		{
			a=sc1.getValue();
			cb1.setText(""+a);
		}
		if(o==sc2)
		{
			b=sc2.getValue();
			cb2.setText(""+b);
		}if(o==sc3)
		{
			c=sc3.getValue();
			cb3.setText(""+c);
		}
		p11.setBackground(new Color(a,b,c));
		
	} 
	public static void main(String...abhishek)
	{
		new ColorMixer();
	}
}	