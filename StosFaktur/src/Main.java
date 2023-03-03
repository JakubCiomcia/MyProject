import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        InvoiceStack invoiceStack = new InvoiceStack();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide new invoice by entering \"CEO: ADD INVOICE(amount)\" " +
                "or processing invoice by entering ACCOUNTANT: \"ACCOUNTANT: PROCESS INVOICE\", if you want end " +
                "enter \"EXIT\"");
        while (scanner.hasNext()) {

            String command = scanner.nextLine();
            if ("EXIT".equals(command)) {
                break;
            }

            System.out.println("Inside Loop");
            invoiceStack.processInput(command);
        }
        System.out.println("After Loop");
    }
}