/*  */
package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

/**
 * Class for describing the negation operator
 */
public class Not extends UnaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param argument
   */
   
  public Not(Expression argument) {
    super(argument);
  }

   public Value<?> accept(Visitor v) {
    return v.visitNOT(this);
  }

}
