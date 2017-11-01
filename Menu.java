//Sasan Shafikhani and Chris Lee
//Project 3 Main 
//CS342 by Patrick Troy
//reference from Java website for 2D rendering
package Project3;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;

public class Menu extends JFrame{
 
  private JPanel numbersAndEraser; 
  private Interface sudokuInterface;
 
  
  //GUI
  public Menu(){
    super( "Sudoku Puzzle" );
    this.setMinimumSize(new Dimension(800,600));
    //build bar
    JMenuBar bar = new JMenuBar();  
    setJMenuBar( bar );  
    
    // *File Menu and its items
    JMenu fileMenu = new JMenu( "File" );
    fileMenu.setMnemonic( 'F' );
    
    //File->Load a Puzzle from a File TODO
    JMenuItem loadItem = new JMenuItem( "Load a Puzzle from a File" );
    loadItem.setMnemonic( 'l' );
    fileMenu.add( loadItem );
    
    JFileChooser loadFile= new JFileChooser();
    loadFile.setApproveButtonText("Select File");
    
    //End of File->Load a Puzzle from a File 
    
    
    //File->Store a Puzzle into a File TODO
    JMenuItem storeItem = new JMenuItem( "Store a Puzzle into a File" );
    storeItem.setMnemonic( 's' );
    fileMenu.add( storeItem );
    //End of File->Store a Puzzle into a File
    
    //File->Exit
    JMenuItem exitItem = new JMenuItem( "Exit" );
    exitItem.setMnemonic( 'x' );
    fileMenu.add( exitItem );
    exitItem.addActionListener(
       new ActionListener() {  // inner class expression
          //exit
          public void actionPerformed( ActionEvent event )
          {
             System.exit( 0 );
          }
       }  // end of inner class expression
    ); // end action listencer
    //end of File->Exit
    bar.add( fileMenu );  
    //*End of File Menu
    
    //*Help Menu and its items
    JMenu helpMenu = new JMenu( "Help" );
    fileMenu.setMnemonic( 'H' );
    
    //Help->How to Play
    JMenuItem howItem = new JMenuItem( "How to Play" );
    howItem.setMnemonic( 'p' );
    helpMenu.add( howItem );
    howItem.addActionListener(
       new ActionListener() {  // inner class expression
          //display dialogue box
          public void actionPerformed( ActionEvent event )
          {
             JOptionPane.showMessageDialog( Menu.this,
                  "This is an example\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE );
          }
       }  // end of inner class expression
    ); // end action listencer
    
    //Help->About
    JMenuItem aboutItem = new JMenuItem( "About" );
    aboutItem.setMnemonic( 'a' );
    helpMenu.add( aboutItem );
    aboutItem.addActionListener(
       new ActionListener() {  // inner class expression
          //display dialogue box
          public void actionPerformed( ActionEvent event )
          {
             JOptionPane.showMessageDialog( Menu.this,
                  "This is an example\nof using menus",
                  "About", JOptionPane.PLAIN_MESSAGE );
          }
       }  // end of inner class expression
    ); // end action listencer
    
    bar.add( helpMenu );    
    //*End of Help Menu
    
    //*Hints Menu and its items
    JMenu hintsMenu = new JMenu( "Hints" );
    fileMenu.setMnemonic( 'I' );
    
    //TODO
    
    bar.add( hintsMenu );    
    //*End of Help Menu
    
    this.setJMenuBar(bar); 
    //end of bar build
    
    //Tie it together with window panel, then attach to this
    JPanel mainBoard = new JPanel();
    mainBoard.setLayout(new FlowLayout());
    mainBoard.setSize(new Dimension(800,600));
    

    //for buttons on the side
    numbersAndEraser = new JPanel();
    numbersAndEraser.setSize(new Dimension(100,550));
    
    sudokuInterface =  new Interface();
    
    mainBoard.setVisible(true);
    mainBoard.add(sudokuInterface);
    mainBoard.add(numbersAndEraser);
       
    this.add(mainBoard);     
    setUpButtons();
    setVisible(true);

    
    //sudokuInterface.repaint();
  }
  
  //renews the board after action, also adds button to panel in order to reflect switches
 
    
    public void setUpButtons(){
      for(String value : new String[]{"1","2","3","4","5","6", "7","8","9"}) {
      JButton button = new JButton(value);
      button.setPreferredSize(new Dimension(55, 55));
     
      button.addActionListener(sudokuInterface.new RetrieveValueActionListener());
      System.out.println(sudokuInterface.luckyNumber);
      numbersAndEraser.add(button);
      }
      
      JButton eraserButton = new JButton("X");
      eraserButton.setPreferredSize(new Dimension(55, 55));
      numbersAndEraser.add(eraserButton);
  
    
  }
    
  //main method
  public static void main(String[] args) { 
    Menu application = new Menu();
    application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );    
  }
  
}
