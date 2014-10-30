import java.awt.*;
import javax.swing.*;

//TuringMachineMenuPanel class
public class TuringMachineMenuPanel extends JPanel{
	
    // attributes
    private int 	 currentButton;
    private JLabel	 title, description;
    private JButton  loadButton, createButton;
     
    // get methods
    public JButton getLoadButton() { return loadButton; }
    public JButton getCreateButton() { return createButton; }     
    
    // set method
    public void setCurrentButton(int button) { 
    	currentButton = button;
    	repaint();
    }
    
    // constructor
	public TuringMachineMenuPanel() {
        setLayout(null);
        setBackground(Color.white);
        currentButton = 1;
        
    	//Add labels       
        title = new JLabel("Turing Machine Simulator");
        title.setLocation(258,35);
		title.setSize(500,80);
		title.setFont(new Font("arial", Font.BOLD,40)); 
        add(title);
        
        description = new JLabel("Main Menu");
        description.setLocation(424,150);
        description.setSize(200,80);
        description.setFont(new Font("arial", Font.BOLD, 30)); 
        add(description);
        
        //Add buttons	
        loadButton = new JButton("Load Machine");
    	loadButton.setLocation(150,430);
		loadButton.setSize(300,100);
		loadButton.setFont(new Font("arial", Font.PLAIN,30)); 	
    	add(loadButton);
        
        createButton = new JButton("Create Machine");
    	createButton.setLocation(550,430);
		createButton.setSize(300,100);
		createButton.setFont(new Font("arial", Font.PLAIN,30)); 
    	add(createButton);         	
    }
	
	// paint function
	public void paintComponent(Graphics g){
        super.paintComponent(g);

        //draw main menu border
        g.setColor(Color.black);
        g.drawRect(350, 150, 300, 80);
        
        // draw arrow
	    int  tapeHeadX;
	    if(currentButton == 1){
	    	tapeHeadX = 285;
	    }
	    else{
	    	tapeHeadX = 690;
	    }
	    g.drawLine(tapeHeadX+16, 280, tapeHeadX+16, 430);
	    g.drawLine(tapeHeadX+16, 430, tapeHeadX+11, 425);
	    g.drawLine(tapeHeadX+16, 430, tapeHeadX+21, 425);
	    g.drawLine(500 , 280, tapeHeadX+16, 280);
	    g.drawLine(500 , 230, 500, 280);          
    }
}