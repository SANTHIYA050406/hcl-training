# Vehicle Service Center Management System

## Overview

The Vehicle Service Center Management System is designed to manage the complete vehicle servicing workflow, from service-slot booking to final vehicle delivery. It helps service-center staff organize customer and vehicle details, job cards, technician assignments, spare-parts inventory, labour charges, estimates, invoices, and service history.

The system aims to reduce manual paperwork, improve service tracking, and maintain accurate records throughout the servicing process.

## Objectives

- Allow customers to book available service slots.
- Enable service advisors to create job cards and record customer complaints.
- Assign technicians to service jobs.
- Record spare parts and labour used during repairs.
- Allow customers to review and approve service estimates.
- Update spare-parts stock when parts are issued.
- Generate final invoices and maintain service history.

## Modules

### 1. Authentication and User Management (`auth-service`)

- User login and authentication.
- Role-based access for customers, service advisors, technicians, and administrators.
- User profile and permission management.

### 2. Customers and Vehicles (`customer-service`)

- Register and manage customer details.
- Register vehicles and associate them with their owners.
- Book service slots and maintain booking details.

### 3. Job Cards (`workshop-service`)

- Create job cards for booked vehicles.
- Record complaints and inspection findings.
- Assign technicians and track job status.

### 4. Parts Inventory (`workshop-service`)

- Maintain spare-parts details and stock quantities.
- Record parts issued for each job.
- Update inventory and prevent invalid stock deductions.

### 5. Billing and Service History (`workshop-service`)

- Record labour charges and spare-parts costs.
- Prepare estimates for customer approval.
- Generate final invoices after service completion.
- Allow customers to view previous service records and invoices.

## Functional Requirements

| ID | Requirement |
|---|---|
| FR1 | Customers can book a service slot. |
| FR2 | Service advisors can create job cards and record customer complaints and inspection details. |
| FR3 | Service advisors can assign technicians to job cards. |
| FR4 | Technicians can add spare-parts and labour details. |
| FR5 | Customers can review and approve service estimates before repairs begin. |
| FR6 | The system deducts spare-parts stock when parts are issued. |
| FR7 | Service advisors can close completed jobs and generate invoices. |
| FR8 | Customers can view their vehicle service history. |

## Non-Functional Requirements

- **Security:** Restrict features according to user roles.
- **Performance:** Process bookings and job updates within a reasonable response time.
- **Reliability:** Store service, inventory, and billing records accurately.
- **Usability:** Provide a clear interface for customers and service-center staff.
- **Data integrity:** Prevent invalid stock quantities and inconsistent job or invoice records.
- **Maintainability:** Organize the application into separate modules/services.
- **Availability:** Make the application accessible during service-center operating hours, subject to infrastructure availability.
- **Scalability:** Support growth in customers, vehicles, service jobs, and inventory.

## Proposed Architecture

The proposed design uses three backend services:

- **`auth-service`** — authentication, user roles, and permissions.
- **`customer-service`** — customer profiles, vehicle records, and service bookings.
- **`workshop-service`** — job cards, technician assignment, inventory, estimates, billing, and service history.

The web interface communicates with backend services through REST APIs. A relational database stores application records. Each service should have clearly defined responsibilities and controlled access to its data.

## Service Workflow

1. Customer books an available service slot.
2. Service advisor opens a job card and records complaints and inspection details.
3. Service advisor assigns a technician.
4. Technician records required/used spare parts and labour.
5. Customer reviews and approves the estimate.
6. Inventory is updated when spare parts are issued.
7. After the work is completed, the advisor closes the job and generates the invoice.
8. Customer can view the completed service in service history.

## Proposed Tools and Technologies

Use the technologies selected for the implementation; the following is a suggested stack.

- **Frontend:** HTML5, CSS3, JavaScript
- **Backend:** Java, Spring Boot, REST APIs
- **Database:** MySQL
- **Build and dependency management:** Maven
- **API testing:** Postman
- **IDE:** IntelliJ IDEA
- **Version control:** Git and GitHub

## Data Entities (Suggested)

- Users
- Customers
- Vehicles
- ServiceBookings
- JobCards
- Technicians
- Parts
- JobParts
- LabourDetails
- Estimates
- Invoices
- Payments

## Important Business Rules

- Repairs covered by an estimate should begin after customer approval.
- Additional work or cost changes should be approved before that extra work begins.
- Spare-parts stock should be deducted when parts are issued, not merely when they are listed in an estimate.
- A job should be closed and invoiced only after the service is completed.
- Access to sensitive actions should be controlled by user role.

## Project Status

This README describes the project scope and proposed design. Update the architecture, technology stack, setup instructions, screenshots, and implementation status to match the features actually completed.

## Future Enhancements

- SMS or email notifications for booking and service updates.
- Online payment integration.
- Low-stock alerts and inventory reports.
- Service reminders based on date or vehicle usage.
- Dashboard reports for service volume, revenue, and technician workload.

## Contributors

Add contributor names and roles here.
