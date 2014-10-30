import java.util.*;

// TuringMachine class
public class TuringMachine implements java.io.Serializable {
	
	// attributes
	private String 												   startState, currentState, currentSymbol, toState, writeSymbol, moveTo;
	private int 												   currentCell, startCell;	
	private ArrayList<String> 									   input, tapeAlphabet, inputAlphabet, states;
	private HashMap<String,HashMap<String,HashMap<String,String>>> transitions;
	
	// get methods
	public String 												  getStartState() { return startState; }
	public String 												  getCurrentState() { return currentState; }
	public String 												  getCurrentSymbol() { return currentSymbol; }
	public String 												  getToState() { return toState; }
	public String 												  getWriteSymbol() { return writeSymbol; }
	public String 												  getMoveTo() { return moveTo; }
	public int 													  getCurrentCell() { return currentCell; }
	public int 													  getStartCell() { return startCell; }
	public ArrayList<String> 									  getInput() { return input; }
	public ArrayList<String> 									  getTapeAlphabet() { return tapeAlphabet; }
	public ArrayList<String> 									  getInputAlphabet() { return inputAlphabet; }
	public ArrayList<String> 									  getStates() { return states; }
	public HashMap<String,HashMap<String,HashMap<String,String>>> getTransitions() { return transitions; }
	
	// set methods
	public void setStartState(String start){ startState = start; }
	public void setCurrentState(String current){ currentState = current; }
	public void setStartCell(int start) { startCell = start; }
	public void setCurrentCell(int current) { currentCell = current; }
		
    // constructor    
    public TuringMachine() {
        input = new ArrayList<String>();        
    	tapeAlphabet = new ArrayList<String>();
        inputAlphabet = new ArrayList<String>();
    	states = new ArrayList<String>();
    	transitions = new HashMap<String,HashMap<String,HashMap<String,String>>>();    	    	
    	currentState = startState;
    	currentCell = 1;
        startCell = 1;    	
    }
    
    // make transition
    public void processSymbol(){
        if ((!(currentState.equals("ACCEPT"))) && (!(currentState.equals("REJECT")))){
            currentSymbol = (String)input.get(currentCell);
            toState = transitions.get(currentState).get(currentSymbol).get("switchTo");
            writeSymbol = transitions.get(currentState).get(currentSymbol).get("write");
            moveTo = transitions.get(currentState).get(currentSymbol).get("move");     
            currentState = toState;
            if((currentState.equals("ACCEPT")) || (currentState.equals("REJECT"))){
            	// Do nothing
            }
            else{
                input.set(currentCell,writeSymbol); 
                if(moveTo.equals("Left")){
                    if(currentCell >= 0){
                        currentCell = currentCell - 1;
                    }
                }
                if(moveTo.equals("Right")){
                    if(currentCell < input.size()){
                        currentCell = currentCell + 1;
                    }
                }
                if(moveTo.equals("Neutral")){
                	// Stay at current cell
                }           
            }
        }
    }       
}