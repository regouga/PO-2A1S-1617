/*  */
package pex.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pex.Expression;
import pex.Visitor;
import pex.Value;

/**
 * Class representing a sequence of expressions.
 */
public class Print extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * Storage for expressions.
   */
  List<Expression> _expressions = null;

  /**
   * Default constructor (empty sequence).
   */


  /**
   * Constructor for single-expression sequences.
   * 
   * @param expression
   */


  /**
   * Constructor for appending expressions to sequences.
   * 
   * @param previous
   * @param expression
   */


  /**
   * @param expressions
   */
  public Print(List<Expression> expressions) {
    _expressions = new ArrayList<Expression>();
    _expressions.addAll(expressions);
  }

  /**
   * @param ix
   *          index to get
   * @return the expression at ix
   */
  public Expression get(int ix) {
    return _expressions.get(ix);
  }

  /**
   * @param expression
   */
  public void add(Expression expression) {
    _expressions.add(expression);
  }

  /**
   * @param index
   * @param expression
   */
  public void add(int index, Expression expression) {
    _expressions.add(index, expression);
  }

  /**
   * @param index
   * @param expression
   */
  public void set(int index, Expression expression) {
    _expressions.set(index, expression);
  }

  /**
   * @return a list with all the expressions
   */
  public List<Expression> getAll() {
    return Collections.unmodifiableList(_expressions);
  }

  /**
   * @return last expression
   */
  public Expression getLastExpression() {
    try {
      return _expressions.get(_expressions.size() - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  /**
   * @return size of sequence
   */
  public int size() {
    return _expressions.size();
  }
  
  
   public Value<?> accept(Visitor v) {
    return v.visitPRINT(this);
  }
  

  //FIXME (possibly) add other methods: e.g. accept, toString, etc.

}
