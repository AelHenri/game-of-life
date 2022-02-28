case class Game()
/*
object Game {
    def nextStep(currentGrid: Grid) : Grid = {

        val deadGridSeq = Seq.fill(y_max)(Seq.fill(x_max)(new Cell(false)))
        val gridSeq = deadGridSeq
            .zipWithIndex
            .map { case (line, y_index) => line
                .zipWithIndex
                .map{ case (cell, x_index) => if (livingCellCoordinates.contains((x_index, y_index))) cell.toggleState() else cell}
            }   
        
        new Grid(x_max, y_max, gridSeq)
    }
}
*/