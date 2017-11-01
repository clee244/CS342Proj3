package Project3;
import java.util.*;

public class Board{

 protected String [][] matrix; //values to be stored on bored
 protected boolean [][] added; //which sudoku box values can be changed? Recently added ones can, as opposed to initial
 protected List<String> [][] candidates; //values for each mini box showing values that can be entered w/o error
 protected String [] values; //all valid values to be used on sudoku board (ie. 1-9)
 

 //create board of values and their eligibilities
 @SuppressWarnings("unchecked")
 public Board() {
   this.matrix = new String[9][9];
   this.added = new boolean[9][9];
   this.candidates = new List[9][9];
   
   this.values = new String [] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
   this.matrix = new String[9][9]; //values occupying space
   this.added = new boolean[9][9]; //determines if the values can be changed
   
   //initialize all three 2D arrays
   for(int currRow = 0; currRow < 9; currRow++) {
     for(int currCol = 0; currCol < 9; currCol++) {
       this.matrix[currRow][currCol] = "";
       
       this.candidates[currRow][currCol] = new LinkedList<String>();
       for(int numCount = 1; numCount < 9; numCount++){
         candidates[currRow][currCol].add(values[numCount-1]); //all nine values will be initial candidates
       }
       
       this.added[currRow][currCol] = true;
       
   }
 } //end of for loop initialization
 
} //end of constructor
//function meant for player to add value onto board where value isn't locked
 public void enterValue(int row, int column, String value){
   if(isCandidate(row,column,value)){
     this.matrix[row][column] = value;
   }
     
   
 } 

 public boolean isCandidate(int row, int column, String value){
   String target = value;
   if(candidates[row][column].contains(value))
     return true;
     
   return false;
 }
 
 
 
 public String[] getButtonValues(){
   return values;
 }
 
 public String getString(int row, int col){
   return this.matrix[row][col];
 }
   
} //end of Board class
 
 
//This class pertains to the matrices that hold the values, and will determine the number of valid values necessary for the algorithms