import javax.swing.*;

//TuringMachineTransitionPanel class
public class TuringMachineTransitionPanel extends JPanel implements java.io.Serializable{
	
	// attributes
	private JList<String>            	 transitionList;		   
	private JScrollPane              	 transitionScrollPane;	
	private JButton                  	 saveButton, editButton, continueButton, previousButton, backButton, nextButton;
	private JLabel		 	 			 currentState, currentAlphabet, instruction;
	private JComboBox<String>	 	 	 stateComboBox, symbolComboBox, directionCombBox;
	private DefaultListModel<String>     transitions = new DefaultListModel<String>();
	private DefaultComboBoxModel<String> states = new DefaultComboBoxModel<String>(), symbols = new DefaultComboBoxModel<String>(), directions = new DefaultComboBoxModel<String>();

	// get methods
	public JList<String>		 	 	getTransitionList() { return transitionList;}
	public JScrollPane      			getTransitionScrollPane() { return transitionScrollPane; }
	public JButton          			getSaveButton() { return saveButton; }
	public JButton          			getEditButton() { return editButton; }
	public JButton		 	 			getContinueButton() { return continueButton; }
	public JButton		 	 			getPreviousButton() { return previousButton; }
	public JButton		 	 			getBackButton() { return backButton; }
	public JButton		 	 			getNextButton() { return nextButton; }
	public JLabel		 	 			getCurrentState(){ return currentState; }
	public JLabel		 	 			getCurrentAlphabet() { return currentAlphabet; }
	public JLabel 			 			getInstruction() { return instruction; }
	public JComboBox<String>	 	 	getStateComboBox() { return stateComboBox; }
	public JComboBox<String>	 	 	getSymbolComboBox() { return symbolComboBox; }
	public JComboBox<String>	 	 	getDirectionComboBox() { return directionCombBox; }
	public DefaultListModel<String>     getTransitionItems() { return transitions; }
	public DefaultComboBoxModel<String> getStateItems() { return states; }
	public DefaultComboBoxModel<String> getSymbolItems() { return symbols; }
	public DefaultComboBoxModel<String> getDirectionItems() { return directions; }
	
	// constructor
    public TuringMachineTransitionPanel() {

    	setLayout(null);
    	
    	//Add labels
    	instruction = new JLabel("Step 2:    For each element on the Transitions list, provide the intended transition and press 'Set'.");
    	instruction.setLocation(30,30);
    	instruction.setSize(800, 40);
    	add(instruction);
    	
    	JLabel label = new JLabel("Transitions:");
  		label.setLocation(30,60);
		label.setSize(90, 40);
    	add(label);
    	
    	label = new JLabel("At State:");
  		label.setLocation(440,80);
		label.setSize(50, 40);
    	add(label);
    	
    	label = new JLabel("Read Symbol:");
		label.setLocation(440,110);
		label.setSize(90, 40);
    	add(label);
    	
    	label = new JLabel("Switch to State:");
		label.setLocation(440,140);
		label.setSize(90, 40);
    	add(label);
    	
    	label = new JLabel("Write Symbol:");
		label.setLocation(590,140);
		label.setSize(90, 40);
    	add(label);
    	
    	label = new JLabel("Move:");
		label.setLocation(740,140);
		label.setSize(50, 40);
    	add(label);
    	
    	currentState = new JLabel("");
    	currentState.setLocation(500,80);
		currentState.setSize(100, 40);
    	add(currentState);
    	
    	currentAlphabet = new JLabel("");
    	currentAlphabet.setLocation(530,110);
		currentAlphabet.setSize(100, 40);
    	add(currentAlphabet);
    	
    	//Add comboBoxex
		stateComboBox = new JComboBox<String>(states);
		stateComboBox.setLocation(440,170);
		stateComboBox.setSize(130, 30);
  	  	add(stateComboBox);
    	
    	symbolComboBox = new JComboBox<String>(symbols);
		symbolComboBox.setLocation(590,170);
		symbolComboBox.setSize(130, 30);
    	add(symbolComboBox);
    	
        directions.addElement("Neutral");
        directions.addElement("Left");
        directions.addElement("Right");        
    	directionCombBox = new JComboBox<String>(directions);
		directionCombBox.setLocation(740,170);
		directionCombBox.setSize(100, 30);
    	add(directionCombBox);
    	
    	//Add list
 		transitionList = new JList<String>(transitions);
    	transitionScrollPane = new JScrollPane(transitionList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		transitionScrollPane.setLocation(30,90);
		transitionScrollPane.setSize(400, 485);
    	add(transitionScrollPane);
    	
    	//Add buttons
    	saveButton = new JButton("Set");
    	saveButton.setLocation(860,165);
		saveButton.setSize(100, 40);
    	add(saveButton);
    	    	   	
    	backButton = new JButton("Back");
    	backButton.setLocation(30,600);
		backButton.setSize(100, 40);
    	add(backButton);
    	
    	nextButton = new JButton("Next");
    	nextButton.setLocation(860,600);
		nextButton.setSize(100, 40);
    	add(nextButton);
    }    
}