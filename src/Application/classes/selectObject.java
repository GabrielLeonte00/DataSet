package Application.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import Application.interfaces.Obiect;
import marvin.image.MarvinImage;

public class selectObject {

	private JFrame frame;
	private Add_Image Add_image;
	private JComboBox<String> selectObject;
	private Vector<Obiect> listOfObjects = new Vector<Obiect>();
	private JButton export;
	private MarvinImage cropImage;
	
//	public selectObject(JFrame frame, JComboBox<String> selectObject) {
//		this.selectObject = selectObject;
//		this.frame = frame;
//	}

	public selectObject(JFrame frame, Add_Image Add_Image, JComboBox<String> selectObject, JButton export,MarvinImage cropImage) {
		this.selectObject = selectObject;
		this.frame = frame;
		this.Add_image = Add_Image;
		this.export = export;
		this.cropImage=cropImage;
	}

	public JFrame getFrame() {
		return frame;
	}

	public Add_Image getAddImage() {
		return Add_image;
	}
	
	public void setAddImage(Add_Image temp) {
		this.Add_image = temp;
	}

	public JComboBox<String> getSelectObject() {
		return selectObject;
	}

	public void createObjectAndDraw() {
		MouseClick ms1 = new MouseClick(listOfObjects, getAddImage());
		getAddImage().geImagePanel().addMouseListener(ms1);
		Export exportImage = new Export(frame, export, getAddImage(), this.listOfObjects,cropImage);
		exportImage.Load2();
		
		
		this.selectObject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String alegere = getSelectObject().getSelectedItem().toString();
				ms1.setOptiune(alegere);
				
			}
		});

	}

	public Vector<Obiect> getListOfObjects(){
		return this.listOfObjects;
	}
}
