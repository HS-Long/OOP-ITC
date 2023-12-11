public class SequenceDownUp {

        public void printSequence(int inputNumber) {
            if(inputNumber <= 0) {
                System.out.println("Number must be positive");
                return;
            }

            for(int i=1; i<=inputNumber; i++) {
                System.out.printf("%02d ", i);
            }

            for(int i=inputNumber-1; i>=1; i--) {
                System.out.printf("%02d ", i);
            }

            System.out.println();
        }
    }


