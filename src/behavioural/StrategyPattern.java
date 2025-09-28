package behavioural;
//Strategy Interface
interface RouteStrategy {
 void buildRoute(String start, String end);
}

//Concrete Strategies
class FastestRouteStrategy implements RouteStrategy {
 @Override
 public void buildRoute(String start, String end) {
     System.out.println("Calculating fastest route from " + start + " to " + end);
 }
}

class ShortestRouteStrategy implements RouteStrategy {
 @Override
 public void buildRoute(String start, String end) {
     System.out.println("Calculating shortest route from " + start + " to " + end);
 }
}

//Context
class Navigator {
 private RouteStrategy strategy;

 public Navigator(RouteStrategy strategy) {
     this.strategy = strategy;
 }

 public void setStrategy(RouteStrategy strategy) {
     this.strategy = strategy;
 }

 public void buildRoute(String start, String end) {
     strategy.buildRoute(start, end);
 }
}

//Main class
public class StrategyPattern {
 public static void main(String[] args) {
     Navigator navigator = new Navigator(new FastestRouteStrategy());
     navigator.buildRoute("A", "B");

     navigator.setStrategy(new ShortestRouteStrategy());
     navigator.buildRoute("A", "B");
 }
}

