import javax.swing.*;
import java.awt.*;

public class PanelController extends JFrame {

    PanelModel pm = new PanelModel();
    PanelView pv = new PanelView();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PanelController frame = new PanelController();
                    frame.pv.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PanelController(){
        pv.initialize(pm);
    }







}
