package model;

import java.time.LocalDate;

/**
 * The shop class
 */
public class Shop {
    private String idConsumer;
    private LocalDate dateOperation;

    /**
     * <b>Constructor</b><br>
     * This method is the constructor of the class Shop.<br>
     */
    public Shop(String idConsumer) {
        this.idConsumer = idConsumer;
        dateOperation = LocalDate.now();
    }

    /**
     *
     * @return id consumer
     */
    public String getIdConsumer() {
        return idConsumer;
    }

    /**
     *
     * @param idConsumer The identifier of the consumer
     */
    public void setIdConsumer(String idConsumer) {
        this.idConsumer = idConsumer;
    }

    /**
     *
     * @return date operation
     */
    public LocalDate getDateOperation() {
        return dateOperation;
    }

    /**
     *
     * @param dateOperation The date operation of the shop
     */
    public void setDateOperation(LocalDate dateOperation) {
        this.dateOperation = dateOperation;
    }
}
