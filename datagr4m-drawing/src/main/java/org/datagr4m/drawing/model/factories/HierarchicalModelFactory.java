package org.datagr4m.drawing.model.factories;

import org.datagr4m.drawing.model.items.DefaultBoundedItem;
import org.datagr4m.drawing.model.items.IBoundedItem;
import org.datagr4m.drawing.model.items.hierarchical.IHierarchicalModel;
import org.datagr4m.drawing.model.items.hierarchical.graph.edges.tubes.HierarchicalEdgeModel;
import org.datagr4m.drawing.model.items.hierarchical.visitor.ModelEdgesVisitor;
import org.datagr4m.topology.Topology;

/**
 * A default factory 
 * @author martin
 *
 * @param <V>
 * @param <E>
 */
public class HierarchicalModelFactory<V,E> implements IHierarchicalModelFactory{
    @Override
    public IBoundedItem getLayoutModel(Object data) {
        return new DefaultBoundedItem(data.toString(), 30);
    }
    
    public  HierarchicalEdgeModel getTubeModel(IHierarchicalModel model, Topology<V,E> topology) {
        ModelEdgesVisitor edgeFinder = new ModelEdgesVisitor();
        edgeFinder.visit(model);
        HierarchicalEdgeModel tubeModel = new HierarchicalEdgeModel();
        tubeModel.build(topology, model); 
        model.setEdgeModel(tubeModel);
        return tubeModel;
    }
}
