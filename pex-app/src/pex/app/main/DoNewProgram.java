/** @version  */
package pex.app.main;

//FIXME import used core classes
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pex.Manager;
import pex.operators.Program;


/**
 * Create new program.
 */
public class DoNewProgram extends Command<Manager> {
  /** Input field. */
  Input<String> _programName;

  /**
   * @param receiver
   */
  public DoNewProgram(Manager receiver) {
    super(Label.NEW_PROGRAM, receiver);
    _programName = _form.addStringInput(Message.requestProgramId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    _receiver.newPg(_programName.value());
  }

}
