package model;

import java.time.LocalDate;

public class Shop {
    private String idConsumer;
    private LocalDate dateOperation;

    public Shop(String idConsumer) {
        this.idConsumer = idConsumer;
        dateOperation = LocalDate.now();
    }

    public String getIdConsumer() {
        return idConsumer;
    }

    public void setIdConsumer(String idConsumer) {
        this.idConsumer = idConsumer;
    }

    public LocalDate getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(LocalDate dateOperation) {
        this.dateOperation = dateOperation;
    }
}
