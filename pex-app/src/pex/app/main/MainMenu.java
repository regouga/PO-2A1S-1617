/** @version  */
package pex.app.main;

//FIXME import used core classes
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;
import pex.Manager;

/**
 * Menu builder.
 */
public class MainMenu extends Menu {

  /**
   * @param receiver
   */
  public MainMenu(Manager receiver) {
    super(Label.TITLE,
        new Command<?>[] { //
            new DoNew(receiver), //
            new DoOpen(receiver), //
            new DoSave(receiver), //
            new DoNewProgram(receiver), //
            new DoReadProgram(receiver), //
            new DoWriteProgram(receiver), //
            new DoManageProgram(receiver), //
        });
  }

}
