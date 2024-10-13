package com.bartoszwalter.students.taxes;

public enum FeePercentValues {
    SOCIAL_SECURITY(9.76),
    HEALTH_INSURANCE(1.5),
    SICKNESS_INSURANCE(2.45),
    CURRENT_SOCIAL_HEALTH_INSURANCE(9),
    PREVIOUS_SOCIAL_HEALTH_INSURANCE(7.75),
    ADVANCE_TAX(18),
    DEDUCTABLE_EXPENSES(20);

    private final double percentage;

    FeePercentValues(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }
}
