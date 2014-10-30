import javax.swing.*;

//TuringMachineStartPanel class
public class TuringMachineStartPanel extends JPanel implements java.io.Serializable{
	
	// attributes
	private JTextField   				 tapeAlphabetTextField, inputAlphabetTextField, stateTextField;
	private JList<String>        		 tapeAlphabetList, inputAlphabetList, stateList;	   
	private JScrollPane  				 tapeAlphabetScrollPane, inputAlphabetScrollPane, stateScrollPane;
	private JButton      				 addTapeAlphabetButton, removeTapeAlphabetButton, addInputAlphabetButton, removeInputAlphabetButton, addStateButton, removeStateButton, nextButton, startBackButton;
	private JLabel       				 instruction;
    private JComboBox<String>    		 startComboBox;
	private DefaultListModel<String> 	 alphabet = new DefaultListModel<String>(), input = new DefaultListModel<String>(), states = new DefaultListModel<String>();
    private DefaultComboBoxModel<String> starts = new DefaultComboBoxModel<String>();

	// get methods
	public JTextField	 				getTapeAlphabetTextField() { return tapeAlphabetTextField; }
    public JTextField	 				getInputAlphabetTextField() { return inputAlphabetTextField; }
	public JTextField   				getStateTextField() { return stateTextField; }
	public JList<String>		 		getTapeAlphabetList() { return tapeAlphabetList; }
    public JList<String>		 		getInputAlphabetList() { return inputAlphabetList; }
	public JList<String>		    	getStateList() { return stateList;}
	public JScrollPane  				getTapeAlphabetScrollPane() { return tapeAlphabetScrollPane; }
	public JScrollPane  				getStateScrollPane() { return stateScrollPane; }
    public JComboBox<String>    		getStartComboBox() { return startComboBox; }
	public JButton      				getAddTapeAlphabetButton() { return addTapeAlphabetButton; }
	public JButton		 				getRemoveTapeAlphabetButton() { return removeTapeAlphabetButton; }
    public JButton      				getAddInputAlphabetButton() { return addInputAlphabetButton; }
	public JButton		 				getRemoveInputAlphabetButton() { return removeInputAlphabetButton; }
	public JButton		 				getAddStateButton() { return addStateButton; }
	public JButton		 				getRemoveStateButton() { return removeStateButton; }
	public JButton						getNextButton() { return nextButton; }
	public JButton		 				getStartBackButton() { return startBackButton; }
	public JLabel		 				getInstruction(){ return instruction; }
	public DefaultListModel<String> 	getTapeAlphabetItems() { return alphabet;}
    public DefaultListModel<String> 	getInputAlphabetItems() { return input;}
	public DefaultListModel<String> 	getStateItems() { return states;}
	public DefaultComboBoxModel<String> getStartItems() { return starts;}
    
	// constructor
    public TuringMachineStartPanel() {

    	setLayout(null);
    	
    	// Add labels
    	instruction = new JLabel("Step 1:      Please provide input alphabet, tape alphabet, and states. Then choose the start state.");
    	instruction.setLocation(140,30);
    	instruction.setSize(800, 40);
    	add(instruction);
    	
    	JLabel label = new JLabel("Input Alphabet:");
  		label.setLocation(140,70);
		label.setSize(150, 40);
    	add(label);
        
        label = new JLabel("Tape Alphabet:");
  		label.setLocation(140,350);
		label.setSize(150, 40);
    	add(label);
    	
    	label = new JLabel("States:");
		label.setLocation(540,70);
		label.setSize(150, 40);
    	add(label);
        
        label = new JLabel("Start State:");
		label.setLocation(540,350);
		label.setSize(150, 40);
    	add(label);
    	
    	//Add textfields
    	tapeAlphabetTextField = new JTextField();
    	tapeAlphabetTextField.setDocument(new JTextFieldLimit(1));
		tapeAlphabetTextField.setLocation(140,390);
		tapeAlphabetTextField.setSize(150, 40);
    	add(tapeAlphabetTextField);
        
        inputAlphabetTextField = new JTextField();
    	inputAlphabetTextField.setDocument(new JTextFieldLimit(1));
		inputAlphabetTextField.setLocation(140,110);
		inputAlphabetTextField.setSize(150, 40);
    	add(inputAlphabetTextField);
    	
    	stateTextField = new JTextField();
    	stateTextField.setDocument(new JTextFieldLimit(10));
		stateTextField.setLocation(540,110);
		stateTextField.setSize(150, 40);
    	add(stateTextField);
    	
    	//Add lists
    	tapeAlphabetList = new JList<String>(alphabet);
        alphabet.addElement("Blank Symbol");
    	tapeAlphabetScrollPane = new JScrollPane(tapeAlphabetList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tapeAlphabetScrollPane.setLocation(140,440);
		tapeAlphabetScrollPane.setSize(150, 180);
    	add(tapeAlphabetScrollPane);
        
        inputAlphabetList = new JList<String>(input);
    	inputAlphabetScrollPane = new JScrollPane(inputAlphabetList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        inputAlphabetScrollPane.setLocation(140,160);
		inputAlphabetScrollPane.setSize(150, 180);
    	add(inputAlphabetScrollPane);
    	
    	stateList = new JList<String>(states);
        states.addElement("ACCEPT");
        states.addElement("REJECT");
    	stateScrollPane = new JScrollPane(stateList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		stateScrollPane.setLocation(540,160);
		stateScrollPane.setSize(150, 180);
    	add(stateScrollPane);
    	
        //Add combobox
        startComboBox  = new JComboBox<String>(starts);
		startComboBox.setLocation(540,390);
		startComboBox.setSize(150, 35);
    	add(startComboBox);
        
    	//Add buttons
    	addTapeAlphabetButton = new JButton("Add Tape Alphabet");
    	addTapeAlphabetButton.setLocation(300,390);
		addTapeAlphabetButton.setSize(180, 40);
    	add(addTapeAlphabetButton);
        
        addInputAlphabetButton = new JButton("Add Input Alphabet");
    	addInputAlphabetButton.setLocation(300,110);
		addInputAlphabetButton.setSize(180, 40);
    	add(addInputAlphabetButton);
    	
    	addStateButton = new JButton("Add State");
    	addStateButton.setLocation(700,110);
		addStateButton.setSize(150, 40);
    	add(addStateButton);
                   	
    	removeTapeAlphabetButton = new JButton("Remove Tape Alphabet");
    	removeTapeAlphabetButton.setLocation(300,440);
		removeTapeAlphabetButton.setSize(180, 40);
    	add(removeTapeAlphabetButton);
        
        removeInputAlphabetButton = new JButton("Remove InputAlphabet");
    	removeInputAlphabetButton.setLocation(300,160);
		removeInputAlphabetButton.setSize(180, 40);
    	add(removeInputAlphabetButton);
    	
    	removeStateButton = new JButton("Remove State");
    	removeStateButton.setLocation(700,160);
		removeStateButton.setSize(150, 40);
    	add(removeStateButton);
    	
    	nextButton = new JButton("Next");
    	nextButton.setLocation(860,600);
		nextButton.setSize(100, 40);
    	add(nextButton);
        nextButton.setEnabled(false);
        
        startBackButton = new JButton("Main Menu");
    	startBackButton.setLocation(30,30);
		startBackButton.setSize(95, 40);
    	add(startBackButton);
        startBackButton.setEnabled(true);	
    }    
}