
package pex.operators;

import pex.Expression;
import pex.Visitor;
import pex.Value;

public class ReadS extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

   
   public Value<?> accept(Visitor v) {
    return v.visitREADS(this);
  }

  //FIXME (possibly) add other methods: e.g. accept, toString, etc.
}
