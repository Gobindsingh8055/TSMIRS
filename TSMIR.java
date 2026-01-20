// ==================== MODEL CLASSES ====================

// Tourist.java
package com.touristsafety.model;

public class Tourist {
    private String id;
    private String name;
    private String country;
    private Location location;
    private String status;
    private String blockchainId;

    public Tourist() {}

    public Tourist(String id, String name, String country, Location location, String status, String blockchainId) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.location = location;
        this.status = status;
        this.blockchainId = blockchainId;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getBlockchainId() { return blockchainId; }
    public void setBlockchainId(String blockchainId) { this.blockchainId = blockchainId; }
}

// Location.java
package com.touristsafety.model;

public class Location {
    private double lat;
    private double lng;

    public Location() {}

    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() { return lat; }
    public void setLat(double lat) { this.lat = lat; }
    
    public double getLng() { return lng; }
    public void setLng(double lng) { this.lng = lng; }
}

// Incident.java
package com.touristsafety.model;

public class Incident {
    private String id;
    private String type;
    private String severity;
    private String location;
    private String time;
    private String status;

    public Incident() {}

    public Incident(String id, String type, String severity, String location, String time, String status) {
        this.id = id;
        this.type = type;
        this.severity = severity;
        this.location = location;
        this.time = time;
        this.status = status;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

// Alert.java
package com.touristsafety.model;

public class Alert {
    private String id;
    private String message;
    private String severity;
    private String time;

    public Alert() {}

    public Alert(String id, String message, String severity, String time) {
        this.id = id;
        this.message = message;
        this.severity = severity;
        this.time = time;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
}

// SafeZone.java
package com.touristsafety.model;

public class SafeZone {
    private int id;
    private String name;
    private double lat;
    private double lng;
    private double radius;
    private String status;

    public SafeZone() {}

    public SafeZone(int id, String name, double lat, double lng, double radius, String status) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.radius = radius;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public double getLat() { return lat; }
    public void setLat(double lat) { this.lat = lat; }
    
    public double getLng() { return lng; }
    public void setLng(double lng) { this.lng = lng; }
    
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

// ==================== SERVICE CLASSES ====================

// TouristSafetyService.java
package com.touristsafety.service;

import com.touristsafety.model.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TouristSafetyService {
    private List<Tourist> tourists;
    private List<Incident> incidents;
    private List<Alert> alerts;
    private List<SafeZone> safeZones;

    public TouristSafetyService() {
        initializeData();
    }

    private void initializeData() {
        // Initialize tourists
        tourists = new ArrayList<>();
        tourists.add(new Tourist("T001", "John Smith", "USA", 
            new Location(28.6139, 77.2090), "safe", "0x7a9f...3c2e"));
        tourists.add(new Tourist("T002", "Maria Garcia", "Spain", 
            new Location(28.6562, 77.2410), "safe", "0x4b1c...8d9a"));
        tourists.add(new Tourist("T003", "Li Wei", "China", 
            new Location(28.6289, 77.2065), "alert", "0x9e2f...1a4b"));

        // Initialize incidents
        incidents = new ArrayList<>();
        incidents.add(new Incident("INC001", "Medical", "medium", 
            "Market Area", "10 min ago", "responding"));
        incidents.add(new Incident("INC002", "Theft Report", "low", 
            "Tourist District", "1 hr ago", "resolved"));

        // Initialize alerts
        alerts = new ArrayList<>();
        alerts.add(new Alert("A001", "Tourist T003 entered restricted zone", 
            "warning", "5 min ago"));
        alerts.add(new Alert("A002", "Crowding detected in Heritage Zone", 
            "info", "15 min ago"));

        // Initialize safe zones
        safeZones = new ArrayList<>();
        safeZones.add(new SafeZone(1, "Tourist District", 28.6139, 77.2090, 2.0, "safe"));
        safeZones.add(new SafeZone(2, "Heritage Zone", 28.6562, 77.2410, 1.5, "safe"));
        safeZones.add(new SafeZone(3, "Market Area", 28.6289, 77.2065, 1.0, "caution"));
    }

    // Tourist methods
    public List<Tourist> getAllTourists() {
        return tourists;
    }

    public Tourist getTouristById(String id) {
        return tourists.stream()
            .filter(t -> t.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public long getSafeTouristsCount() {
        return tourists.stream()
            .filter(t -> "safe".equals(t.getStatus()))
            .count();
    }

    public long getAlertTouristsCount() {
        return tourists.stream()
            .filter(t -> "alert".equals(t.getStatus()))
            .count();
    }

    public Tourist addTourist(Tourist tourist) {
        tourists.add(tourist);
        return tourist;
    }

    public Tourist updateTourist(String id, Tourist updatedTourist) {
        for (int i = 0; i < tourists.size(); i++) {
            if (tourists.get(i).getId().equals(id)) {
                updatedTourist.setId(id);
                tourists.set(i, updatedTourist);
                return updatedTourist;
            }
        }
        return null;
    }

    // Incident methods
    public List<Incident> getAllIncidents() {
        return incidents;
    }

    public long getActiveIncidentsCount() {
        return incidents.stream()
            .filter(i -> "responding".equals(i.getStatus()))
            .count();
    }

    public Incident addIncident(Incident incident) {
        incidents.add(incident);
        return incident;
    }

    // Alert methods
    public List<Alert> getAllAlerts() {
        return alerts;
    }

    public Alert addAlert(Alert alert) {
        alerts.add(alert);
        return alert;
    }

    // Safe zone methods
    public List<SafeZone> getAllSafeZones() {
        return safeZones;
    }

    public SafeZone getSafeZoneById(int id) {
        return safeZones.stream()
            .filter(z -> z.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public SafeZone addSafeZone(SafeZone zone) {
        safeZones.add(zone);
        return zone;
    }

    // Geo-fencing logic
    public boolean checkGeoFenceBreach(Tourist tourist) {
        for (SafeZone zone : safeZones) {
            double distance = calculateDistance(
                tourist.getLocation().getLat(), 
                tourist.getLocation().getLng(),
                zone.getLat(), 
                zone.getLng()
            );
            
            if (distance > zone.getRadius() && "safe".equals(zone.getStatus())) {
                return true; // Breach detected
            }
        }
        return false;
    }

    // Calculate distance between two coordinates (Haversine formula)
    private double calculateDistance(double lat1, double lng1, double lat2, double lng2) {
        final int R = 6371; // Earth's radius in km
        
        double latDistance = Math.toRadians(lat2 - lat1);
        double lngDistance = Math.toRadians(lng2 - lng1);
        
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
        
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
        return R * c;
    }
}

// ==================== REST CONTROLLER ====================

// TouristSafetyController.java
package com.touristsafety.controller;

import com.touristsafety.model.*;
import com.touristsafety.service.TouristSafetyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TouristSafetyController {

    @Autowired
    private TouristSafetyService service;

    // Dashboard endpoint
    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> getDashboard() {
        Map<String, Object> dashboard = new HashMap<>();
        dashboard.put("totalTourists", service.getAllTourists().size());
        dashboard.put("safeTourists", service.getSafeTouristsCount());
        dashboard.put("alertTourists", service.getAlertTouristsCount());
        dashboard.put("activeIncidents", service.getActiveIncidentsCount());
        dashboard.put("tourists", service.getAllTourists());
        dashboard.put("incidents", service.getAllIncidents());
        dashboard.put("alerts", service.getAllAlerts());
        return ResponseEntity.ok(dashboard);
    }

    // Tourist endpoints
    @GetMapping("/tourists")
    public ResponseEntity<List<Tourist>> getAllTourists() {
        return ResponseEntity.ok(service.getAllTourists());
    }

    @GetMapping("/tourists/{id}")
    public ResponseEntity<Tourist> getTouristById(@PathVariable String id) {
        Tourist tourist = service.getTouristById(id);
        if (tourist != null) {
            return ResponseEntity.ok(tourist);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/tourists")
    public ResponseEntity<Tourist> addTourist(@RequestBody Tourist tourist) {
        Tourist created = service.addTourist(tourist);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/tourists/{id}")
    public ResponseEntity<Tourist> updateTourist(@PathVariable String id, @RequestBody Tourist tourist) {
        Tourist updated = service.updateTourist(id, tourist);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // Incident endpoints
    @GetMapping("/incidents")
    public ResponseEntity<List<Incident>> getAllIncidents() {
        return ResponseEntity.ok(service.getAllIncidents());
    }

    @PostMapping("/incidents")
    public ResponseEntity<Incident> addIncident(@RequestBody Incident incident) {
        Incident created = service.addIncident(incident);
        return ResponseEntity.ok(created);
    }

    // Alert endpoints
    @GetMapping("/alerts")
    public ResponseEntity<List<Alert>> getAllAlerts() {
        return ResponseEntity.ok(service.getAllAlerts());
    }

    @PostMapping("/alerts")
    public ResponseEntity<Alert> addAlert(@RequestBody Alert alert) {
        Alert created = service.addAlert(alert);
        return ResponseEntity.ok(created);
    }

    // Safe zone endpoints
    @GetMapping("/safezones")
    public ResponseEntity<List<SafeZone>> getAllSafeZones() {
        return ResponseEntity.ok(service.getAllSafeZones());
    }

    @GetMapping("/safezones/{id}")
    public ResponseEntity<SafeZone> getSafeZoneById(@PathVariable int id) {
        SafeZone zone = service.getSafeZoneById(id);
        if (zone != null) {
            return ResponseEntity.ok(zone);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/safezones")
    public ResponseEntity<SafeZone> addSafeZone(@RequestBody SafeZone zone) {
        SafeZone created = service.addSafeZone(zone);
        return ResponseEntity.ok(created);
    }

    // Geo-fencing check
    @PostMapping("/geofence/check/{touristId}")
    public ResponseEntity<Map<String, Boolean>> checkGeoFence(@PathVariable String touristId) {
        Tourist tourist = service.getTouristById(touristId);
        if (tourist == null) {
            return ResponseEntity.notFound().build();
        }
        
        boolean breached = service.checkGeoFenceBreach(tourist);
        Map<String, Boolean> result = new HashMap<>();
        result.put("breached", breached);
        return ResponseEntity.ok(result);
    }
}

// ==================== MAIN APPLICATION ====================

// TouristSafetyApplication.java
package com.touristsafety;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TouristSafetyApplication {
    public static void main(String[] args) {
        SpringApplication.run(TouristSafetyApplication.class, args);
    }
}

// ==================== APPLICATION PROPERTIES ====================
/*
# application.properties
server.port=8080
spring.application.name=tourist-safety-system

# Enable CORS
spring.web.cors.allowed-origins=*
spring.web.cors.allowed-methods=GET,POST,PUT,DELETE
spring.web.cors.allowed-headers=*
*/

// ==================== POM.XML (Maven Dependencies) ====================
/*
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.0</version>
    </parent>
    
    <groupId>com.touristsafety</groupId>
    <artifactId>tourist-safety-system</artifactId>
    <version>1.0.0</version>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
*/