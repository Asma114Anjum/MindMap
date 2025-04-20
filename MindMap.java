// File: MindMap.java
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MindMap {
    private IdeaNode root;

    public MindMap(String rootIdea) {
        this.root = new IdeaNode(rootIdea);
    }

    public IdeaNode getRoot() {
        return root;
    }

    public void displayMap() {
        displayMapRecursive(root, "", true);
    }

    private void displayMapRecursive(IdeaNode node, String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.getIdea());
        for (int i = 0; i < node.getChildren().size(); i++) {
            displayMapRecursive(node.getChildren().get(i), prefix + (isTail ? "    " : "│   "), i == node.getChildren().size() - 1);
        }
    }

    public void exportToDotFile(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("digraph MindMap {\n");
            writeDot(root, writer);
            writer.write("}\n");
        }
    }

    private void writeDot(IdeaNode node, FileWriter writer) throws IOException {
        for (IdeaNode child : node.getChildren()) {
            writer.write("\"" + node.getIdea() + "\" -> \"" + child.getIdea() + "\";\n");
            writeDot(child, writer);
        }
    }

    public IdeaNode findNode(IdeaNode current, String idea) {
        if (current.getIdea().equalsIgnoreCase(idea)) return current;
        for (IdeaNode child : current.getChildren()) {
            IdeaNode found = findNode(child, idea);
            if (found != null) return found;
        }
        return null;
    }
}
