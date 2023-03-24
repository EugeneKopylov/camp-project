package my.app.model;

public enum UserRole {
    ADMINISTRATOR("Administrator"),
    SALE_USER("Sale User"),
    CUSTOMER_USER("Customer User"),
    Secure_API_USER("Secure API User");

    private final String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
