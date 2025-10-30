// Question 21: Multiple Inheritance using Interfaces
// A class implements multiple interfaces

// Interface 1 - Printable
interface Printable {
    void print();
    
    default void showPrintInfo() {
        System.out.println("This object is printable");
    }
}

// Interface 2 - Showable
interface Showable {
    void show();
    
    default void showDisplayInfo() {
        System.out.println("This object is showable");
    }
}

// Interface 3 - Drawable
interface Drawable {
    void draw();
    
    default void showDrawInfo() {
        System.out.println("This object is drawable");
    }
}

// Class implementing multiple interfaces
class Document implements Printable, Showable, Drawable {
    String title;
    String content;
    
    Document(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
    @Override
    public void print() {
        System.out.println("\n[PRINTING DOCUMENT]");
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("Printing to default printer...");
    }
    
    @Override
    public void show() {
        System.out.println("\n[SHOWING DOCUMENT]");
        System.out.println("Displaying on screen:");
        System.out.println("═══════════════════════════════");
        System.out.println("   " + title.toUpperCase());
        System.out.println("═══════════════════════════════");
        System.out.println(content);
        System.out.println("═══════════════════════════════");
    }
    
    @Override
    public void draw() {
        System.out.println("\n[DRAWING DOCUMENT]");
        System.out.println("Rendering document layout...");
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│ " + title);
        System.out.println("├─────────────────────────────┤");
        System.out.println("│ " + content.substring(0, Math.min(25, content.length())) + "...");
        System.out.println("└─────────────────────────────┘");
    }
}

// Another class implementing multiple interfaces
class Image implements Showable, Drawable {
    String imageName;
    String format;
    
    Image(String imageName, String format) {
        this.imageName = imageName;
        this.format = format;
    }
    
    @Override
    public void show() {
        System.out.println("\n[SHOWING IMAGE]");
        System.out.println("Image Name: " + imageName);
        System.out.println("Format: " + format);
        System.out.println("Displaying image on screen...");
    }
    
    @Override
    public void draw() {
        System.out.println("\n[DRAWING IMAGE]");
        System.out.println("Rendering " + format + " image...");
        System.out.println("Image: " + imageName);
    }
}

public class Question21 {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  MULTIPLE INHERITANCE VIA INTERFACES");
        System.out.println("  (Class implements Multiple Interfaces)");
        System.out.println("========================================");
        
        // Create Document object
        Document doc = new Document("Java Programming Guide", 
            "This is a comprehensive guide to Java programming covering all OOP concepts.");
        
        System.out.println("\n--- Document Object ---");
        doc.print();
        doc.show();
        doc.draw();
        
        // Using interface references
        System.out.println("\n========================================");
        System.out.println("Using Interface References:");
        System.out.println("========================================");
        
        Printable p = doc;
        p.print();
        p.showPrintInfo();
        
        Showable s = doc;
        s.show();
        s.showDisplayInfo();
        
        Drawable d = doc;
        d.draw();
        d.showDrawInfo();
        
        // Create Image object
        System.out.println("\n========================================");
        System.out.println("--- Image Object ---");
        System.out.println("========================================");
        
        Image img = new Image("Sunset.jpg", "JPEG");
        img.show();
        img.draw();
        
        System.out.println("\n========================================");
        System.out.println("Demonstration Complete!");
        System.out.println("Document implements: Printable, Showable, Drawable");
        System.out.println("Image implements: Showable, Drawable");
        System.out.println("========================================");
    }
}
