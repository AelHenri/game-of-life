import scala.math.{min, max}

class Grid(val x_max: Int, val y_max: Int, val gridSeq: Seq[Seq[Cell]]) {
    def getAliveNeighborsNb(x: Int, y: Int) : Int = { 
        gridSeq.zipWithIndex.flatMap {
            case (line, y_index) => line
                .zipWithIndex
                .map {
                    case (cell, x_index) => if (isNeighbor(x_index, y_index, x, y)) 1 else 0
                }
        }.sum
    }

    def isNeighbor(x_index: Int, y_index: Int, x: Int, y: Int): Boolean = {
        val xMinCell = max(0, x-1)
        val yMinCell = max(0, y-1)
        val xMaxCell = min(x_max-1, x+1)      
        val yMaxCell = min(y_max-1, y+1)
        
        x_index <= xMaxCell && x_index >= xMinCell && y_index <= yMaxCell && y_index >= yMinCell && !(x_index == x && y_index == y)
    }
}

object Grid {
    def fromLivingCellCoordinates(x_max: Int, y_max: Int, livingCellCoordinates: Seq[(Int, Int)]) : Grid = {
        // Seq.fill(3)("foo")               # List(foo, foo, foo)

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


/*
val myList = List("a", "b", "c")

myList.zipWithIndex.map { case (element, index) => 
   println(element, index) 
   s"${element}(${index})"
}
*/