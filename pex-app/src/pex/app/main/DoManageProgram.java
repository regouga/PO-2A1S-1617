/** @version  */
package pex.app.main;

//FIXME import used core classes

import pex.Manager;
import pex.operators.Program;
import pex.Interpreter;
import pex.app.evaluator.EvaluatorMenu;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Menu;
import pex.exceptions.InterpreterException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ClassNotFoundException;

/**
 * Open menu for managing programs.
 */
public class DoManageProgram extends Command<Manager> {
  /** Input field. */
  Input<String> _program;

  /**
   * @param receiver
   */
  public DoManageProgram(Manager receiver) {
    super(Label.MANAGE_PROGRAM, receiver);
    _program = _form.addStringInput(Message.requestProgramId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    try {
        Interpreter interpreter = _receiver.getIp();
        Program programFound = interpreter.searchPg(_program.value());
        EvaluatorMenu evMenu = new EvaluatorMenu(interpreter, programFound);
        evMenu.open();
        
    }
    
    catch (Exception exception) { _display.popup(Message.noSuchProgram(_program.value())); }
    
  }

}
