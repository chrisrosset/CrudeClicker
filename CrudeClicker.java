import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * click click click :>
 * @author Krzysztof Rosset
 */
public class CrudeClicker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if(args.length != 6) {
            System.out.println("CrudeClicker - usage:");
            System.out.println("CrudeClicker -x [num] -y [num] -c [num]");
            System.out.println("-x - desktop x coordinate");
            System.out.println("-y - desktop y coordinate");
            System.out.println("-c - click count");
            return;
        }

        if(args[0].equals("-x") &&
           args[1].matches("[0-9]+") && args[1].length() < 5 &&
           args[2].equals("-y") &&
           args[3].matches("[0-9]+") && args[3].length() < 5 &&
           args[4].equals("-c") &&
           args[5].matches("[0-9]+") && args[5].length() < 5) {

            try {
                int x = Integer.parseInt(args[1]);
                int y = Integer.parseInt(args[3]);
                int c = Integer.parseInt(args[5]);

                Robot clicker = new Robot();
                clicker.mouseMove(x, y);

                for(int i = 0; i < c; i++) {
                    clicker.mousePress(InputEvent.BUTTON1_MASK);
                    clicker.mouseRelease(InputEvent.BUTTON1_MASK);
                }
            } catch (AWTException ex) {
                System.out.println("AWT exception thrown.");
                return;
            } catch(Exception x) {
                System.out.println("Exception thrown.");
                return;
            }
        } else {
            System.out.println("Incorrect argument format.");
            return;
        }
    }
}
