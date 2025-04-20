// File: IdeaNode.java
import java.util.ArrayList;
import java.util.List;

public class IdeaNode {
    String idea;
    List<IdeaNode> children;

    public IdeaNode(String idea) {
        this.idea = idea;
        this.children = new ArrayList<>();
    }

    public void addSubIdea(IdeaNode subIdea) {
        children.add(subIdea);
    }

    public List<IdeaNode> getChildren() {
        return children;
    }

    public String getIdea() {
        return idea;
    }
}
