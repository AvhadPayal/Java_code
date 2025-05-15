package com.sql.First_javaproject.model;



public class Shipping {
    public String carrier;
    public String status;
    public String delivery_estimate;

    

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelivery_estimate() {
        return delivery_estimate;
    }

    public void setDelivery_estimate(String delivery_estimate) {
        this.delivery_estimate = delivery_estimate;
    }
}
