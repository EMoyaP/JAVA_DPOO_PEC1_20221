public class PAC1Task2 {


        public static void main(String[] args){

            int numEven = 0, numOdd = 0, num = 0;

            for(int i = 0; i<args.length; i++){
                num = Integer.parseInt(args[i]);

                if(num%2 == 0){
                    numEven++;
                }else{
                    numOdd++;
                }
            }

            if(numEven>numOdd){
                System.out.println("Even");
            }else if(numOdd>numEven){
                System.out.println("Odd");
            }else{
                System.out.println("Draw");
            }
        }

}
