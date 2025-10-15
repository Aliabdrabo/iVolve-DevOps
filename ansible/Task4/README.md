# Automated Web Server Configuration Using Ansible Playbooks

## Objectives

- Automate web server installation and configuration using Ansible
- Install and enable **Nginx** on a managed node
- Deploy a custom `index.html` page
- Verify that the web server is running correctly
---
1. **Create a vault**:
   ```bash
   ansible-vault create vault.yml

---   
2. Playbook: `sql-playbook.yml`
    ```yaml
    ---
    - name: Lab 4 - MySQL Setup on Ubuntu/Debian
      hosts: all
      become: yes
      vars_files:
        - vault.yml

      tasks:
        - name: Install MySQL server
          ansible.builtin.package:
            name: mysql-server
            state: present

        - name: Ensure MySQL service is running
          ansible.builtin.service:
            name: mysql
            state: started
            enabled: yes

        - name: Install PyMySQL library on Debian/Ubuntu
          ansible.builtin.apt:
            name: python3-pymysql
            state: present
            update_cache: yes

        - name: Create iVolve database
          community.mysql.mysql_db:
            name: iVolve
            state: present
            login_unix_socket: /var/run/mysqld/mysqld.sock

        - name: Create MySQL user with privileges on iVolve DB
          community.mysql.mysql_user:
            name: "{{ db_user }}"
            password: "{{ db_password }}"
            priv: "iVolve.*:ALL"
            host: "%"
            state: present
            login_unix_socket: /var/run/mysqld/mysqld.sock

---
3. **Create an Inventory File** `inventory.ini`:
   ```ini
   [hosts]
   192.168.230.130
---   
4. **Run** the Playbook:
   ```bash
   ansible-playbook -i inventory.ini playbook1.yml --ask-become-pass --ask-vault-pass
   
---  

   
