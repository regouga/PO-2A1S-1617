/*  */
package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

/**
 * Class for describing the sum ('+') operator
 */
public class While extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param first
   * @param second
   */
   
    /** First operand. */
  Expression _first;

  /** Second operand. */
  Expression _second;
  
  
  public While(Expression first, Expression second) {
    _first = first;
    _second = second;
  }
  
   public Expression first() {
    return _first;
  }

  /**
   * @return second operand
   */
  public Expression second() {
    return _second;
  }
  
  
   public Value<?> accept(Visitor v) {
    return v.visitWHILE(this);
  }
}
