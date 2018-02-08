
package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

public class LessThan extends BinaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param first
   * @param second
   */
  public LessThan(Expression first, Expression second) {
    super(first, second);
  }

   public Value<?> accept(Visitor v) {
    return v.visitLT(this);
  }
}
