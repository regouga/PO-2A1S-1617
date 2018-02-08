package pex;
import pex.operators.*;
import pex.atomic.*;
import pex.Value;

public interface Visitor {

    Value<?> visitOR                (Or c);
    Value<?> visitIF                (If c);
    Value<?> visitNEG               (Neg c);
    Value<?> visitADD               (Add c);
    Value<?> visitSUB               (Sub c);
    Value<?> visitMUL               (Mul c);
    Value<?> visitDIV               (Div c);
    Value<?> visitMOD               (Mod c);
    Value<?> visitNOT               (Not c);
    Value<?> visitAND               (And c);
    Value<?> visitSET               (Set c);
    Value<?> visitCALL              (Call c);
    Value<?> visitPRINT             (Print c);
    Value<?> visitREADI             (ReadI c);
    Value<?> visitREADS             (ReadS c);
    Value<?> visitWHILE             (While c);
    Value<?> visitEQ                (Equals c);
    Value<?> visitSEQ               (Sequence c);
    Value<?> visitLT                (LessThan c);
    Value<?> visitNE                (NotEquals c);
    Value<?> visitLE                (LessEqual c);
    Value<?> visitGT                (GreaterThan c);
    Value<?> visitGE                (GreaterEqual c);
    
    Value<?> visitProgram           (Program c);
    Value<?> visitIdentifier        (Identifier c);
    Value<?> visitIntegerliteral    (IntegerLiteral c);
    Value<?> visitStringliteral     (StringLiteral c);
    
}
