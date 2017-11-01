package Project3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter; //for SIMIA class
import java.awt.font.FontRenderContext;
//sudoku panel help

public class Interface extends JPanel {
  //private Board board;
  
  private int currX, currY; //mouse position with respect to 9x9 board
  private int currentButton;
  private int height; //expended height when traversing
  private int width;  //ditto for width
  private int numCol;
  private int numRows;
  private int heightGraph;
  private int widthGraph;
  public Board board;
  public String luckyNumber;
  
  //constructor
  public  Interface() { 
    //initialize board variables
    board = new Board();
    luckyNumber = "";
    int outOfBounds = -1;
    this.setPreferredSize(new Dimension(560,450)); //adjust size
    currentButton = -5; //TEST
    this.addMouseListener(new InterfaceMouseInputAdapter());
    //this.board = 
    this.currY = outOfBounds;
    this.currX = outOfBounds;
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
    

    
    //retrieve width and height of each of the blocks within the 9x9 matrix
    //by distributing the pixels between them
    int blockWidth = 560 / 9; 
    int blockHeight = 450 / 9;
    
    //progress along the board
    this.width = blockWidth * 9;
    this.height = blockHeight * 9;
    
    //set spaces to white
    plane.setColor(new Color(1.0f,1.0f,1.0f));
    plane.fillRect(0, 0, width, height);
    
    //...and lines to black
    plane.setColor(new Color(0.0f,0.0f,0.0f));

    int groupNum = 3;
    //"traverse" block by block to draw lines
    //first for verticality
    
    for(int count = 0; count <= width; count+=blockWidth) { //determine thickness of lines, based on boxing
      if((count/blockWidth) % groupNum != 0) //3 being the width and height for each square grouping of 9 blocks
        plane.setStroke(new BasicStroke(1));      
      else
        plane.setStroke(new BasicStroke(2)); 
      


      plane.drawLine(count, 0, count, height);
    }
    //now for horizontality
    for(int count = 0; count <= height; count+=blockHeight){
      if((count/blockHeight) % groupNum != 0)
        plane.setStroke(new BasicStroke(1));      
      else
         plane.setStroke(new BasicStroke(2)); 
      
     plane.drawLine(0, count, width - 1, count);
    }

    Font font = new Font("Calibri", Font.PLAIN, 24);
    plane.setFont(font);
    FontRenderContext fContext = plane.getFontRenderContext();
    for(int row=0; row < 9; row++) {
      for(int col=0; col < 9; col++) {
       
         plane.drawString(board.getString(row,col),col*(blockWidth) + 25 , 
                          (row*(blockHeight)) + 35 );
         
         
        
      }
    }
    
    //ENTER
    //highlight and enter value into last selected block in board 
    if(currX != -1 && currY != -1) {
      plane.setColor(new Color(0.0f,0.5f,1.0f,0.8f));
      plane.fillRect(blockWidth * currX, blockHeight * currY, blockWidth, blockHeight);
      //plane.drawString("I", (currX*blockWidth)+((blockWidth/2)-(blockWidth/2)), (currY*blockHeight)+((blockHeight/2)));
      board.enterValue(currY, currX, luckyNumber);

      //reprintBoard(plane, blockWidth, blockHeight);
      
      repaint();
    } 
  
  }
  
  public class RetrieveValueActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
       if(currX != -1 && currY != -1) {
         luckyNumber = ((JButton) e.getSource()).getText();
         
         repaint();
       }
    }
 }
  
  //TEST  
  public void reprintBoard(Graphics2D plane, int blockWidth, int blockHeight){
    for(int row=0; row < 9; row++) {
      for(int col=0; col < 9; col++) {
        Font font = new Font("Calibri", Font.PLAIN, 24);
           plane.drawString(board.getString(row,col), (col*blockWidth) + ((blockWidth/2) - (blockWidth/2)), 
                   row*blockHeight + (blockHeight/2) + 10);
        
      }
    }
  }
  
  //activate mouse for use on board
  private class InterfaceMouseInputAdapter extends MouseInputAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
      if(e.getButton() == MouseEvent.BUTTON1) {
        int blockWidth = 560 / 9;
        int blockHeight = 450 / 9;
        currY = e.getY() / blockHeight;
        currX = e.getX() / blockWidth;
        e.getComponent().repaint();
      }
    }
  }
  
  

}

  
 
  

