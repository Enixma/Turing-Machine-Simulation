import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.HashMap;
import java.io.*;
import java.net.*;

// TuringMachineFrame class
public class TuringMachineFrame extends JFrame {
	
	// attributes
	private TuringMachine                aTuringMachine;
	private Timer                        aTimer;
	private TuringMachineMenuPanel	     menuView;
	private TuringMachineLoadPanel		 loadView;
	private TuringMachineStartPanel      startView;
	private TuringMachineTransitionPanel transitionView;
	private TuringMachineInputPanel      inputView;
	private TuringMachineSimulationPanel simulationView;
	private CardLayout					 cards;
	private JPanel						 mainPanel;
	private JMenuBar 					 menuBar;
	private JMenu 					     fileMenu, helpMenu;
	private JMenuItem 					 mainItem, aboutItem, exitItem;
	private JFrame						 mainWindow;
	private boolean						 isChild;	
        
    // constructor
	public TuringMachineFrame(String title, boolean status, TuringMachine model, TuringMachineMenuPanel view0, TuringMachineLoadPanel view1, TuringMachineStartPanel view2, TuringMachineTransitionPanel view3, TuringMachineInputPanel view4, TuringMachineSimulationPanel view5){
		super(title);
		
		isChild = status;
		aTuringMachine = model;
		cards = new CardLayout();
		mainPanel = new JPanel();
		mainPanel.setLayout(cards);
		menuView = view0;
		loadView = view1;
		startView = view2;
		transitionView = view3;
        inputView = view4;
        simulationView = view5;
        mainWindow = this;
        
        mainPanel.add(menuView,"0");
        mainPanel.add(loadView,"1");
        mainPanel.add(startView,"2");
        mainPanel.add(transitionView,"3");
        mainPanel.add(inputView,"4");
        mainPanel.add(simulationView,"5");
		add(mainPanel);		
		cards.show(mainPanel,"0");
		
		// add listeners in menuView
		menuView.getLoadButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLoadButton();
			}
		});
		
		menuView.getLoadButton().addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				menuView.setCurrentButton(1);
			}
		});
		
		menuView.getCreateButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleCreateButton();
			}
		});
		
		menuView.getCreateButton().addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				menuView.setCurrentButton(2);
			}
		});
		
		// add listeners in loadView
		loadView.getLoadMachineButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLoadMachineButton();
			}
		});
		
		loadView.getRemoveMachineButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRemoveMachineButton();
			}
		});
		
		loadView.getLoadBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLoadBackButton();
			}
		});
				
		// add listeners in startView
		startView.getAddTapeAlphabetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddTapeAlphabetButton();
			}
		});
                
        startView.getAddInputAlphabetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddInputAlphabetButton();
			}
		});
		
		startView.getAddStateButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddStateButton();
			}
		});
		
		startView.getRemoveTapeAlphabetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRemoveTapeAlphabetButton();
			}
		});
                
        startView.getRemoveInputAlphabetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRemoveInputAlphabetButton();
			}
		});
		
		startView.getRemoveStateButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRemoveStateButton();
			}
		});
		
		startView.getNextButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleNextButton();
			}
		});
		
		startView.getStartBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleStartBackButton();
			}
		});
		
		// add listeners in transitionView		
		transitionView.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBackButton();
			}
		});
                
        transitionView.getSaveButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSaveButton();
			}
		});
        
        transitionView.getNextButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSecondNextButton();
			}
		});
                
        transitionView.getTransitionList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				handleSelectedListItem();
			}
		});
                
        transitionView.getStateComboBox().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	handleComboBoxSelection();
        	}
        });
                
        // add listeners in inputView
		inputView.getAddButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddInputButton();
			}
		});
                
        inputView.getRemoveButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleDeleteInputButton();
			}
		});
		
		inputView.getClearButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleClearInputButton();
			}
		});
                
        inputView.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSecondBackButton();
			}
		});
                
        inputView.getBuildButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBuildButton();
			}
		});
        
        // add listeners in simulationView
        simulationView.getRunButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRunButton();
			}
		});
                
        simulationView.getSaveMachineButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSaveMachineButton();
			}
		});
                
        simulationView.getChangeInputButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleChangeInputButton();
			}
		});
                
        simulationView.getResetButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleResetButton();
			}
		});
                
        simulationView.getSlider().addChangeListener(new ChangeListener(){
        	public void stateChanged(ChangeEvent e){
            	handleSlider((JSlider)e.getSource());
        	}
        });
                
        simulationView.getSpinner().addChangeListener(new ChangeListener(){
         	public void stateChanged(ChangeEvent e){
             	handleSpinner((JSpinner)e.getSource());
       	     }
        });
                
        // add timer listeners
        aTimer = new Timer(1000 ,new ActionListener(){
        	public void actionPerformed(ActionEvent e){
            	handleTimerTick();
        	}
        });               
		
		// add menu bar
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);

		mainItem = new JMenuItem("Main Menu", KeyEvent.VK_M);
		mainItem.setEnabled(false);
		fileMenu.add(mainItem);
			
		exitItem =new JMenuItem("Exit", KeyEvent.VK_X);
		fileMenu.add(exitItem);		
		
		menuBar.add(fileMenu);
		
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		
		aboutItem = new JMenuItem("About", KeyEvent.VK_A);
		helpMenu.add(aboutItem);
		
		menuBar.add(helpMenu);
		
		setJMenuBar(menuBar);
		
		// add menu item listeners
		mainItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {				
				handleSecondBackButton();
				handleBackButton();
				handleStartBackButton();	        
		    }
		});
			
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){     
				int result = JOptionPane.showConfirmDialog(mainWindow,"Are you sure you want to exit?","Exit",JOptionPane.YES_NO_OPTION);			 
			    if (result == JOptionPane.YES_OPTION) System.exit(0);					   
		    }
		});
		
		aboutItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(Desktop.isDesktopSupported()){
					try {
		            	Desktop.getDesktop().browse(new URL("https://github.com/Enixma/Turing-Machine-Simulation").toURI());
		        	}catch (Exception ex) {		        
				    }
				}
			}
		});
		
		// set frame properties
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
 		addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent e){     
		        if(isChild){	 
		        	JFrame frame = (JFrame)e.getSource();
			        int result = JOptionPane.showConfirmDialog(frame,"Are you sure you want to close this window?","Close Window",JOptionPane.YES_NO_OPTION);
			        if (result == JOptionPane.YES_OPTION) setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
				else{
					int result = JOptionPane.showConfirmDialog(mainWindow,"Are you sure you want to exit?","Exit",JOptionPane.YES_NO_OPTION);			 
			        if (result == JOptionPane.YES_OPTION) setDefaultCloseOperation(EXIT_ON_CLOSE);					
				}    
		    }
		});		
		
		setSize(1000,720);
		setResizable(false);
		setChildProperties();				
    }
    
    // set child properties
    public void setChildProperties(){
    	if(isChild){
			cards.show(mainPanel,"5");
			handleBuildButton();
			setJMenuBar(null);
			startView.getStartBackButton().setVisible(false);
			startView.getInstruction().setText("");
			startView.getTapeAlphabetTextField().setEnabled(false);
			startView.getInputAlphabetTextField().setEnabled(false);
			startView.getStateTextField().setEnabled(false);
			startView.getStartComboBox().setEnabled(false);
			startView.getAddTapeAlphabetButton().setEnabled(false);
			startView.getRemoveTapeAlphabetButton().setEnabled(false);
			startView.getAddInputAlphabetButton().setEnabled(false);
			startView.getRemoveInputAlphabetButton().setEnabled(false);
			startView.getAddStateButton().setEnabled(false);
			startView.getRemoveStateButton().setEnabled(false);
			transitionView.getInstruction().setText("");
			transitionView.getSaveButton().setEnabled(false);
			transitionView.getStateComboBox().setEnabled(false);
			transitionView.getSymbolComboBox().setEnabled(false);
			transitionView.getDirectionComboBox().setEnabled(false);
			inputView.getInstruction().setText("");
			setSize(1000,700);
			setVisible(true);
		}
    }
    
    // menuView handlers
    public void handleLoadButton() {
    	loadView.getFileItems().clear();
    	File directory = new File("Saved");
        // get all the files from the directory
    	if(directory.exists()){
	        File[] fileList = directory.listFiles();
	        for(File aFile: fileList){
	        	loadView.getFileItems().addElement(aFile.getName());
	        }
    	}
		cards.show(mainPanel,"1");
		mainItem.setEnabled(true);
    }
    
    public void handleCreateButton() {
		cards.show(mainPanel,"2");
		mainItem.setEnabled(true);
    }
    
    // loadView handlers
    public void handleLoadMachineButton() {
    	if((loadView.getFileList().getSelectedIndex() >=0) && (loadView.getFileList().getSelectedValue() != null)){    		
	    	String machine = (String)loadView.getFileList().getSelectedValue();
	    	File directory = new File("Saved/" + machine);
	    	File model = new File(directory + "/" + machine + ".model");
	    	File start = new File(directory + "/" + machine + ".start");
	    	File transition = new File(directory + "/" + machine + ".transition");
	    	File input = new File(directory + "/" + machine + ".input");
	    	if((model.exists()) && (start.exists()) && (transition.exists()) && (input.exists())){
		    	try { 		
		    		TuringMachine aNewTuringMachine = new TuringMachine();
		    		TuringMachineStartPanel aNewStartView = new TuringMachineStartPanel();
		    		TuringMachineTransitionPanel aNewTransitionView = new TuringMachineTransitionPanel();
		    		TuringMachineInputPanel aNewInputView = new TuringMachineInputPanel();		    		
		    		
		    		ObjectInputStream modelIn; 
					modelIn = new ObjectInputStream(new FileInputStream(directory + "/" + machine + ".model")); 
					aNewTuringMachine = (TuringMachine)modelIn.readObject(); 
					modelIn.close();
					
					ObjectInputStream startIn; 
					startIn = new ObjectInputStream(new FileInputStream(directory + "/" + machine + ".start")); 				
					aNewStartView = (TuringMachineStartPanel)startIn.readObject(); 
					startIn.close();
					
					ObjectInputStream transitionIn; 
					transitionIn = new ObjectInputStream(new FileInputStream(directory + "/" + machine + ".transition")); 
					aNewTransitionView = (TuringMachineTransitionPanel)transitionIn.readObject(); 
					transitionIn.close();
		
					ObjectInputStream inputIn; 
					inputIn = new ObjectInputStream(new FileInputStream(directory + "/" + machine + ".input")); 				
					aNewInputView = (TuringMachineInputPanel)inputIn.readObject(); 
					inputIn.close();
		
					new TuringMachineFrame(machine, true, aNewTuringMachine, new TuringMachineMenuPanel(), new TuringMachineLoadPanel(), aNewStartView, aNewTransitionView, aNewInputView, new TuringMachineSimulationPanel());
				
				} catch (ClassNotFoundException e) { 
					System.out.println("Error: Object'c class does not match"); 
				} catch (FileNotFoundException e) { 
					System.out.println("Error: Cannot open file for writing"); 
				} catch (IOException e) { 
					System.out.println("Error: Cannot read from file"); 
				}
	    	}
    	}	
    }
    
    public void handleRemoveMachineButton() {
    	if((loadView.getFileList().getSelectedIndex() >=0) && (loadView.getFileList().getSelectedValue() != null)){
	    	String machine = (String)loadView.getFileList().getSelectedValue();
	    	int result = JOptionPane.showConfirmDialog(mainWindow,"Sure you want to remove ".concat(machine.trim()).concat("?"),"Remove Machine",JOptionPane.YES_NO_OPTION);			 
	    	if (result == JOptionPane.YES_OPTION){
		    	File directory = new File("Saved/" + machine);
				if(directory.exists()){
		        	File[] fileList = directory.listFiles();
	    	    	for(File aFile: fileList){
	        			aFile.delete();
	        		}	    	
	             	directory.delete();
	             	handleLoadButton();	
	    		} 			
    		}
	    }	
    }
    
    public void handleLoadBackButton() {
		cards.show(mainPanel,"0");
		mainItem.setEnabled(false);
    }
        
    // startView handlers
    public void handleAddTapeAlphabetButton() {
  	String alphabet = startView.getTapeAlphabetTextField().getText().trim();
    	if((alphabet.length() > 0) && (startView.getTapeAlphabetItems().contains(alphabet) == false)){
    		startView.getTapeAlphabetItems().addElement(alphabet);
    		startView.getTapeAlphabetTextField().setText("");
    	}
        if((startView.getTapeAlphabetItems().getSize() > 1) && (startView.getInputAlphabetItems().getSize() > 0) && (startView.getStateItems().getSize() > 2)){
            startView.getNextButton().setEnabled(true);
        }
    }
    
    public void handleAddInputAlphabetButton() {
  	String alphabet = startView.getInputAlphabetTextField().getText().trim();
    	if((alphabet.length() > 0) && (startView.getInputAlphabetItems().contains(alphabet) == false)){
                startView.getInputAlphabetItems().addElement(alphabet);                		
    		startView.getInputAlphabetTextField().setText("");
                if(startView.getTapeAlphabetItems().contains(alphabet) == false){
                    startView.getTapeAlphabetItems().addElement(alphabet);
                }
    	}
        if((startView.getTapeAlphabetItems().getSize() > 1) && (startView.getInputAlphabetItems().getSize() > 0) && (startView.getStateItems().getSize() > 2)){
            startView.getNextButton().setEnabled(true);
        }
    }
    
    public void handleAddStateButton() {
      	String state = startView.getStateTextField().getText().trim();
    	if((state.length() > 0) && (startView.getStateItems().contains(state) == false)){
    		startView.getStateItems().addElement(state);
    		startView.getStateTextField().setText("");
            startView.getStartItems().addElement(state);
    	}
        if(startView.getStateItems().getSize() == 3){
            startView.getStartComboBox().setSelectedIndex(0);
        }
        if((startView.getTapeAlphabetItems().getSize() > 1) && (startView.getInputAlphabetItems().getSize() > 0) && (startView.getStateItems().getSize() > 2)){
            startView.getNextButton().setEnabled(true);
        }
    }
    
    public void handleRemoveTapeAlphabetButton() {
  	Object alphabet = startView.getTapeAlphabetList().getSelectedValue();
  	if(startView.getTapeAlphabetList().getSelectedIndex() > 0){ 
            startView.getTapeAlphabetItems().removeElement(alphabet);
            if(startView.getInputAlphabetItems().contains(alphabet)){
                startView.getInputAlphabetItems().removeElement(alphabet);
            }
        }
        if(startView.getTapeAlphabetItems().getSize() < 2){
            startView.getNextButton().setEnabled(false);
        }
    }
    
    public void handleRemoveInputAlphabetButton() {
  	Object alphabet = startView.getInputAlphabetList().getSelectedValue();
  	if(startView.getInputAlphabetList().getSelectedIndex() != -1){
            startView.getInputAlphabetItems().removeElement(alphabet);
            if(startView.getTapeAlphabetItems().contains(alphabet)){
                startView.getTapeAlphabetItems().removeElement(alphabet);
            }                
        }
        if(startView.getInputAlphabetItems().getSize() < 1){
            startView.getNextButton().setEnabled(false);
        }
    }
    
    public void handleRemoveStateButton() {
      	Object state = startView.getStateList().getSelectedValue();
      	if(startView.getStateList().getSelectedIndex() > 1){
            startView.getStateItems().removeElement(state);
            startView.getStartItems().removeElement(state);
        }
        if(startView.getStateItems().getSize() < 3){
            startView.getNextButton().setEnabled(false);
        }
    }
    
    public void handleNextButton() {
    	if(!isChild){
	        ListModel<String> tapeAlphabetList = startView.getTapeAlphabetList().getModel();
	        ListModel<String> inputAlphabetList = startView.getInputAlphabetList().getModel();
	        ListModel<String> stateList = startView.getStateList().getModel();        
	        
	        for(int i = 0; i<inputAlphabetList.getSize(); i++){
	            aTuringMachine.getInputAlphabet().add((String)inputAlphabetList.getElementAt(i));            
	        }
	        
	        for(int i = 0; i<tapeAlphabetList.getSize(); i++){
	            aTuringMachine.getTapeAlphabet().add((String)tapeAlphabetList.getElementAt(i));
	            transitionView.getSymbolItems().addElement((String)tapeAlphabetList.getElementAt(i));            
	        }
	        
	        for(int i = 0; i<stateList.getSize()-2; i++){
	            aTuringMachine.getStates().add((String)stateList.getElementAt(i+2));
	            transitionView.getStateItems().addElement((String)stateList.getElementAt(i+2));            
	            aTuringMachine.getTransitions().put((String)stateList.getElementAt(i+2), new HashMap<String,HashMap<String,String>>());
	            for (Object a: aTuringMachine.getTapeAlphabet()){          
	                aTuringMachine.getTransitions().get((String)stateList.getElementAt(i+2)).put((String)a, new HashMap<String,String>());
	                transitionView.getTransitionItems().addElement("[" + (String)stateList.getElementAt(i+2) + "]" + " [" + (String)a + "]" + " => ");
	            }    
	        }
	        aTuringMachine.setStartState((String)startView.getStartComboBox().getSelectedItem());        
	        aTuringMachine.setCurrentState(aTuringMachine.getStartState());
	        transitionView.getStateItems().addElement("ACCEPT");
	        transitionView.getStateItems().addElement("REJECT");	      	
	        transitionView.getTransitionList().setSelectedIndex(0);
	        transitionView.getNextButton().setEnabled(false);
    	}
    	cards.show(mainPanel,"3");
    }
    
    public void handleStartBackButton(){
    	aTuringMachine = new TuringMachine();
		startView.getInputAlphabetItems().clear();
		startView.getTapeAlphabetItems().clear();
		startView.getTapeAlphabetItems().addElement("Blank Symbol");
		startView.getStateItems().clear();
		startView.getStateItems().addElement("ACCEPT");
		startView.getStateItems().addElement("REJECT");
		startView.getStartItems().removeAllElements();
		startView.getNextButton().setEnabled(false);
    	cards.show(mainPanel,"0");
    	mainItem.setEnabled(false);
    }
    
    // transitionView handlers
    public void handleBackButton() {
    	if(!isChild){
	        aTuringMachine.getInputAlphabet().clear();
	        aTuringMachine.getTapeAlphabet().clear();
	        aTuringMachine.getStates().clear();
	        aTuringMachine.getTransitions().clear();
	        transitionView.getStateItems().removeAllElements();
	        transitionView.getSymbolItems().removeAllElements();
	        transitionView.getTransitionItems().removeAllElements();              	
    	}
    	cards.show(mainPanel,"2");
    }    
    
    public void handleSecondNextButton() {
    	if(!isChild){
    		inputView.getInputSymbols().addElement("Blank Symbol");
	        for (Object a: aTuringMachine.getInputAlphabet()){
	            inputView.getInputSymbols().addElement((String)a);
	        }
	        inputView.getInputList().setSelectedIndex(0);
    	}
        cards.show(mainPanel,"4");             
    } 
        
    public void handleSaveButton() {
        int index = transitionView.getTransitionList().getSelectedIndex();
        if (index != -1){
            String currentState = transitionView.getCurrentState().getText();
            String currentSymbol = transitionView.getCurrentAlphabet().getText(); 
            String switchTo = (String)transitionView.getStateComboBox().getSelectedItem();
            String write = (String)transitionView.getSymbolComboBox().getSelectedItem();
            String move = (String)transitionView.getDirectionComboBox().getSelectedItem();
            String currentTransition = new String("["+currentState+"] "+"["+currentSymbol+"] => ");

            aTuringMachine.getTransitions().get(currentState).get(currentSymbol).put("switchTo", switchTo);
            currentTransition += new String("[" + switchTo + "] ");
            if((switchTo == "ACCEPT") || (switchTo == "REJECT")){
                aTuringMachine.getTransitions().get(currentState).get(currentSymbol).put("write", write);
                aTuringMachine.getTransitions().get(currentState).get(currentSymbol).put("move", "Neutral");                   
            }
            else{
                aTuringMachine.getTransitions().get(currentState).get(currentSymbol).put("write", write);
                currentTransition += new String("[" + write + "] ");
                aTuringMachine.getTransitions().get(currentState).get(currentSymbol).put("move", move);   
                currentTransition += new String("[" + move + "] ");
            }
            transitionView.getTransitionItems().add(index, (String)currentTransition);
            transitionView.getTransitionItems().remove(index+1);
            boolean button = true;
            for(Object a: aTuringMachine.getStates()){
                for(Object b: aTuringMachine.getTapeAlphabet()){
                    if (aTuringMachine.getTransitions().get(a).get(b).isEmpty())
                        button = false;
                }
            }
            transitionView.getNextButton().setEnabled(button);
            
            if(index < transitionView.getTransitionItems().size()){
            	transitionView.getTransitionList().setSelectedIndex(index+1);
            }
        }
    }
    
    public void handleSelectedListItem() {
       int index = transitionView.getTransitionList().getSelectedIndex();    
       if(index != -1){
            String currentState = (String)aTuringMachine.getStates().get(index/aTuringMachine.getTapeAlphabet().size());
            String currentSymbol = (String)aTuringMachine.getTapeAlphabet().get(index%aTuringMachine.getTapeAlphabet().size());
            transitionView.getCurrentState().setText(currentState);
            transitionView.getCurrentAlphabet().setText(currentSymbol);          
            
            if(aTuringMachine.getTransitions().get(currentState).get(currentSymbol).isEmpty()){
                transitionView.getStateComboBox().setSelectedIndex(0);
                transitionView.getSymbolComboBox().setSelectedIndex(0);
                transitionView.getDirectionComboBox().setSelectedIndex(0);
            }
            else{                
                transitionView.getStateComboBox().setSelectedItem((String)aTuringMachine.getTransitions().get(currentState).get(currentSymbol).get("switchTo"));
                transitionView.getSymbolComboBox().setSelectedItem((String)aTuringMachine.getTransitions().get(currentState).get(currentSymbol).get("write"));
                transitionView.getDirectionComboBox().setSelectedItem((String)aTuringMachine.getTransitions().get(currentState).get(currentSymbol).get("move"));
            }
        }
    }
     
    public void handleComboBoxSelection(){
        if((transitionView.getStateComboBox().getSelectedItem() == "ACCEPT") || (transitionView.getStateComboBox().getSelectedItem() == "REJECT")){
            transitionView.getSymbolComboBox().setEnabled(false);
            transitionView.getDirectionComboBox().setEnabled(false);
        }
        else{
        	if(!isChild){
	            transitionView.getSymbolComboBox().setEnabled(true);
	            transitionView.getDirectionComboBox().setEnabled(true);
        	}
        }
    }
    
    //inputView handlers    
    public void handleAddInputButton() {        
        if(inputView.getInputList().getSelectedIndex() != -1){
            String symbol = (String)inputView.getInputList().getSelectedValue();
            if (symbol.equals("Blank Symbol")) symbol = "|_|";
            int cell = inputView.getSlider().getValue();            
            inputView.getInputLabels(cell-1).setText(symbol);
            if(cell < 31){
                inputView.getSlider().setValue(cell+1);
            }           
        }       
    } 
    
    public void handleDeleteInputButton() {        
        int cell = inputView.getSlider().getValue();
        inputView.getInputLabels(cell-1).setText("");              
    }
    
    public void handleClearInputButton(){
    	for(int i = 0; i < 31; i++){
	    	inputView.getInputLabels(i).setText("");
	    }
    	inputView.getSlider().setValue(1);
    }
    
    public void handleSecondBackButton() {
    	if(!isChild){
	        for(int i = 0; i < 31; i++){
	            inputView.getInputLabels(i).setText("");
	        }
	        inputView.getInputSymbols().clear();
	        inputView.getSlider().setValue(1);	           
    	}
    	cards.show(mainPanel,"3"); 
    }
    
    public void handleBuildButton() {
    	aTuringMachine.getInput().clear();
        aTuringMachine.getInput().add("Blank Symbol");
        for(int i = 0; i < 31; i++){
            if((inputView.getInputLabels(i).getText().trim().equals("")) || (inputView.getInputLabels(i).getText().trim().equals("|_|"))){
                aTuringMachine.getInput().add("Blank Symbol");                
            }
            else{
                aTuringMachine.getInput().add(inputView.getInputLabels(i).getText().trim());
            }
        }   
        aTuringMachine.getInput().add("Blank Symbol");
        simulationView.setInput(aTuringMachine.getInput());
        cards.show(mainPanel,"5");             
        simulationView.getSaveMachineButton().setEnabled(true);
        simulationView.getRunButton().setText("Start");
        simulationView.getSlider().setEnabled(true);
        simulationView.getState().setText(aTuringMachine.getCurrentState());
        simulationView.getState().setFont(new Font("arial", Font.BOLD,12));
        simulationView.getState().setForeground(Color.black);
        simulationView.getPrintError().setText(""); 
        simulationView.setPrintOrder(-1);
        simulationView.repaint();
    }
    
    // simulationView handlers   
    public void handleChangeInputButton() {
        aTuringMachine.setCurrentCell((int)simulationView.getSpinner().getValue());
        aTuringMachine.setCurrentState(aTuringMachine.getStartState());
        aTuringMachine.getInput().clear();
        cards.show(mainPanel,"4");           
    }
    
    public void handleResetButton(){
        if(aTimer.isRunning()){
            aTimer.stop();
        }
        aTuringMachine.getInput().clear();
        aTuringMachine.getInput().add("Blank Symbol");
        simulationView.getPrintError().setText("");
        for(int i = 0; i < 31; i++){
            if((inputView.getInputLabels(i).getText().equals("")) || (inputView.getInputLabels(i).getText().equals("|_|"))){
                aTuringMachine.getInput().add("Blank Symbol");                
            }
            else{
                aTuringMachine.getInput().add(inputView.getInputLabels(i).getText());
            }
        }   
        aTuringMachine.getInput().add("Blank Symbol");         
        simulationView.setInput(aTuringMachine.getInput());               
        aTuringMachine.setCurrentCell(aTuringMachine.getStartCell());
        aTuringMachine.setCurrentState(aTuringMachine.getStartState());    
        simulationView.getState().setText(aTuringMachine.getCurrentState());
        simulationView.getState().setFont(new Font("arial", Font.BOLD,12));
        simulationView.getState().setForeground(Color.black);
        simulationView.setTapeHeadCell(aTuringMachine.getCurrentCell());
        simulationView.getChangeInputButton().setEnabled(true);
        simulationView.getSpinner().setEnabled(true);
        simulationView.getSlider().setEnabled(true);
        simulationView.getRunButton().setText("Start");
        simulationView.getRunButton().setEnabled(true);
        simulationView.getSaveMachineButton().setEnabled(true);
        simulationView.setPrintOrder(-1);
        simulationView.repaint();
    }
    
    public void handleRunButton() {
        if(simulationView.getRunButton().getText().equals("Start")){
            aTuringMachine.setStartCell((int)simulationView.getSpinner().getValue());
            aTuringMachine.setCurrentCell(aTuringMachine.getStartCell());
            aTimer.setDelay((11 - simulationView.getSlider().getValue())*100);            
            simulationView.getChangeInputButton().setEnabled(false);
            simulationView.getRunButton().setText("Pause");
            simulationView.getSlider().setEnabled(false);
            simulationView.getSpinner().setEnabled(false);
            simulationView.getSaveMachineButton().setEnabled(false);
            simulationView.setPrintOrder(-1);
            aTimer.start();
        }
        else if (simulationView.getRunButton().getText().equals("Continue")){
            aTimer.start();
        	simulationView.getRunButton().setText("Pause");
        }
        else{
            aTimer.stop();
        	simulationView.getRunButton().setText("Continue");
        }     
    }
    
    public void handleSaveMachineButton(){
    	String name = JOptionPane.showInputDialog(this,"Machine name?",null);
    	if(name == null){        	
        }
        else if(name.trim().length() > 0){
        	File savingDir = new File("Saved");
	    	if (!savingDir.exists()){
	    		savingDir.mkdirs();
	    	}
	    	File savingMachine = new File("Saved/" + name);
	    	int result;
	    	if(savingMachine.exists()){
	    		result = JOptionPane.showConfirmDialog(mainWindow,name.concat(" already exists.\nDo you want to replace it?"),"Confirm",JOptionPane.YES_NO_OPTION);	
	    	}
	    	else{
	    		result = -5;
	    	}				 
			if ((result == JOptionPane.YES_OPTION) || (result == -5)) {
				try { 		
		    		savingMachine.mkdirs(); 
		    		
		 			ObjectOutputStream modelOut; 	 				
		 			modelOut = new ObjectOutputStream(new FileOutputStream("Saved/" + name + "/" + name + ".model")); 
		 			modelOut.writeObject(aTuringMachine); 
		 			modelOut.close();
		 			
		 			ObjectOutputStream startOut; 	 				
		 			startOut = new ObjectOutputStream(new FileOutputStream("Saved/" + name + "/" + name + ".start")); 
		 			startOut.writeObject(startView); 	
		 			startOut.close(); 
		 				
		 			ObjectOutputStream transitionOut; 	 				
		 			transitionOut = new ObjectOutputStream(new FileOutputStream("Saved/" + name + "/" + name + ".transition")); 
		 			transitionOut.writeObject(transitionView); 
		 			transitionOut.close(); 
		 				
		 			ObjectOutputStream inputOut; 	 				
		 			inputOut = new ObjectOutputStream(new FileOutputStream("Saved/" + name + "/" + name + ".input")); 
		 			inputOut.writeObject(inputView); 
		 			inputOut.close(); 	 					
		 				
		 			JOptionPane.showMessageDialog(this,name + " has been saved.");	
		 		} catch (FileNotFoundException e) { 
		 			System.out.println("Error: Cannot open file for writing"); 
		 			JOptionPane.showMessageDialog(this,"File could not be saved","Error",JOptionPane.ERROR_MESSAGE);	
		 		} catch (IOException e) { 
		 			System.out.println("Error: Cannot write to file");
		 			JOptionPane.showMessageDialog(this,"File could not be saved.","Error",JOptionPane.ERROR_MESSAGE); 
		 		}    		
	    	}		    		                      
		    else{
		    	handleSaveMachineButton();
	    	}
 		}
 		else{
 			handleSaveMachineButton();
 		} 
    }      
   
    public void handleSlider(JSlider source){
        if(source.getValueIsAdjusting()){
            int delay = source.getValue();
            if(delay > 0){
                aTimer.setDelay(100*(11-delay));
                if(aTimer.isRunning()){
                    aTimer.restart();
                }    
            }
            else{
            	aTimer.restart();
            }
        }        
    }
    
    public void handleSpinner(JSpinner source){
        aTuringMachine.setStartCell((int)source.getValue());
        aTuringMachine.setCurrentCell(aTuringMachine.getStartCell());
        simulationView.setTapeHeadCell(aTuringMachine.getCurrentCell());
        simulationView.repaint();                    
    }
    
    // Timer handler
    public void handleTimerTick(){           
        if((aTuringMachine.getCurrentState().equals("ACCEPT")) || (aTuringMachine.getCurrentState().equals("REJECT"))){
            aTimer.stop();
            simulationView.getState().setFont(new Font("arial", Font.BOLD,14));
            if(aTuringMachine.getCurrentState().equals("ACCEPT")){
            	simulationView.getState().setForeground(new Color(38,106,46));
            }
            else{
            	simulationView.getState().setForeground(Color.red);
            }            
            simulationView.getRunButton().setEnabled(false);
        }       
        if(((aTuringMachine.getCurrentCell() < 0) && (aTuringMachine.getMoveTo().equals("Left"))) || ((aTuringMachine.getCurrentCell() == aTuringMachine.getInput().size()) && (aTuringMachine.getMoveTo().equals("Right")))){  
            aTimer.stop();
            simulationView.getRunButton().setEnabled(false);            
            if((aTuringMachine.getCurrentCell() < 0) && (aTuringMachine.getMoveTo().equals("Left"))){
            	simulationView.setTapeHeadCell(simulationView.getTapeHeadCell() - 1); 
            }
            else{
            	simulationView.setTapeHeadCell(simulationView.getTapeHeadCell() + 1); 
            }
            simulationView.repaint();
        	simulationView.getPrintError().setText("Error: Out of Tape bound");
        	JOptionPane.showMessageDialog(this,"The simulation has been stopped. Tapehead went out of bound.","Error",JOptionPane.ERROR_MESSAGE);
        } 	
        int order = simulationView.getPrintOrder();
        if(order == -1){
        	simulationView.setPrintOrder(0); 
        }
        if(order == 0){
        	simulationView.setPrintOrder(1); 
        	aTuringMachine.processSymbol();
        }
        if(order == 2){
        	simulationView.setTapeHeadCell(aTuringMachine.getCurrentCell());	        
	        simulationView.setPrintOrder(-1);   	
        }
        else if(order == 1){      
	        simulationView.setInput(aTuringMachine.getInput());
	        simulationView.getState().setText(aTuringMachine.getCurrentState());
	        simulationView.setPrintOrder(2);      
        }
        simulationView.repaint();            	                   	      
    }
    
    // Main function
    public static void main(String[] args) {
    	TuringMachine aModel = new TuringMachine();
    	new TuringMachineFrame("Turing Machine Simulator", false, aModel, new TuringMachineMenuPanel(), new TuringMachineLoadPanel(), new TuringMachineStartPanel(), new TuringMachineTransitionPanel(), new TuringMachineInputPanel(), new TuringMachineSimulationPanel()).setVisible(true);
    }
}
