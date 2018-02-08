/** @version  */
package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pex.Manager;

import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import java.lang.ClassNotFoundException;

/**
 * Open existing interpreter.
 */
public class DoOpen extends Command<Manager> {

    Input<String> file;

  /**
   * @param receiver
   */
   
  public DoOpen(Manager receiver) {
    super(Label.OPEN, receiver);
    file = _form.addStringInput(Message.openFile());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    
    try {
        _receiver.openPg(file.value());
    }
    
    catch (FileNotFoundException e) { _display.popup(Message.fileNotFound()); }
    catch (Exception e) {}
    
    

    }
}
