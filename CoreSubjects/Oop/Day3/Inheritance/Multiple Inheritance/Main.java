// Interface 1
interface Camera {
      void takePhoto();
}

// Interface 2
interface Phone {
      void makeCall();
}

// Class implementing both interfaces
class SmartPhone implements Camera, Phone {
      public void takePhoto() {
            System.out.println("Taking a photo...");
      }

      public void makeCall() {
            System.out.println("Making a call...");
      }
}

// Main class
public class Main {
      public static void main(String[] args) {
            SmartPhone sp = new SmartPhone();
            sp.takePhoto(); // from Camera
            sp.makeCall(); // from Phone
      }
}
