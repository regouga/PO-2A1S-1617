/*  */
package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

/**
 * Class for describing binary operators.
 */
public class If extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /** First operand. */
  Expression _first;

  /** Second operand. */
  Expression _second;
  
  /** Third operand. */
  Expression _third;

  /**
   * @param first
   *          first operand
   * @param second
   *          second operand
   * @param third
   *          third operand
   */
  public If (Expression first, Expression second, Expression third) {
    _first = first;
    _second = second;
    _third = third;
  }

  /**
   * @return first operand
   */
  public Expression first() {
    return _first;
  }

  /**
   * @return second operand
   */
  public Expression second() {
    return _second;
  }
  
  /**
   * @return third operand
   */
  public Expression third() {
    return _third;
  }
  
public Value<?> accept(Visitor v) {
    return v.visitIF(this);
  }
}
