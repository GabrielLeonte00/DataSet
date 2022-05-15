package Application.classes;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Application.interfaces.Obiect;

public class MouseClick implements MouseListener{
	private boolean drawing=false;
	private Point p1=new Point(0,0);
	private Point p2=new Point(0,0);
	private static Vector<Obiect> listOfObjects;
	@SuppressWarnings("unused")
	private String optiune;
	private Add_Image add_image;
	private static JComboBox<String> selectObjectVar;
	private Vector<String> names=new Vector<>();
	private Vector<Color> colors=new Vector<>();
	
	public MouseClick() {
	}
	
	public MouseClick(Vector<Obiect> listSelectObject, Add_Image add_image, JComboBox<String> selectObjectVar, Vector<String> names, Vector<Color> colors) {
		MouseClick.listOfObjects = listSelectObject;
		this.add_image = add_image;
		MouseClick.selectObjectVar = selectObjectVar;
		this.names = names;
		this.colors = colors;
	}
	
   public void mousePressed(MouseEvent e) {
	   if(this.drawing){
        	p2=e.getPoint();
        	this.drawing=false;
        	
        	try {
        		this.optiune = (String) selectObjectVar.getSelectedItem();
        		CropTag newTag = new CropTag(add_image, colors.get(selectObjectVar.getSelectedIndex()), names.get(selectObjectVar.getSelectedIndex()));
        		newTag.setPoint1(this.p1);
        		newTag.setPoint2(this.p2);
        		newTag.draw();
        		MouseClick.listOfObjects.add(newTag);
        		
        	} catch (ArrayIndexOutOfBoundsException e1) {
				JFrame mesaj = new JFrame();
				JOptionPane.showMessageDialog(mesaj,"The selected tag was deleted or renamed, please rechoose the tag", "Warning", JOptionPane.WARNING_MESSAGE, new FileGet().getIcon("warn.png"));
				mesaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}	
        }
        else {
        	p1 = e.getPoint();
        	this.drawing=true;
        }
    }
   
   public Point getPoint_P1(){  
	   return p1;
   }
   
   public Point getPoint_P2(){
	   return p2;
   }
   
   public void refresh() {
	   p1 = new Point(0,0);
	   p2 = new Point(0,0);
   }

@Override
public void mouseClicked(MouseEvent e) {
}

@Override
public void mouseReleased(MouseEvent e) {
}

@Override
public void mouseEntered(MouseEvent e) {
}

@Override
public void mouseExited(MouseEvent e) {
}


}
