/*  */
package pex;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import pex.Visitor;
import pex.Value;

/**
 * An expressions can be evaluated to produce a value.
 */
public abstract class Expression implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;
  
  public abstract Value<?> accept(Visitor v);
  
  @Override
  public String toString() {
    Visitor stringer = new ToStringOperators();
    accept(stringer);
    return stringer.toString();
  }
}
