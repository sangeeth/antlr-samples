grammar Expr;		
expr:  expr '+' expr     #Add
    |	expr '-' expr    #Subtract
    |	INT              #Int
    ;
INT     : [0-9]+ ;       