/** @version  */
package pex.app.main;

import java.io.FileNotFoundException;

//FIXME import used core classes
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pex.Manager;
import pex.exceptions.InterpreterException;
import java.io.FileNotFoundException;
import java.io.IOException;



/**
 * Write (save) program to file.
 */
public class DoWriteProgram extends Command<Manager> {
  /** Input field. */
  Input<String> _programName;
  /** Input field. */
  Input<String> _filename;

  /**
   * @param receiver
   */
  public DoWriteProgram(Manager receiver) {
    super(Label.WRITE_PROGRAM, receiver);
    _programName = _form.addStringInput(Message.requestProgramId());
    _filename = _form.addStringInput(Message.programFileName());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    
    try {
        _receiver.writePg(_programName.value(), _filename.value());
    }
    
    catch (InterpreterException exception) { _display.popup(Message.noSuchProgram(_programName.value())); }
    catch (FileNotFoundException exception) { }
    catch (IOException exception) { exception.printStackTrace(); }
    
  }

}
