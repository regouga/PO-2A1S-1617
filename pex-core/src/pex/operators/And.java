
package pex.operators;

import pex.Visitor;
import pex.Expression;
import pex.Value;

public class And extends BinaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param first
   * @param second
   */
  public And(Expression first, Expression second) {
    super(first, second);
  }
  
   public Value<?> accept(Visitor v) {
    return v.visitAND(this);
  }
}
