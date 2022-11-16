public interface Contract {

    void grab(String item);
    
    //KATIE
    String drop(String item);
    
    void examine(String item);
    
    //KATIE
    void use(String item);
    
    boolean walk(String direction);
    
    //KATIE
    boolean fly(int x, int y);

    Number shrink();
    
    //KATIE
    Number grow();

    void rest();
    
    //KATIE
    void undo();

    

    }


