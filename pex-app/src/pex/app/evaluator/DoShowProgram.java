/** @version  */
package pex.app.evaluator;

//FIXME import core classes
import pex.operators.Program;
import pex.Expression;
import pex.Interpreter;
import pex.Manager;

/**
 * Show program (present code).
 */
public class DoShowProgram extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowProgram(Interpreter interpreter, Program receiver) {
    super(Label.SHOW_PROGRAM, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    for (Expression e : _receiver.getE()) _display.addLine(e.toString());
    _display.display();
    
  }

}
