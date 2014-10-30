import javax.swing.*;

//TuringMachineLoadPanel class
public class TuringMachineLoadPanel extends JPanel{
	
	// attributes
	private JButton					 loadMachineButton, removeMachineButton, loadBackButton;
	private JList<String>  			 filesList;		   
	private JScrollPane         	 filesScrollPane;	
	private DefaultListModel<String> files = new DefaultListModel<String>();
		
	// get methods
	public JList<String>		 	getFileList() { return filesList;}
	public JScrollPane       		getFileScrollPane() { return filesScrollPane; }
	public JButton           		getLoadMachineButton() { return loadMachineButton; }
	public JButton           		getRemoveMachineButton() { return removeMachineButton; }
	public JButton           		getLoadBackButton() { return loadBackButton; }
	public DefaultListModel<String> getFileItems() { return files; }
	
	// constructor
    public TuringMachineLoadPanel() {

    	setLayout(null);
    	
    	//Add label
    	JLabel label = new JLabel("Select a Machine: ");
		label.setLocation(300,35);
		label.setSize(800, 40);
    	add(label);
    	
    	//Add list
 		filesList = new JList<String>(files);
    	filesScrollPane = new JScrollPane(filesList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		filesScrollPane.setLocation(300,80);
		filesScrollPane.setSize(400, 485);
    	add(filesScrollPane);
    	
    	//Add buttons    	    	   	
    	loadBackButton = new JButton("Main Menu");
    	loadBackButton.setLocation(50,35);
		loadBackButton.setSize(100, 40);
    	add(loadBackButton);
    	
    	loadMachineButton = new JButton("Load Machine");
    	loadMachineButton.setLocation(580,590);
		loadMachineButton.setSize(120, 40);
    	add(loadMachineButton);
    	
    	removeMachineButton = new JButton("Remove Machine");
    	removeMachineButton.setLocation(300,590);
		removeMachineButton.setSize(140, 40);
    	add(removeMachineButton);
    }    
}