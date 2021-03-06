package org.datagr4m.drawing.layout.geometrical;

import java.util.List;

import org.datagr4m.drawing.layout.ILayoutTable;
import org.datagr4m.drawing.layout.ItemPositionMap;
import org.datagr4m.drawing.model.items.IBoundedItem;
import org.jzy3d.maths.Coord2d;


public class CircleLayoutTable extends CircleLayout implements ILayoutTable{
    public CircleLayoutTable(List<IBoundedItem> items, Coord2d center, boolean autoRadius, float radius) {
        super(items, center, autoRadius, radius);
        positions = new ItemPositionMap();
    }

    @Override
    public void fixPosition(IBoundedItem item, Coord2d position){
        positions.put(item, position); 
    }
    
    @Override
    public Coord2d getPosition(IBoundedItem item) {
        return positions.get(item);
    }
    
    @Override
    public ItemPositionMap getPositions() {
        return positions;
    }

    protected ItemPositionMap positions;
    private static final long serialVersionUID = -960359548372755554L;
}
