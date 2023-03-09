package vn.edu.hcmuaf.fit.model;

public class ShippingCalculator {
    private double weight;
    private double distance;

    public ShippingCalculator(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }


    public double calculateShippingCost() {
        double ratePerKilo = 20000.0;
        double ratePerKm = 1200.0;
        double baseCost = 30000.0;
        double weightCost = weight * ratePerKilo;
        double distanceCost = distance * ratePerKm;
        double shippingCost = baseCost + weightCost + distanceCost;
        return shippingCost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public static void main(String[] args) {
        ShippingCalculator calculator = new ShippingCalculator(1.0, 50.0);
        double cost = calculator.calculateShippingCost();
        System.out.println("The shipping cost is: " + cost + " VND");
    }
}
