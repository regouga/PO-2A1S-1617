
package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

public class NotEquals extends BinaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param first
   * @param second
   */
  public NotEquals(Expression first, Expression second) {
    super(first, second);
  }

   public Value<?> accept(Visitor v) {
    return v.visitNE(this);
  }
}
