/**
 * Class stores the row and column of any given chess piece
 * 
 * @author Simon Dewilde 
 * @version 2.0
 *
 */
public class ChessLocation
{
    private int row, col;

    /**
     * This constructor populates the row and column values with the user given position
     * 
     * @param row Stores the row of the piece
     * @param col Stores the column of the piece
     * 
     */
    public ChessLocation(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    /**
     * Method returns the current row
     * 
     * @param Nothing.
     * 
     * @returns Row as integer
     * 
     */
    public int getRow()
    {
        return row;
    }
    
    /**
     * Method returns the current column
     * 
     * @param Nothing.
     * 
     * @returns Column as integer
     * 
     */
    public int getCol()
    {
        return col;
    }
    
    /**
     * Method sets the location by taking the row and column as integers
     * 
     * @param row Takes the new row as an integer and replaces the old one
     * @param col Takes the new column as an integer and replaces the old one
     * 
     * @return Nothing.
     * 
     */
    public void setLocation(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}
