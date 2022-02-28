object GridPrinter {
    def convertGridToString(grid: Grid): String = {
    // map Grid cell to sting
    val stringGrid = grid.gridSeq
        .map(line => line.map(_.toString()))
    
    val oneSeqGrid = stringGrid.map(_.mkString)
    
    val finalString = oneSeqGrid.mkString("\n")
    finalString
    }
}



