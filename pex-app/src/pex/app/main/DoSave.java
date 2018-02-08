/** @version  */
package pex.app.main;

import java.io.IOException;

//FIXME import used core classes
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pex.Manager;

import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<Manager> {
  /** Input field. */
  Input<String> _filename;
  
  /**
   * @param receiver
   */
  public DoSave(Manager receiver) {
    super(Label.SAVE, receiver);
    _filename = _form.addStringInput(Message.newSaveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
  
    if (_receiver.getFileName() == null) {
        _form.parse();
    }
    
    try {
    
        _receiver.savePg(_filename.value());
    
    }
    
    catch (IOException exception) { exception.printStackTrace(); }
  }
}
