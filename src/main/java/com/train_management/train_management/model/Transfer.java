package com.train_management.train_management.model;

import javax.persistence.*;

@Entity
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_stop_id")
    private String fromStopId;

    @Column(name = "to_stop_id")
    private String toStopId;

    @Column(name = "transfer_type")
    private Integer transferType; // e.g., 0=Recommended transfer, 1=Timed transfer, 2=Minimum time needed to transfer, 3=Not possible

    @Column(name = "min_transfer_time")
    private Integer minTransferTime; // Minimum time required in seconds to transfer

    // Standard getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromStopId() {
        return fromStopId;
    }

    public void setFromStopId(String fromStopId) {
        this.fromStopId = fromStopId;
    }

    public String getToStopId() {
        return toStopId;
    }

    public void setToStopId(String toStopId) {
        this.toStopId = toStopId;
    }

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }

    public Integer getMinTransferTime() {
        return minTransferTime;
    }

    public void setMinTransferTime(Integer minTransferTime) {
        this.minTransferTime = minTransferTime;
    }

    // toString, hashCode, equals, and other methods (if necessary)
}
