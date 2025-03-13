# Priority-Based Patient Management System

## Overview
This project implements a **priority-based patient management system** using data structures like **Heap, Queue, and LinkedList** to efficiently handle patient records. Patients are added to the system with an assigned **priority** and **VIP status**, and they can be retrieved based on either their **priority** or **arrival order**.

## Features
- **Heap (Max Heap)**: Stores patients based on priority.
- **Queue (FIFO)**: Tracks patients based on arrival order.
- **LinkedList**: Implements a custom singly linked list for the queue.
- **Manager**: Handles both data structures and allows retrieval by priority or creation time.
- **Patient**: Represents a patient with attributes like priority, VIP status, unique ID, and creation time.
- **Simulations**:
  - Adding random patients.
  - Retrieving patients by priority.
  - Retrieving patients by creation time.

The system allows:
- Adding patients with a priority and VIP status.
- Retrieving patients either by **highest priority** or **earliest arrival time**.
- Simulating different scenarios through the `Main` class.
