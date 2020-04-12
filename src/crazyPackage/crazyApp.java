package crazyPackage;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class crazyApp {
    private static JButton clickMeButton;
    //private JPanel panel1;
    private static MoveWindow mw;
    private static JFrame frame;
    private static long ms;
    private static char s;
    private static boolean isHasLeaderboard;
    private static int looped = 0;
    private static boolean looping = false;
    private static int sc;

    public crazyApp() {
    	
    	// Moniter Size
    	
    	// init method
    	mw = new MoveWindow();
    	clickMeButton = new JButton("Click Me!");
    	
        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(looping) {
                	sc++;
                }
            }
        });
        
        
    }

    public static void main(String[] args) {
    	// Init
    	Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	new crazyApp();
    	System.out.println("Game is initiallized!");
    	
        frame = new JFrame("crazyApp");
        //int width;
        //int height;

        Dimension dim = new Dimension(500, 500);

        frame.setMaximumSize(dim);
        frame.setMinimumSize(dim);
        frame.setSize(dim);
        // BUG: frame.setContentPane(new crazyApp().panel1);
        frame.add(clickMeButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
        try{
            //파일 객체 생성
            File file = new File(System.getProperty("user.dir") + "\\crazyApp_diff.conf");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            int singleCh = 0;
            String abc = "";
            while((singleCh = filereader.read()) != -1){
                s = (char)singleCh;
                
                
            }
            
            System.out.println(Character.toString(s));
            
            switch(Character.toString(s)) {
            case "Y":
            	System.out.println("set diff to easy.");
            	JOptionPane.showMessageDialog(null, "crazyApp_diff.conf를 이지로 설정하였습니다.\n리더보드 기능을 사용하실 수 없습니다.");
            	isHasLeaderboard = false;
            	ms = 1000;
            	
            	break;
            case "L":
            	ms = 500;
            	System.out.println("set diff to normal.");
            	isHasLeaderboard = true;
            	break;
            case "D":
            	ms = 100;
            	System.out.println("set diff to hard.");
            	isHasLeaderboard = true;
            	break;
            case "E":
            	ms = 10;
            	System.out.println("! set diff to extreme !");
            	isHasLeaderboard = true;
            	break;
            case "N":
            	ms = 1;
            	System.out.println("!! set diff to demon !!");
            	isHasLeaderboard = true;
            	break;
            default:
            	System.out.println("failed to set diff.");
            	JOptionPane.showMessageDialog(null, "ERROR: failed to set diff");
            	System.exit(2);
            }
            filereader.close();
        }catch (FileNotFoundException e) {
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
        
        looping = true;
        
        while(looping) {
        	mw.Move(dimen.width, dimen.height, frame);
        	try {
				Thread.sleep(ms);
				if(looped == 10 * ms) {looping = false;} else {
					looped = looped + 1;
					System.out.println("now score: " + sc);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		// 게임 끝났을때
        System.out.println("game is end! score: " + Integer.toString(sc));
        new Leaderboard().setUserInfo("root", "시크릿 쥬쥬!☆");
        Leaderboard.insertLeaderBoard("test", sc);
        
    }
}
