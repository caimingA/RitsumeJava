import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

public class MyMouseListener implements MouseInputListener {
    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println(me.paramString());
    }
    @Override
    public void mouseEntered(MouseEvent me) {
        System.out.println(me.paramString());
    }
    @Override
    public void mouseExited(MouseEvent me) {
        System.out.println(me.paramString());
    }
    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println(me.paramString());
    }
    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println(me.paramString());
    }
    @Override
    public void mouseMoved(MouseEvent me) {
        System.out.println(me.paramString());
    }
    @Override
    public void mouseDragged(MouseEvent me) {
        System.out.println(me.paramString());
    }
}
