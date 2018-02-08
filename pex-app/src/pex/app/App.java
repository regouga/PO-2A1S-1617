/** @version  */
package pex.app;

import static pt.tecnico.po.ui.Dialog.IO;

//FIXME import used core classes
import pex.ParserException;
import pex.app.main.MainMenu;
import pt.tecnico.po.ui.Menu;
import pex.operators.Program;
import pex.Interpreter;
import pex.Manager;

/**
 * This is a sample client for the expression evaluator.
 * It uses a text-based user interface.
 */
public class App {
  /**
   * @param args
   */
  public static void main(String[] args) {
    //FIXME create main core object
    
    Manager m = new Manager();

    String datafile = System.getProperty("import"); //$NON-NLS-1$
    if (datafile != null) {
      try {
        m.readPg(datafile, "import");
      } catch (ParserException e) {
        // no behavior described: just present the problem
        e.printStackTrace();
      }
    } 
    
    Menu menu = new MainMenu(m);
    menu.open();
    
    IO.close();
  }

}
