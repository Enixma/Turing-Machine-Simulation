import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

//TuringMachineSimulationPanel class
public class TuringMachineSimulationPanel extends JPanel {
	
     // attributes
     private int          		tapeHeadCell, printOrder;
     private JLabel       		state, printError;
     private JButton      		runButton, saveMachineButton, changeInputButton, resetButton;
     private JSlider      		slider;
     private JSpinner     		spinner;
     private SpinnerNumberModel cell; 
     private ArrayList<String>  input;
         
     // get methods
     public int		 		  getTapeHeadCell() { return tapeHeadCell; }
     public int		 		  getPrintOrder() { return printOrder; }
     public JLabel 			  getState() { return state; }
     public JLabel 			  getPrintError() { return printError; }
     public JButton  		  getRunButton() { return runButton; }
     public JButton  		  getSaveMachineButton() { return saveMachineButton; }
     public JButton  		  getChangeInputButton() { return changeInputButton; }
     public JButton  		  getResetButton() { return resetButton; }
     public JSlider  		  getSlider() { return slider; }
     public JSpinner 		  getSpinner() { return spinner; }
     public ArrayList<String> getInput() { return input; } 
        
     // set method
     public void setTapeHeadCell(int cell) { tapeHeadCell = cell; }
     public void setPrintOrder(int order) { printOrder = order; }
     public void setInput(ArrayList<String> anInput) { input = anInput; }
     
     // constructor
     public TuringMachineSimulationPanel() {
    	 setLayout(null);
    	 setBackground(Color.white);
    	 tapeHeadCell = 1;
    	 input = new ArrayList<String>();
        
    	 //Add labels
    	 JLabel label = new JLabel("Choose Simulation Speed (1 - 10):");
    	 label.setLocation(335,555);
    	 label.setSize(200, 40);
    	 add(label);
        
    	 label = new JLabel("Choose Starting Cell:");
    	 label.setLocation(680,555);
    	 label.setSize(200, 40);
    	 add(label);
        
    	 label = new JLabel();
    	 label.setLocation(1,520);
    	 label.setSize(998, 30);
    	 label.setBorder(BorderFactory.createRaisedBevelBorder());
    	 add(label);
        
    	 label = new JLabel();
    	 label.setLocation(1,515);
    	 label.setSize(998, 5);
    	 label.setBorder(BorderFactory.createRaisedBevelBorder());
    	 add(label);
                       
    	 label = new JLabel("Current State:");
    	 label.setLocation(32,520);
    	 label.setSize(80 , 30);
    	 add(label);
        
    	 state = new JLabel("");
    	 state.setLocation(120,518);
    	 state.setSize(200 , 35);
    	 state.setFont(new Font("arial", Font.BOLD,12));
    	 state.setForeground(Color.black);
    	 add(state);
        
    	 printError = new JLabel("");
    	 printError.setLocation(830,518);
    	 printError.setSize(200 , 30);
    	 printError.setForeground(Color.RED);
    	 add(printError);
    	 
    	 // add buttons
    	 changeInputButton = new JButton("Edit Input");
    	 changeInputButton.setLocation(30,565);
    	 changeInputButton.setSize(150, 40);
    	 add(changeInputButton);
        
    	 resetButton = new JButton("Reset");
    	 resetButton.setLocation(870,615);
    	 resetButton.setSize(100, 40);
    	 add(resetButton);
    	
    	 runButton = new JButton("Start");
    	 runButton.setLocation(870,565);
    	 runButton.setSize(100, 40);
    	 add(runButton);
        
    	 saveMachineButton = new JButton("Save Machine");
    	 saveMachineButton.setLocation(30,615);
    	 saveMachineButton.setSize(150, 40);
    	 add(saveMachineButton);
         
    	 // add spinner
    	 cell = new SpinnerNumberModel(1,1,31,1);
    	 spinner = new JSpinner(cell);
    	 spinner.setEditor(new JSpinner.DefaultEditor(spinner));
    	 spinner.setLocation(710,592);
    	 spinner.setSize(60, 50);
    	 add(spinner);
         
    	 // add slider
    	 slider = new JSlider(JSlider.HORIZONTAL,1,10,6);
    	 slider.setMajorTickSpacing(1);
    	 slider.setPaintTicks(true);
    	 slider.setPaintLabels(true);
    	 slider.setLocation(230,600);
    	 slider.setSize(400, 40);
    	 add(slider);	
     }
     
     // paint function
     public void paintComponent(Graphics g){
    	 super.paintComponent(g);
        
         // fill bottom
         g.setColor(new Color(238,238,238));
         g.fillRect(0, 550, 1000, 150);
        
         //draw state control
         g.setColor(Color.black);
         g.drawRect(350, 50, 300, 80);
         g.setFont(new Font("sans", Font.PLAIN, 30));
         g.drawString("State Control",414,103);
        
         // draw tapehead
	     int tapeHeadX = tapeHeadCell * 30;        
	     g.drawLine(tapeHeadX+16, 180, tapeHeadX+16, 460);
	     g.drawLine(tapeHeadX+16, 460, tapeHeadX+11, 455);
	     g.drawLine(tapeHeadX+16, 460, tapeHeadX+21, 455);
	     g.drawLine(500 , 180, tapeHeadX+16, 180);
	     g.drawLine(500 , 180, 500, 130);      
      
         // draw cells
         int a = 0;
         for(int i = 0; i < 33; i++){
        	 g.setColor(Color.black);
             g.drawRect(1+a, 460, 30, 30);
             a = a+30;
         }
      
         // draw symbols
	     a = 12;
	     for(int i = 0; i<input.size(); i++){
	     	g.setColor(Color.black);
	        g.setFont(new Font("arial", Font.PLAIN, 18)); 
	        String blank = (String)input.get(i);
	        if((printOrder == 0) && (i == tapeHeadCell)){}
	        else{
	        	if((blank.equals("")) || (blank.equals(("Blank Symbol")))){
	        		g.drawRect(a-3, 468, 14, 15);
			    }
			    else{
			    	g.drawString((String)input.get(i),a,481); 
			    }
	        }
	        a = a+30;
	     }
     }
}