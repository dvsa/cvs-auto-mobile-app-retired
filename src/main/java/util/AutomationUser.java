package util;

import java.io.Serializable;
import java.util.Objects;

public class AutomationUser implements Serializable {
    private String email;
    private String staffId;
    private String password;

    public AutomationUser(String email, String staffId, String password) {
        this.email = email;
        this.staffId = staffId;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutomationUser that = (AutomationUser) o;
        return Objects.equals(email, that.email) && Objects.equals(staffId, that.staffId) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, staffId, password);
    }
}