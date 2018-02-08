package pex;

import pex.Expression;
import pex.operators.*;
import pex.atomic.*;
import pex.Value;
import pex.Visitor;
import pex.atomic.Identifier;
import java.util.SortedSet;
import java.util.TreeSet;


public class IdentifierFinder implements Visitor {

    private SortedSet<String> _inicializedI = new TreeSet<String>();
    private SortedSet<String> _uniniticializedI = new TreeSet<String>();
    private SortedSet<String> _allI = new TreeSet<String>();
    
    private int _uniniticializedFlag;
    private int _toStringFlag;
    
    public IdentifierFinder (int toStringFlag) {
        _toStringFlag = toStringFlag;
    }
    
    public String toString() {
        
        String string = "";
    
        if (_toStringFlag == 1) {
            for (String s: _uniniticializedI)
                if (!_inicializedI.contains(s)) string += s + "\n";
        }
        
        if (_toStringFlag == 2) {
            for (String s: _allI) string += s + "\n";
        }
        
        return string;
    }


    public Value<?> visitLT (LessThan c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitLE (LessEqual c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitGE (GreaterEqual c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitGT (GreaterThan c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitEQ (Equals c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitNE (NotEquals c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitOR (Or c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitIF (If c) {
        c.first().accept(this);
        c.second().accept(this);
        c.third().accept(this);
        return null;
    }
    
    public Value<?> visitNEG (Neg c) {
        c.argument().accept(this);
        return null;
    }
    
    public Value<?> visitADD (Add c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;

    }
    
    public Value<?> visitSUB (Sub c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitMUL (Mul c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitDIV (Div c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitMOD (Mod c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitNOT (Not c) {
        c.argument().accept(this);
        return null;
    }
    
    public Value<?> visitAND (And c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitSET (Set c) {
        _uniniticializedFlag = 1;
        _uniniticializedI.add(c.first().toString());
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitSEQ (Sequence c) {
        for (Expression e : c.getAll()) e.accept(this);
        return null;
    }
    
    public Value<?> visitCALL (Call c) {
        c.argument().accept(this);
        return null;
    }
    
    public Value<?> visitPRINT (Print c) {
        for (Expression e : c.getAll()) e.accept(this);
        return null;
    }
    
    public Value<?> visitREADI (ReadI c) {
        return null;
    }
    
    public Value<?> visitREADS (ReadS c) {
        return null;
    }
    
    public Value<?> visitWHILE (While c) {
        c.first().accept(this);
        c.second().accept(this);
        return null;
    }
    
    public Value<?> visitIdentifier (Identifier c) {
        
        String name = c.getName();
        
        _allI.add(name);
        
        if (_uniniticializedFlag == 0) {
           _uniniticializedI.add(name);
        }
        
        else {
            _inicializedI.add(name);
            _uniniticializedI.remove(name);
            _uniniticializedFlag = 0;
        }
        
        return null;
    }
    
    
    public Value<?> visitIntegerliteral (IntegerLiteral c) {
        return null;
    }
    
    public Value<?> visitStringliteral (StringLiteral c) {
        return null;
    }
    
    public Value<?> visitProgram (Program c) {
        for (Expression e : c.getAll()) e.accept(this);
        return null;
    }
    
    
}
