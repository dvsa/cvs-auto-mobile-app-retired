package util;

public class SessionDetails {

    private String session;
    private String name;
    private String status="passed";
    private String reason= "No issues";
    private String bsSessionUrl;

    public SessionDetails() {

    }

    public void setSession(String session) {
        this.session = session;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBsSessionUrl(String bsSessionUrl) { this.bsSessionUrl = bsSessionUrl; }

    public String getSession() {
        return session;
    }

    public String getReason() {
        return reason;
    }

    public String getName() {
        return name;
    }

    public String getStatus() { return status; }

    public String getBsSessionUrl() { return bsSessionUrl; }

}