/** @version  */
package pex.app.main;

//FIXME import used core classes

import pex.Manager;
import java.io.FileNotFoundException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pex.ParserException;
import pex.app.BadFileException;



/**
 * Read existing program.
 */
public class DoReadProgram extends Command<Manager> {
  /** Input field. */
  Input<String> _filename;

  /**
   * @param receiver
   */
  public DoReadProgram(Manager receiver) {
    super(Label.READ_PROGRAM, receiver);
    _filename = _form.addStringInput(Message.programFileName());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws BadFileException {
    _form.parse();
    _receiver.newIp();
    
    try {
        _receiver.readPg(_filename.value(), _filename.value());
    }
    
    catch (ParserException e) { 
        throw new BadFileException(_filename.value()); 
    }
    
  }
}
