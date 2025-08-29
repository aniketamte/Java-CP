package Interfaces.extendInterface;

public interface A {
      //Static inteface method should always have a body
      //Call via the interface name
      
      static void greeting(){
            System.out.println("Hey I am static method");
      }

      default void fun(){
            System.out.println(" I am in A");
      }    
}
