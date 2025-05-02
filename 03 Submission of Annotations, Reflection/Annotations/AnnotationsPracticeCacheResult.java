import java.lang.annotation.*;
import java.util.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}
class ExpensiveService {
   private Map<Integer, Integer> cache = new HashMap<>();
   @CacheResult
   public int computeSquare(int x) {
       if (cache.containsKey(x)) {
           System.out.println("Returning cached result for " + x);
           return cache.get(x);
       }
       int result = x * x;
       System.out.println("Computing result for " + x);
       cache.put(x, result);
       return result;
   }
}
public class AnnotationsPracticeCacheResult {
   public static void main(String[] args) throws Exception {
       ExpensiveService service = new ExpensiveService();
       System.out.println(service.computeSquare(5));
       System.out.println(service.computeSquare(5));
       System.out.println(service.computeSquare(10));
       System.out.println(service.computeSquare(10));
   }
}
