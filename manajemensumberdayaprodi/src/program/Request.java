/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

/**
 *
 * @author ACER
 */
public class Request {
    private String requesterName;
    private String resourceName;
    private String status;

    public Request(String requesterName, String resourceName) {
        this.requesterName = requesterName;
        this.resourceName = resourceName;
        this.status = "Pending";
    }

    public String getRequesterName() {
        return requesterName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getStatus() {
        return status;
    }

    public void approve() {
        status = "Approved";
    }

    public void reject() {
        status = "Rejected";
    }
}
