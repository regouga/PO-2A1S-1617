/*  */
package pex;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import pex.Interpreter;
import pex.operators.Program;
import java.io.IOException;
import pex.Manager;
import pex.Parser;
import java.io.FileNotFoundException;
import java.lang.ClassNotFoundException;
import pex.exceptions.InterpreterException;

import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.*;

import pex.ParserException;
import pex.exceptions.InterpreterException;
import pex.ToStringOperators;


/**
 * An expressions can be evaluated to produce a value.
 */
public class Manager {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;
  
  private String _fname;
  private Interpreter _interpreter = new Interpreter();
  
  
  
  public void newIp() {
        _interpreter = new Interpreter();
    }
  
  public void newPg(String programName) {
    newIp();
    _interpreter.addNewPg(programName);
  }
  
  public void openPg(String file) throws Exception {
    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
    Interpreter interpreter = (Interpreter) ois.readObject();
    
    if (interpreter != null) _interpreter = interpreter;
}
    
    
    public void readPg(String filename, String name) throws ParserException {
        Parser p = new Parser();
        Program program = p.parseProgramFile(filename);
        _interpreter.addPg(name, program);
    }
    
    
    public void writePg (String programName, String fileName) throws InterpreterException, FileNotFoundException, IOException {
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        Program _programFound = _interpreter.searchPg(programName);
        out.println(_programFound.toString());
        out.close();
    }
    
    public String getFileName() {
        return _fname;
    }
    
    public void savePg(String fName) throws IOException {
        _fname = fName;
        
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fName)));
        oos.writeObject(getIp());
        oos.close();
    }
    
    public Interpreter getIp() {
        return _interpreter;
    }
    
  
  //FIXME (possibly) add other methods: e.g. accept, toString, etc.

}
