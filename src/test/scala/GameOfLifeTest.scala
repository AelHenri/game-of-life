class GameOfLifeTest extends org.scalatest.funsuite.AnyFunSuite {

  test("Test cell as alive") {
    val cell = new Cell(true)
    assert(cell.alive)
  }

  test("Test kills cell, makes it dead") {
    val cell = new Cell(true)
    assert(!cell.toggleState().alive)
  }

  test("Test making a dead cell alive") {
    val cell = new Cell(false)
    assert(cell.toggleState().alive)
  }

  test("Calling toggleState twice should keep the same state") {
    val cell = new Cell(true)
    assert(cell.toggleState().toggleState().alive)
  }

  test("Test 3x3 grid with one alive"){
    // val grid = Grid(3, 3, Seq(Seq(Cell(false),Cell(false),Cell(false)), Seq(Cell(false),Cell(false),Cell(false)), Seq(Cell(false),Cell(false),Cell(false))))
    val grid = Grid.fromLivingCellCoordinates(3, 3, Seq((0, 0)))
    // assert that cell 0, 0 is alive
    assert(grid.gridSeq(0)(0).alive)
    
  }

 test("Test printing 3x1 empty grid return 3x1 dashes"){
   val grid = Grid.fromLivingCellCoordinates(3, 1, Seq())
   val result = GridPrinter.convertGridToString(grid)
   assert(result=="---") 
  }

   test("Test printing 3x3 grid with alive cell in the middle"){
   val grid = Grid.fromLivingCellCoordinates(3, 3, Seq((1, 1)))
   val result = GridPrinter.convertGridToString(grid)
   assert(result=="---\n-*-\n---") 
  }

  test("Test isNeighbor returns true"){
    val grid = new Grid(3, 3, Seq(Seq(new Cell(false),new Cell(false),new Cell(false)), Seq(new Cell(false),new Cell(false),new Cell(false)), Seq(new Cell(false),new Cell(false),new Cell(false))))
    val actual = grid.isNeighbor(0, 0, 1, 1)
    val expected = true
    assert(actual == expected)
  }

  test("Test isNeighbor with negative values returns false"){
    val grid = new Grid(3, 3, Seq(Seq(new Cell(false),new Cell(false),new Cell(false)), Seq(new Cell(false),new Cell(false),new Cell(false)), Seq(new Cell(false),new Cell(false),new Cell(false))))
    val actual = grid.isNeighbor(-1, -1, 0, 0)
    val expected = false
    assert(actual == expected)
  }

  test("Test isNeighbor on current cell returns false"){
    val grid = new Grid(3, 3, Seq(Seq(new Cell(false),new Cell(false),new Cell(false)), Seq(new Cell(false),new Cell(false),new Cell(false)), Seq(new Cell(false),new Cell(false),new Cell(false))))
    val actual = grid.isNeighbor(1, 1, 1, 1)
    val expected = false
    assert(actual == expected)
  }

  test("Test isNeighbor with out of bound target cell returns false"){
    val grid = new Grid(3, 3, Seq(Seq(new Cell(false),new Cell(false),new Cell(false)), Seq(new Cell(false),new Cell(false),new Cell(false)), Seq(new Cell(false),new Cell(false),new Cell(false))))
    val actual = grid.isNeighbor(3, 3, 2, 2)
    val expected = false
    assert(actual == expected)
  }

  test("Test isNeighbor with out of bound current cell returns false"){
    val grid = new Grid(3, 3, Seq(Seq(new Cell(false),new Cell(false),new Cell(false)), Seq(new Cell(false),new Cell(false),new Cell(false)), Seq(new Cell(false),new Cell(false),new Cell(false))))
    val actual = grid.isNeighbor(2, 2, 3, 3)
    val expected = false
    assert(actual == expected)
  } // Currently fails, but not this method's responsibility? 

}