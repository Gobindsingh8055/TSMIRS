# TSMIRS
Tourist Safety Monitoring &amp; Incident Response System


Project Structure:
1. Model Classes (Data Objects)

Tourist.java - Represents tourist data
Location.java - GPS coordinates
Incident.java - Safety incidents
Alert.java - System alerts
SafeZone.java - Geo-fenced areas

2. Service Layer (TouristSafetyService.java)

Business logic for managing tourists, incidents, alerts, and safe zones
Geo-fencing calculations using Haversine formula
Data filtering and statistics

3. REST API Controller (TouristSafetyController.java)

/api/dashboard - Get all dashboard data
/api/tourists - CRUD operations for tourists
/api/incidents - Manage incidents
/api/alerts - Manage alerts
/api/safezones - Manage geo-fenced zones
/api/geofence/check/{touristId} - Check if tourist breached zones

4. Main Application (TouristSafetyApplication.java)

Spring Boot entry point

Key Differences from JavaScript:
JavaScript/ReactJavaconst, letStrongly typed variablesFunctionsMethods with return typesState hooksService classes with ListsComponent renderingREST API endpointsNo compilationCompiled to bytecode
How to Run:

Install Prerequisites:

Java 17+ (JDK)
Maven or Gradle


Build the project:


=======


Project Structure:
1. Model Classes (Data Objects)

Tourist.java - Represents tourist data
Location.java - GPS coordinates
Incident.java - Safety incidents
Alert.java - System alerts
SafeZone.java - Geo-fenced areas

2. Service Layer (TouristSafetyService.java)

Business logic for managing tourists, incidents, alerts, and safe zones
Geo-fencing calculations using Haversine formula
Data filtering and statistics

3. REST API Controller (TouristSafetyController.java)

/api/dashboard - Get all dashboard data
/api/tourists - CRUD operations for tourists
/api/incidents - Manage incidents
/api/alerts - Manage alerts
/api/safezones - Manage geo-fenced zones
/api/geofence/check/{touristId} - Check if tourist breached zones

4. Main Application (TouristSafetyApplication.java)

Spring Boot entry point

Key Differences from JavaScript:
JavaScript/ReactJavaconst, letStrongly typed variablesFunctionsMethods with return typesState hooksService classes with ListsComponent renderingREST API endpointsNo compilationCompiled to bytecode
How to Run:

Install Prerequisites:

Java 17+ (JDK)
Maven or Gradle


Build the project:


