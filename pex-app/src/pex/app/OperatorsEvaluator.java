package pex.app;

import pex.Expression;
import pex.operators.*;
import pex.atomic.*;
import pex.Value;
import pex.Visitor;
import pex.Interpreter;
import java.util.Map;
import java.util.HashMap;
import pt.tecnico.po.ui.*;
import java.util.List;
import pex.exceptions.InterpreterException;
import pex.ToStringOperators;


public class OperatorsEvaluator implements Visitor {

    private Interpreter _interpreter;

    public OperatorsEvaluator (Interpreter interpreter) {
        _interpreter = interpreter;
    }

    public Value<?> visitLT (LessThan c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        IntegerLiteral b = (IntegerLiteral) c.second().accept(this);
        if (a.getValue() < b.getValue()) return new IntegerLiteral(1);
        return new IntegerLiteral(0);
    }
    
    public Value<?> visitLE (LessEqual c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        IntegerLiteral b = (IntegerLiteral) c.second().accept(this);
        if (a.getValue() <= b.getValue()) return new IntegerLiteral(1);
        return new IntegerLiteral(0);
    }
    
    public Value<?> visitGE (GreaterEqual c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        IntegerLiteral b = (IntegerLiteral) c.second().accept(this);
        if (a.getValue() >= b.getValue()) return new IntegerLiteral(1);
        return new IntegerLiteral(0);
    }
    
    public Value<?> visitGT (GreaterThan c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        IntegerLiteral b = (IntegerLiteral) c.second().accept(this);
        if (a.getValue() > b.getValue()) return new IntegerLiteral(1);
        return new IntegerLiteral(0);
    }
    
    public Value<?> visitEQ (Equals c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        IntegerLiteral b = (IntegerLiteral) c.second().accept(this);
        if (a.getValue() == b.getValue()) return new IntegerLiteral(1);
        return new IntegerLiteral(0);
    }
    
    public Value<?> visitNE (NotEquals c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        IntegerLiteral b = (IntegerLiteral) c.second().accept(this);
        if (a.getValue() != b.getValue()) return new IntegerLiteral(1);
        return new IntegerLiteral(0);
    }
    
    public Value<?> visitOR (Or c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        IntegerLiteral b = (IntegerLiteral) c.second().accept(this);
        if (a.getValue() != 0)
            return new IntegerLiteral(1);
        if (b.getValue() != 0)
            return new IntegerLiteral(1);
        return new IntegerLiteral(0);
    }
    
    public Value<?> visitIF (If c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        Value<?> v;
        if (a.getValue() != 0) {
            v = c.second().accept(this);
        }
        else  {
            v = c.third().accept(this);
        }
        return v;
        
    }
    
    public Value<?> visitNEG (Neg c) {
        IntegerLiteral a = (IntegerLiteral) c.argument().accept(this);
        IntegerLiteral b = new IntegerLiteral(-1);
        IntegerLiteral ab = new IntegerLiteral(a.getValue() * b.getValue());
        return ab;
    }
    
    public Value<?> visitADD (Add c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        IntegerLiteral b = (IntegerLiteral) c.second().accept(this);
        IntegerLiteral ab = new IntegerLiteral(a.getValue() + b.getValue());
        return ab;
    }
    
    public Value<?> visitSUB (Sub c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        IntegerLiteral b = (IntegerLiteral) c.second().accept(this);
        IntegerLiteral ab = new IntegerLiteral(a.getValue() - b.getValue());
        return ab;
    }
    
    public Value<?> visitMUL (Mul c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        IntegerLiteral b = (IntegerLiteral) c.second().accept(this);
        IntegerLiteral ab = new IntegerLiteral(a.getValue() * b.getValue());
        return ab;
    }
    
    public Value<?> visitDIV (Div c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        IntegerLiteral b = (IntegerLiteral) c.second().accept(this);
        IntegerLiteral ab = new IntegerLiteral(a.getValue() / b.getValue());
        return ab;
    }
    
    public Value<?> visitMOD (Mod c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        IntegerLiteral b = (IntegerLiteral) c.second().accept(this);
        IntegerLiteral ab = new IntegerLiteral(a.getValue() % b.getValue());
        return ab;
    }
    
    public Value<?> visitNOT (Not c) {
         IntegerLiteral a = (IntegerLiteral) c.argument().accept(this);
         if (a.getValue() != 0) return new IntegerLiteral(0);
         return new IntegerLiteral(1);
    }
    
    public Value<?> visitAND (And c) {
        IntegerLiteral a = (IntegerLiteral) c.first().accept(this);
        IntegerLiteral b = new IntegerLiteral(0);
        if (a.getValue() != 0)
            b = (IntegerLiteral) c.second().accept(this);
            if (b.getValue() != 0)
                return new IntegerLiteral(1);
        return new IntegerLiteral(0);
    }
    
    public Value<?> visitSET (Set c) {
        Identifier i = (Identifier) c.first();
        Value<?> v = c.second().accept(this);
        _interpreter.addIdentifier(i.getName(), v);
        return v;
    }
    
    public Value<?> visitSEQ (Sequence c) {
        Value<?> v = (Value<?>) new IntegerLiteral(0);
        for (Expression e : c.getAll()) 
            v = e.accept(this);
        return v;
    }
    
    public Value<?> visitCALL  (Call c) {
        StringLiteral programName;
        
        try {
        
            programName = (StringLiteral) c.argument().accept(this);
            Program p = new Program();
            if (_interpreter.searchPg(programName.getValue()) != null) {
                p = _interpreter.searchPg(programName.getValue());
                p.accept(this);
                return p.getLastExpression().accept(this);
            }
            return new IntegerLiteral(0);
            
        }
        
        catch (InterpreterException e) { return new IntegerLiteral(0); }
        
    }
    
    public Value<?> visitPRINT (Print c) {
        Value<?> result = new IntegerLiteral(0);
        String string = "";
        Display d = new Display();
        
        for (Expression e : c.getAll()){
            result = e.accept(this);
            string += result.getValue();
        }
        d.add(string);
        d.display();
        return result;
    }
    
    public Value<?> visitREADI (ReadI c) {
        Form f = new Form();
        Input<Integer> input = f.addIntegerInput(null);
        f.parse();
        int i = input.value();
        return new IntegerLiteral(i);
    }
    
    public Value<?> visitREADS (ReadS c) {
        Form f = new Form();
        Input<String> input = f.addStringInput(null);
        f.parse();
        String i = input.value();
        return new StringLiteral(i);
    }
    
    public Value<?> visitWHILE (While c) {
        
        Value<?> a = c.first().accept(this);
         while (((IntegerLiteral) a).getValue() != 0) {
            c.second().accept(this);
            a = c.first().accept(this);
        }
        return new IntegerLiteral(0);
    }
    
    public Value<?> visitIdentifier (Identifier c) {
        Map<String, Value<?>> _identifierMap = _interpreter.returnMap();
        String name = c.getName();
        if (_identifierMap.containsKey(name))
            return _identifierMap.get(name);
        else 
            return new IntegerLiteral(0);
    }
    
    public Value<?> visitIntegerliteral (IntegerLiteral c) {
        return c;
    }
    
    public Value<?> visitStringliteral (StringLiteral c) {
        return c;
    }
    
    public Value<?> visitProgram (Program c) {
        Value<?> v = new IntegerLiteral(0);
        for (Expression e: c.getE()) {
            v = e.accept(this);
        }
        return v;
    }
    
}
