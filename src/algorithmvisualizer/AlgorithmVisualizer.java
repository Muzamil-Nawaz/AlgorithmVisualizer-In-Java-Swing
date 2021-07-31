package algorithmvisualizer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class AlgorithmVisualizer extends JFrame{

    public AlgorithmVisualizer() throws HeadlessException {
        setSize(1100,600);
        //getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
        setVisible(true);
        panel.setSize(600,500);
        panel.setLayout(new GridLayout(8,8));
        panel2.setSize(400,600);
        panel2.setLayout(new GridLayout(5,1));
        add(panel);
        JLabel prevFill = new JLabel("Enter the character to replace");
        JTextField prevFilltf = new JTextField();

        prevFill.setBounds(750,30,200,25);
        prevFilltf.setBounds(750,70,200,25);
        panel2.add(prevFill);
        panel2.add(prevFilltf);
        add(panel2);
        
    }
    JButton board [][] = new JButton[8][8];
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    public void createBoard(){
        int x = 10;
        int y = 10;
        for(int i =0; i<8; i++){
            for (int j = 0; j < 8; j++) {
                
                board[i][j] = new JButton();
                //board[i][j].setBounds(x, y, 50, 50);
                x +=50;
                panel.add(board[i][j]);
                System.out.println("i:"+i+" j:"+j);
                
            }
            x = 15;
            y+=45;
        }
//        this.add(panel);
    }
    public void fillBoard(){
        for(int i = 0; i<board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].setText(getRandom()+"");
            }
        }
    }
    public  void fillFlood(JButton arr [][],int row,int col,String prevFill,String toFill){
		if(row<0 || row >=arr.length || col<0 || col >=arr[0].length){
			return;
		}
		if(arr[row][col].getText().equals(prevFill)){
			arr[row][col].setText(toFill);
                        arr[row][col].setBackground(Color.yellow);
                        arr[row][col].setForeground(Color.RED);
                        try{
                            Thread.sleep(500);
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                }
		else
			return;
		System.out.print("row:"+row+" col:"+col);
		fillFlood(arr,row+1,col,prevFill,toFill);
		fillFlood(arr,row,col+1,prevFill,toFill);
		fillFlood(arr,row-1,col,prevFill,toFill);
		fillFlood(arr,row,col-1,prevFill,toFill);
                fillFlood(arr,row-1,col+1,prevFill,toFill);
                fillFlood(arr,row+1,col+1,prevFill,toFill);
                fillFlood(arr,row-1,col-1,prevFill,toFill);
                fillFlood(arr,row+1,col-1,prevFill,toFill);
                
                
                
                
	}
    public int getRandom(){
        Random r = new Random();
        return r.nextInt(2);
    }
    
    public static void main(String[] args) {
        AlgorithmVisualizer visualizer = new AlgorithmVisualizer();
        visualizer.createBoard();
        visualizer.fillBoard();
        System.out.println(visualizer.board[4][4].getText());
        visualizer.fillFlood(visualizer.board,4,4,visualizer.board[4][4].getText(),"9");
        JOptionPane.showMessageDialog(null,"Hope you enjoyed the visualiztion.");
        // TODO code application logic here
    }
    
}
