package pex;

import pex.Expression;
import pex.operators.*;
import pex.atomic.*;
import pex.Value;
import pex.Visitor;


public class ToStringOperators implements Visitor {

    String _operatorString = "";
    
    public String toString() {
        return _operatorString;
    }

    public Value<?> visitLT (LessThan c) {
        _operatorString += "(lt ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitLE (LessEqual c) {
        _operatorString += "(le ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitGE (GreaterEqual c) {
        _operatorString += "(ge ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitGT (GreaterThan c) {
        _operatorString += "(gt ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitEQ (Equals c) {
        _operatorString += "(eq ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitNE (NotEquals c) {
        _operatorString += "(ne ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitOR (Or c) {
        _operatorString += "(or ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitIF (If c) {
        _operatorString += "(if ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ' ';
        c.third().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitNEG (Neg c) {
        _operatorString += "(neg ";
        c.argument().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitADD (Add c) {
        _operatorString += "(add ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;

    }
    
    public Value<?> visitSUB (Sub c) {
        _operatorString += "(sub ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitMUL (Mul c) {
        _operatorString += "(mul ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitDIV (Div c) {
        _operatorString += "(div ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitMOD (Mod c) {
        _operatorString += "(mod ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitNOT (Not c) {
        _operatorString += "(not ";
        c.argument().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitAND (And c) {
        _operatorString += "(and ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitSET (Set c) {
        _operatorString += "(set ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitSEQ (Sequence c) {
        _operatorString += "(seq ";
        for (Expression e : c.getAll()) e.accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitCALL (Call c) {
        _operatorString += "(call ";
        c.argument().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitPRINT (Print c) {
        _operatorString += "(print ";
        for (Expression e : c.getAll()) e.accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitREADI (ReadI c) {
        _operatorString += "(readi)";
        return null;
    }
    
    public Value<?> visitREADS (ReadS c) {
        _operatorString += "(reads)";
        return null;
    }
    
    public Value<?> visitWHILE (While c) {
        _operatorString += "(while ";
        c.first().accept(this);
        _operatorString += ' ';
        c.second().accept(this);
        _operatorString += ")";
        return null;
    }
    
    public Value<?> visitIdentifier (Identifier c) {
        _operatorString += c.getName();
        return null;
    }
    
    public Value<?> visitIntegerliteral (IntegerLiteral c) {
        _operatorString += c.getValue();
        return null;
    }
    
    public Value<?> visitStringliteral (StringLiteral c) {
        _operatorString += "\"" + c.getValue() + "\"";
        return null;
    }
    
    public Value<?> visitProgram (Program c) {
        for (Expression e: c.getE()) {
            e.accept(this);
            _operatorString += "\n";
        }
        return null;
    }
    
    
}
