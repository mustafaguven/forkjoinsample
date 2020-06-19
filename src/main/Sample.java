package main;

import java.util.List;
import java.util.Random;

import static main.InvoiceState.*;

public class Sample {

    public static final int BOUND = 100;

    public static void main(String[] args) {
        Random random = new Random();
        List.of(
                new Invoice(random.nextInt(BOUND), "ALIMLER AS", FATURA_OLUSTURULDU),
                new Invoice(random.nextInt(BOUND), "YAKUPLAR GIDA", FATURA_OLUSTURULDU),
                new Invoice(random.nextInt(BOUND), "MUSTAFA DIS TICARET", FATURA_GONDERILDI),
                new Invoice(random.nextInt(BOUND), "AHMET KOOPERATIF", FATURA_OLUSTURULDU)
        )
                .parallelStream()
                .filter(it -> {
                    System.out.format("Filter Thread: [%s]\n", Thread.currentThread().getName());
                    return it.getState() == FATURA_OLUSTURULDU;
                })
                .forEach(it -> System.out.format("Foreach Thread: [%s] %s\n",
                        Thread.currentThread().getName(),
                        it));
    }
}
