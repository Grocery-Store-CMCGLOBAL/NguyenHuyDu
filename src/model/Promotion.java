package model;

public class Promotion {
    private String id;
    private Integer buyAmount;
    private Integer getAmount;

    public Promotion(Integer buyAmount, Integer getAmount) {
        this.id = "B"+buyAmount+"G"+getAmount;
        this.buyAmount = buyAmount;
        this.getAmount = getAmount;
    }

    public String getId() {
        return id;
    }

    public Integer getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(Integer buyAmount) {
        this.buyAmount = buyAmount;
    }

    public Integer getGetAmount() {
        return getAmount;
    }

    public void setGetAmount(Integer getAmount) {
        this.getAmount = getAmount;
    }

    @Override
    public String toString() {
        return "Promo Id:" + id + " - Buy " + buyAmount + " get " + getAmount + " free";
    }
}
