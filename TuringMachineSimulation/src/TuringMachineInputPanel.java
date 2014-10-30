import javax.swing.*;

//TuringMachineInputPanel class
public class TuringMachineInputPanel extends JPanel implements java.io.Serializable{
	
	// attributes
	private JTextField   			 inputField;
    private JButton      			 buildButton, backButton, addButton, removeButton, clearButton;
    private JList<String>        	 inputList;
    private JLabel       			 inputLabels[], instruction;
    private JSlider      			 slider;
    private JScrollPane  			 inputScrollPane;
    private DefaultListModel<String> inputSymbols = new DefaultListModel<String>();
	
    // get methods
	public JTextField	 			 getInputField() { return inputField; }
	public JButton		 			 getAddButton() { return addButton; }
	public JButton		 			 getRemoveButton() { return removeButton; }
	public JButton		 			 getBuildButton() { return buildButton; }
	public JButton		 			 getBackButton() { return backButton; }
	public JButton		 			 getClearButton() { return clearButton; }
    public JList<String>            getInputList() { return inputList; }
    public JSlider          		 getSlider() { return slider; }
    public JLabel           		 getInputLabels(int i) { return inputLabels[i]; }
    public JLabel 			 		 getInstruction() { return instruction; }
    public DefaultListModel<String> getInputSymbols() { return inputSymbols; }
    
    // constructor
    public TuringMachineInputPanel() {

    	setLayout(null);
    	
        //Add labels       
    	instruction = new JLabel("Step 3:     Provide input by adding a symbol to the tape cell.");
    	instruction.setLocation(30,30);
    	instruction.setSize(500, 40);
    	add(instruction);
    	
    	JLabel label = new JLabel("Input:");
  		label.setLocation(30,50);
		label.setSize(150, 40);
    	add(label);
        
        label = new JLabel("Input Alphabet:");
  		label.setLocation(398,170);
		label.setSize(150, 40);
    	add(label);
        
        label = new JLabel("Note: Any cell without a symbol will be filled with a Blank Symbol.");
  		label.setLocation(280,500);
		label.setSize(500, 40);
    	add(label);
        
           	
        // Add input labels
        inputLabels = new JLabel[31];
        for(int i=0; i<31; i++) {
            inputLabels[i] = new JLabel();
            inputLabels[i].setLocation(30*(i+1),90);
            inputLabels[i].setSize(25, 25);
            inputLabels[i].setBorder(BorderFactory.createRaisedBevelBorder());
            inputLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            add(inputLabels[i]);
        }
          	
        // Add slider
        slider = new JSlider(JSlider.HORIZONTAL,1,31,1);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLocation(33,120);
		slider.setSize(920, 40);
        add(slider);   	
    	
    	//Add list
        inputList = new JList<String>(inputSymbols);
        inputScrollPane = new JScrollPane(inputList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		inputScrollPane.setLocation(380,200);
		inputScrollPane.setSize(120, 270);
        add(inputScrollPane);
    	
    	//Add buttons    	
    	addButton = new JButton("Add");
    	addButton.setLocation(520,200);
		addButton.setSize(100, 40);
    	add(addButton);
    	
    	removeButton = new JButton("Remove");
    	removeButton.setLocation(520,260);
		removeButton.setSize(100, 40);
    	add(removeButton);
    	
    	clearButton = new JButton("Clear Input");
    	clearButton.setLocation(150,600);
		clearButton.setSize(100, 40);
    	add(clearButton);
    	
    	backButton = new JButton("Back");
    	backButton.setLocation(30,600);
		backButton.setSize(100, 40);
    	add(backButton);
    	
    	buildButton = new JButton("Build");
    	buildButton.setLocation(860,600);
		buildButton.setSize(100, 40);
    	add(buildButton);
    }    
}