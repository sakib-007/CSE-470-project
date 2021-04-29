import javax.swing.*;
import java.awt.*;

public class HelpController extends JFrame {
    HelpModel hm = new HelpModel();
    HelpView hv = new HelpView();
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HelpController frame = new HelpController();
                    frame.hv.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public HelpController(){

        hv.initialize(hm.contentPane);
    }


}
