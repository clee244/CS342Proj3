package Project3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.event.MouseInputAdapter; //for SIMIA class

//sudoku panel help

public class SudokuInterface extends JPanel {
  //private Board board;
  private int chosenCollumn, chosenRow;
  private int height; 
  private int width;
  
  //constructor
  public SudokuInterface() { 
    //initialize board variables
    int outOfBounds = -1;
    this.setPreferredSize(new Dimension(540,450)); //adjust size
    
    this.addMouseListener(new SudokuInterfaceMouseInputAdapter());
    //this.board = 
    this.chosenRow = outOfBounds;
    this.chosenCollumn = outOfBounds;
    width = 0;
    height = 0;
     
    }
  //end of constructor
  
  //draw and stroke sudoku board using paintComponent superclass with modifications
  @Override
  public void paintComponent(Graphics graphics){
    
    //accomodate superclass for board
    super.paintComponent(graphics); //call parent constructor
    Graphics2D plane = (Graphics2D) graphics;
    
    //retrieve width and height of each of the 9x9 blocks
    int blockWidth = this.getWidth() / 9;
    int blockHeight = this.getHeight() / 9;
    
    //progress along the board
    this.width = blockWidth * 9;
    this.height = blockHeight * 9;
    
    
    
    //set spaces to white
    plane.fillRect(0, 0, width, height);
    plane.setColor(new Color(1.0f,1.0f,1.0f));
  }
  //FIX
  
  
  
  private class SudokuInterfaceMouseInputAdapter extends MouseInputAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
      if(e.getButton() == MouseEvent.BUTTON1) {
        
      }
    }
  }
  
  //retrieval classes
  public int getWidth(){
    return width;
  }
  public int getHeight(){
    return height;
  }
  //end of retrieval classes
    
  }

  
 
  

