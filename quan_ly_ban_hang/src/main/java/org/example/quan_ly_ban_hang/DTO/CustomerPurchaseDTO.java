package org.example.quan_ly_ban_hang.DTO;

public class CustomerPurchaseDTO {
    private int customerId;
    private String customerName;
    private int productCount;

    public CustomerPurchaseDTO(int customerId, String customerName, int productCount) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.productCount = productCount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
