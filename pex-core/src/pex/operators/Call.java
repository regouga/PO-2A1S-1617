/*  */
package pex.operators;

import pex.Visitor;
import pex.Expression;
import pex.Value;

/**
 * Class for describing the negation operator
 */
public class Call extends UnaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param argument
   */
  public Call(Expression argument) {
    super(argument);
  }

   public Value<?> accept(Visitor v) {
    return v.visitCALL(this);
  }

}
