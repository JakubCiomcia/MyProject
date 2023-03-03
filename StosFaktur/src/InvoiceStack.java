import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;

public class InvoiceStack {

    private Integer counter = 1;
    private final Deque<Invoice> invoiceStack = new ArrayDeque<>();

    void processInput(String command) {
        if (command.contains("CEO: ADD INVOICE")) {
            processCEOInput(command);
        } else if ("ACCOUNTANT: PROCESS INVOICE".equals(command)) {
            processAccountantInput(command);

        } else {
            System.out.println("O co Ci chodzi?");
        }

    }

    private void processCEOInput(String command) {

        BigDecimal amount = new BigDecimal(command.substring(command.indexOf("(") + 1, command.indexOf(")")));
        Integer year = LocalDate.now().getYear();
        String id = counter + "/" + year;
        counter++;

        Invoice invoice = new Invoice(id, amount);
        invoiceStack.push(invoice);

        System.out.printf("%n%s%n", command);
        System.out.printf("CEO added invoice: ID: %s, amount: %s%n", id, amount);
        System.out.printf("Current invoices amount: %s. Invoices: %s%n", getInvoicesSum(), invoiceStack);

    }

    private void processAccountantInput(String command) {
        System.out.printf("%n%s%n", command);
        if(invoiceStack.isEmpty()){
            System.out.println("Stack is empty. No work for Acount");
            return;
        }
        Invoice invoice = invoiceStack.pop();

        System.out.printf("ACCOUNTANT processed invoice:%s%n", invoice);
        System.out.printf("Current invoices amount: %s. Invoices: %s%n%n",getInvoicesSum(), invoiceStack);
    }

    private String getInvoicesSum() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Invoice invoice : invoiceStack) {
            sum = sum.add(invoice.getAmount());
        }
        return sum.toString();
    }


}
