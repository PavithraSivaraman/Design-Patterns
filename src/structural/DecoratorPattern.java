package structural;
//Component Interface
interface Window {
 void draw();
}

//Concrete Component
class SimpleWindow implements Window {
 public void draw() {
     System.out.println("Drawing window");
 }
}

//Decorator
abstract class WindowDecorator implements Window {
 protected Window decoratedWindow;

 public WindowDecorator(Window decoratedWindow) {
     this.decoratedWindow = decoratedWindow;
 }

 public void draw() {
     decoratedWindow.draw();
 }
}

//Concrete Decorators
class BorderDecorator extends WindowDecorator {
 public BorderDecorator(Window decoratedWindow) {
     super(decoratedWindow);
 }

 public void draw() {
     super.draw();
     drawBorder();
 }

 private void drawBorder() {
     System.out.println("Drawing border");
 }
}

class ScrollDecorator extends WindowDecorator {
 public ScrollDecorator(Window decoratedWindow) {
     super(decoratedWindow);
 }

 public void draw() {
     super.draw();
     drawScroll();
 }

 private void drawScroll() {
     System.out.println("Drawing scrollbars");
 }
}

//Main class
public class DecoratorPattern {
 public static void main(String[] args) {
     Window simpleWindow = new SimpleWindow();
     Window decoratedWindow = new BorderDecorator(new ScrollDecorator(simpleWindow));
     decoratedWindow.draw();
 }
}
