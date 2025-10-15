# Ansible Initial Setup Guide

## Objectives

- Install and configure Ansible on the control machine
- Enable passwordless SSH access to the target node(s)
- Define a simple inventory file
- Run a test ad-hoc command to verify setup

## Steps

1. **Install Ansible** on the control node:

   ```bash
   # For Debian/Ubuntu
   sudo apt update && sudo apt install -y ansible
   
2. **Generate an SSH Key Pair** on the control node:

    ```bash
    ssh-keygen -t ed25519

3. **Copy the SSH Public Key** to the managed node:
   ```bash
   ssh-copy-id username@<managed_node_ip>
   
4. **Create an Inventory File** `inventory.ini`:
   ```ini
   [hosts]
   192.168.230.130
   
   
5. **Test Connectivity with an Ad-Hoc Command:**
   ```bash
   ansible webservers -i inventory.ini -m ping

   
