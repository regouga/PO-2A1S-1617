/** @version  */
package pex.app.evaluator;

//FIXME import used core classes
import pex.Interpreter;
import pex.operators.Program;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

/**
 * Menu for program manipulation.
 */
public class EvaluatorMenu extends Menu {

  /**
   * @param interpreter 
   * @param receiver
   */
  public EvaluatorMenu(Interpreter interpreter, Program receiver) {
    super(Label.TITLE,
        new Command<?>[] { //
            new DoShowProgram(interpreter, receiver), //
            new DoRunProgram(interpreter, receiver), //
            new DoAddExpression(interpreter, receiver), //
            new DoReplaceExpression(interpreter, receiver), //
            new DoShowAllIdentifiers(interpreter, receiver), //
            new DoShowUninitializedIdentifiers(interpreter, receiver), //
        });
  }

}
