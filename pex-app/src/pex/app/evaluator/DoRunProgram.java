/** @version  */
package pex.app.evaluator;

//FIXME import used core classes
import pex.operators.Program;
import pex.Interpreter;
import pex.Visitor;
import pex.app.OperatorsEvaluator;

/**
 * Run program.
 */
public class DoRunProgram extends ProgramCommand {
  
  /**
   * @param interpreter 
   * @param receiver
   */
  public DoRunProgram(Interpreter interpreter, Program receiver) {
    super(Label.RUN_PROGRAM, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    Visitor v = new OperatorsEvaluator(_interpreter);
    _receiver.accept(v);
  }
}
