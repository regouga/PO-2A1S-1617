/*  */
package pex.operators;

import java.util.Collections;
import java.util.Collection;
import pex.Expression;
import java.util.List;
import java.util.ArrayList;
import pex.Visitor;
import pex.Value;
import pex.IdentifierFinder;

/**
 * Class for describing programs.
 */
public class Program extends Sequence {

    private String _name;
    
    public Program (String name) {
        _name = name;
    }

    public Program() {}
    
    public List<Expression> getE() {
        return Collections.unmodifiableList(_expressions);
    }
    
    public Value<?> accept(Visitor v) {
        return v.visitProgram(this);
    }
    
    public String returnIdentifiers(int i) {
        Visitor v = new IdentifierFinder(i);
        accept(v);
        return v.toString();
    }
}
