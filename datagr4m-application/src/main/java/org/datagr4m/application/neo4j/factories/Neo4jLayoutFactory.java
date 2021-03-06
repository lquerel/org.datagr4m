package org.datagr4m.application.neo4j.factories;

import org.datagr4m.application.neo4j.layout.Neo4jItemSlotLayout;
import org.datagr4m.drawing.layout.factories.HierarchicalLayoutFactory;
import org.datagr4m.drawing.layout.hierarchical.IHierarchicalLayout;
import org.datagr4m.drawing.layout.hierarchical.graph.edges.DefaultItemSlotLayout;
import org.datagr4m.drawing.layout.hierarchical.graph.edges.IHierarchicalEdgeLayout;
import org.datagr4m.drawing.layout.hierarchical.graph.edges.SlotedTubeLayout;
import org.datagr4m.drawing.model.items.hierarchical.IHierarchicalModel;

import com.datagr4m.neo4j.topology.graph.Neo4jGraphModel;

public class Neo4jLayoutFactory extends HierarchicalLayoutFactory {
    Neo4jGraphModel graphModel;

    public Neo4jLayoutFactory(Neo4jGraphModel model) {
        this.graphModel = model;
    }

    @Override
    public IHierarchicalLayout getLayout(IHierarchicalModel model) {
        IHierarchicalLayout layout = getRootLayout(model, model.getEdgeModel());
        return layout;
    }

    /** Override creation of SlotTargets to register neo4j relationship summary. */
    @Override
    public IHierarchicalEdgeLayout getHierarchicalEdgeLayout(IHierarchicalModel model) {
        SlotedTubeLayout stl = new SlotedTubeLayout(pathFactory);
        stl.setItemSlotLayout(newItemSlotLayout());
        return stl;
    }

    public DefaultItemSlotLayout newItemSlotLayout() {
        return new Neo4jItemSlotLayout(pathFactory, graphModel);
    }
}
