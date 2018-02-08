/** @version  */
package pex.app.evaluator;

import pex.Interpreter;
import pex.app.BadExpressionException;
import pex.app.BadPositionException;
import pex.operators.Program;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pex.ParserException;
import pex.Parser;
import pex.Expression;
import java.lang.IndexOutOfBoundsException;

/**
 * Add expression.
 */
public class DoAddExpression extends ProgramCommand {
  /** Input field. */
  Input<Integer> _position;

  /** Input field. */
  Input<String> _description;

  /**
   * @param interpreter
   * @param receiver
   */
  public DoAddExpression(Interpreter interpreter, Program receiver) {
    super(Label.ADD_EXPRESSION, interpreter, receiver);
    _position = _form.addIntegerInput(Message.requestPosition());
    _description = _form.addStringInput(Message.requestExpression());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException, BadExpressionException {
  
    try {
    
    _form.parse();
    Parser p = new Parser();
    Expression e = p.parse(_description.value());
    _receiver.add(_position.value(), e);
    
    }
    
    catch (IndexOutOfBoundsException e) { throw new BadPositionException(_position.value()); }
    catch (ParserException e) { throw new BadExpressionException(_description.value()); }
    
  }
}
