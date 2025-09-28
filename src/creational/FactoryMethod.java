package creational;

//Product Interface
interface Document {
 void create();
}

//Concrete Products
class PDFDocument implements Document {
 @Override
 public void create() {
     System.out.println("Creating a PDF document");
 }
}

class WordDocument implements Document {
 @Override
 public void create() {
     System.out.println("Creating a Word document");
 }
}

//Creator
class DocumentFactory {
 public static Document createDocument(String type) {
     if (type.equalsIgnoreCase("PDF")) {
         return new PDFDocument();
     } else if (type.equalsIgnoreCase("Word")) {
         return new WordDocument();
     }
     throw new IllegalArgumentException("Unknown document type");
 }
}

//Main class
public class FactoryMethod {
 public static void main(String[] args) {
     Document pdf = DocumentFactory.createDocument("PDF");
     pdf.create();

     Document word = DocumentFactory.createDocument("Word");
     word.create();
 }
}
