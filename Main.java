// File: Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your main idea: ");
        String mainIdea = scanner.nextLine();

        MindMap map = new MindMap(mainIdea);

        while (true) {
            System.out.println("\n1. Add Sub-Idea");
            System.out.println("2. Display Mind Map");
            System.out.println("3. Export to DOT file");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter parent idea: ");
                    String parent = scanner.nextLine();
                    IdeaNode parentNode = map.findNode(map.getRoot(), parent);
                    if (parentNode != null) {
                        System.out.print("Enter sub-idea: ");
                        String child = scanner.nextLine();
                        parentNode.addSubIdea(new IdeaNode(child));
                        System.out.println("Added!");
                    } else {
                        System.out.println("Parent idea not found!");
                    }
                }
                case 2 -> {
                    System.out.println("\nMind Map:");
                    map.displayMap();
                }
                case 3 -> {
                    System.out.print("Enter filename (e.g., mindmap.dot): ");
                    String file = scanner.nextLine();
                    try {
                        map.exportToDotFile(file);
                        System.out.println("Exported successfully!");
                    } catch (Exception e) {
                        System.out.println("Error exporting file: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
