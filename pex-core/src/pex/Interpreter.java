/*  */
package pex;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import pex.operators.Program;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import pex.exceptions.InterpreterException;


/**
 * An expressions can be evaluated to produce a value.
 */
 
 
 
public class Interpreter implements Serializable {

    private static final long serialVersionUID = 201608281352L;
    
    private Map<String, Program> _programs = new HashMap<String, Program>();
    private Map<String, Value<?>> _identifiers = new HashMap<String, Value<?>>();
  
    public void addPg(String programName, Program program) {
        _programs.put(programName, program);
    }
  
    public void addNewPg(String programName) {
        _programs.put(programName, new Program(programName));
    }

    public Program searchPg(String programName) throws InterpreterException {
        if (_programs.get(programName) != null) {
            return _programs.get(programName);
        }
        else {
            throw new InterpreterException("O programa " + _programs.get(programName) + " não existe.");
        }
    }
    
    public Map<String, Value<?>> returnMap() {
        return _identifiers;
    }
    
    public void addIdentifier(String name, Value<?> value) {
        _identifiers.put(name, value);
    }
    
}
