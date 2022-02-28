class Cell(val alive: Boolean){
    def toggleState(): Cell = {
        new Cell(!alive)
    }
    
    override def toString(): String = {
        if (alive)  "*" else "-"
    }
}