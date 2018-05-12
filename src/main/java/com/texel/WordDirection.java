package com.texel;

/**
 * Created by jacob on 5/10/2018.
 */
public enum WordDirection {
    HORIZONTAL(0,1), VERTICAL(1,0), DIAGONAL_DESC(1,1);

    private final int rowDirection;
    private final int columnDirection;
    WordDirection(int rowDirection, int columnDirection){
        this.rowDirection = rowDirection;
        this.columnDirection = columnDirection;
    }
    public final int rowDirection(){ return rowDirection; }
    public final int columnDirection(){ return columnDirection; }
}
